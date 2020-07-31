package pl.wanderers.footprint.health;

import com.codahale.metrics.health.HealthCheck;

import pl.wanderers.footprint.db.DatabaseService;

public class CloudantHealthCheck extends HealthCheck {

    private final DatabaseService dbService;

    public CloudantHealthCheck(DatabaseService dbService) {
        this.dbService = dbService;
    }

    @Override
    protected Result check() {
        if (!dbService.getClient().getAllDbs().isEmpty()) {
            return Result.unhealthy("No Databases!");
        }

        return Result.healthy();
    }
}
