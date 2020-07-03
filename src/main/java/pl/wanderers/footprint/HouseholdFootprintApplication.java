package pl.wanderers.footprint;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HouseholdFootprintApplication extends Application<HouseholdFootprintConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HouseholdFootprintApplication().run(args);
    }

    @Override
    public String getName() {
        return "Household Footprint";
    }

    @Override
    public void initialize(final Bootstrap<HouseholdFootprintConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HouseholdFootprintConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
