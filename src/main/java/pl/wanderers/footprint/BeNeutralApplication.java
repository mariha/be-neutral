package pl.wanderers.footprint;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import pl.wanderers.footprint.db.DatabaseService;
import pl.wanderers.footprint.db.SolutionDAO;
import pl.wanderers.footprint.health.CloudantHealthCheck;
import pl.wanderers.footprint.health.TemplateHealthCheck;
import pl.wanderers.footprint.resources.HelloWorldResource;
import pl.wanderers.footprint.resources.SolutionsResource;

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
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(true)));

        bootstrap.addBundle(new SwaggerBundle<BeNeutralConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(BeNeutralConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });

        bootstrap.addBundle(new AssetsBundle("/assets/", "/", "index.html"));
    }

    @Override
    public void run(final BeNeutralConfiguration configuration,
                    final Environment environment) {
        DatabaseService dbService = new DatabaseService(configuration);
        SolutionDAO solutionDAO = new SolutionDAO(dbService);

        final HelloWorldResource resource = new HelloWorldResource(configuration.buildTemplate());
        environment.jersey().register(resource);

        SolutionsResource solutions = new SolutionsResource(solutionDAO);
        environment.jersey().register(solutions);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.buildTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.healthChecks().register("cloudant", new CloudantHealthCheck(dbService));

    }

}
