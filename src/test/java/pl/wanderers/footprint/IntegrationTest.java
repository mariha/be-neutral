package pl.wanderers.footprint;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Tag used to mark tests which verify integration of the system with some external services: database (containerized), other services over
 * the network, filesystem, ... They may run longer then unit tests, which would rather mock/stub these services.
 * <p>
 * Tests using test-containers start the DB in Docker container and exercise inter-operation with the database. Tests using
 * DropwizardAppExtension build and deploy the app, and then use standard http communication to talk with clients and external services.
 * Delays, requests and responses are real, nothing is mocked or stubbed.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Tag("integration-test")
@Test
public @interface IntegrationTest {
}
