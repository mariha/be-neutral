package pl.wanderers.footprint;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import pl.wanderers.footprint.health.TemplateHealthCheck;
import pl.wanderers.footprint.resources.HelloWorldResource;

public class HouseholdFootprintApplication extends Application<HouseholdFootprintConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HouseholdFootprintApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(final Bootstrap<HouseholdFootprintConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HouseholdFootprintConfiguration configuration,
                    final Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(resource);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
    }

}
