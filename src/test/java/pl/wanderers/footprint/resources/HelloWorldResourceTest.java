package pl.wanderers.footprint.resources;

import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import pl.wanderers.footprint.api.Greetings;
import pl.wanderers.footprint.core.Template;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Unit tests for {@link HelloWorldResource}.
 */
@ExtendWith(DropwizardExtensionsSupport.class)
class HelloWorldResourceTest {
    public static final ResourceExtension RULE = ResourceExtension.builder()
            .addResource(new HelloWorldResource(new Template("Hello, %s!", "Stranger")))
            .build();

    @Test
    public void sayHelloSuccess() {
        Greetings found = RULE.target("/hello-world")
                .queryParam("name", "dude")
                .request()
                .get(Greetings.class);

        assertThat(found.getContent()).isEqualTo("Hello, dude!");
    }
}