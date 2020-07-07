package pl.wanderers.footprint;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import pl.wanderers.footprint.health.TemplateHealthCheck;
import pl.wanderers.footprint.resources.HelloWorldResource;

public class BeNeutralApplication extends Application<BeNeutralConfiguration> {

    public static void main(final String[] args) throws Exception {
        new BeNeutralApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(final Bootstrap<BeNeutralConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final BeNeutralConfiguration configuration,
                    final Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(configuration.buildTemplate());
        environment.jersey().register(resource);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.buildTemplate());
        environment.healthChecks().register("template", healthCheck);
    }

}
