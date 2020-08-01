package pl.wanderers.footprint;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.restassured.RestAssured;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import pl.wanderers.footprint.api.Greetings;

import static io.restassured.RestAssured.given;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

@ExtendWith(DropwizardExtensionsSupport.class)
public class BeNeutralApplicationTest {

    private static final String CONFIG_PATH = ResourceHelpers.resourceFilePath("test-config.yml");

    public static final DropwizardAppExtension<BeNeutralConfiguration> APP_EXT =
            new DropwizardAppExtension<>(BeNeutralApplication.class, CONFIG_PATH);

    @BeforeAll
    static void init() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @IntegrationTest
    public void testHelloWorld() {
        final Optional<String> name = Optional.of("Dr. IntegrationTest");

        final Greetings saying =
            given()
                .formParam("name", name.get())
            .when()
                .get("hello-world")
            .then()
                //.log().all()
                .statusCode(HttpStatus.OK_200)
                .extract()
                .as(Greetings.class);

        assertThat(saying.getContent()).isEqualTo(APP_EXT.getConfiguration().buildTemplate().render(name));
    }

    @IntegrationTest
    public void testLogFileWritten() throws IOException {
        // The log file is using a size and time based policy, which used to silently
        // fail (and not write to a log file). This test ensures not only that the
        // log file exists, but also contains the log line that jetty prints on startup
        final Path log = Paths.get("./logs/application.log");
        assertThat(log).exists();
        final String actual = new String(Files.readAllBytes(log), UTF_8);
        assertThat(actual).contains("0.0.0.0:" + APP_EXT.getLocalPort());
    }

    @IntegrationTest
    public void swaggerIsAvailable() {
        given()
        .when()
            .get("/swagger.json")
        .then()
            .statusCode(HttpStatus.OK_200)
            .body("paths./hello-world.get.operationId", equalTo("sayHello"))
            .body("definitions.Greetings", not(nullValue()));

        given()
        .when()
            .get("/swagger")
        .then()
            .statusCode(HttpStatus.OK_200)
            .body("html.head.title", equalTo("Swagger UI"));

        given()
        .when()
            .get("/swagger/")
        .then()
            .statusCode(HttpStatus.OK_200)
            .body("html.head.title", equalTo("Swagger UI"));
    }

    @IntegrationTest
    public void staticContentIsAvailable() {
        given()
        .when()
            .get("/")
        .then()
            .statusCode(HttpStatus.OK_200)
            .body("html.head.title", equalTo("Be Neutral"));

        given()
        .when()
            .get("/index.html")
        .then()
            .statusCode(HttpStatus.OK_200)
            .body("html.head.title", equalTo("Be Neutral"));
    }
}
