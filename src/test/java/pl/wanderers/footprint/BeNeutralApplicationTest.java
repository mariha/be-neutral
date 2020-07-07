package pl.wanderers.footprint;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import pl.wanderers.footprint.api.Greetings;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(DropwizardExtensionsSupport.class)
public class BeNeutralApplicationTest {

    private static final String CONFIG_PATH = ResourceHelpers.resourceFilePath("test-config.yml");

    public static final DropwizardAppExtension<BeNeutralConfiguration> APP_EXTENSION =
            new DropwizardAppExtension<>(BeNeutralApplication.class, CONFIG_PATH);

    @IntegrationTest
    public void testHelloWorld() {
        final Optional<String> name = Optional.of("Dr. IntegrationTest");
        final Greetings saying = APP_EXTENSION.client().target("http://localhost:" + APP_EXTENSION.getLocalPort() + "/hello-world")
                .queryParam("name", name.get())
                .request()
                .get(Greetings.class);
        assertThat(saying.getContent()).isEqualTo(APP_EXTENSION.getConfiguration().buildTemplate().render(name));
    }

    @IntegrationTest
    public void testLogFileWritten() throws IOException {
        // The log file is using a size and time based policy, which used to silently
        // fail (and not write to a log file). This test ensures not only that the
        // log file exists, but also contains the log line that jetty prints on startup
        final Path log = Paths.get("./logs/application.log");
        assertThat(log).exists();
        final String actual = Files.readString(log, UTF_8);
        assertThat(actual).contains("0.0.0.0:" + APP_EXTENSION.getLocalPort());
    }
}
