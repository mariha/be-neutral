package pl.wanderers.footprint.db;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

import java.net.URL;

import pl.wanderers.footprint.BeNeutralConfiguration;

public class DatabaseService {

    private final CloudantClient client;
    private final Database db;

    public DatabaseService(BeNeutralConfiguration configuration) {

        URL url = configuration.getDatabaseUrl();
        String iamApiKey = configuration.getIamKey();
        String dbName = configuration.getDbName();

        client = ClientBuilder.url(url)
                .iamApiKey(iamApiKey)
                .build();

        db = client.database(dbName, true);
    }

    public CloudantClient getClient() {
        return client;
    }

    public Database getDb() {
        return db;
    }
}
