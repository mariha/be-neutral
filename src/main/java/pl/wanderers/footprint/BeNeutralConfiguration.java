package pl.wanderers.footprint;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import javax.validation.ValidationException;
import javax.validation.constraints.NotEmpty;
import java.net.MalformedURLException;
import java.net.URL;

import pl.wanderers.footprint.core.Template;

public class BeNeutralConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @NotEmpty
    @org.hibernate.validator.constraints.URL
    private String databaseUrl;

    @NotEmpty
    private String iamKey;

    @NotEmpty
    // Only lowercase characters (a-z), digits (0-9), and any of the characters _, $, (, ), +, -, and / are allowed. Must begin with a
    // letter..
    private String dbName = "be-neutral";

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    public Template buildTemplate() {
        return new Template(template, defaultName);
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

    @JsonProperty
    public URL getDatabaseUrl() {
        try {
            return new URL(databaseUrl);
        } catch (MalformedURLException e) {
            throw new ValidationException("Invalid databaseUrl", e);
        }
    }

    @JsonProperty
    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    @JsonProperty
    public String getIamKey() {
        return iamKey;
    }

    @JsonProperty
    public void setIamKey(String iamKey) {
        this.iamKey = iamKey;
    }

    @JsonProperty
    public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
        return swaggerBundleConfiguration;
    }

    @JsonProperty
    public void setSwaggerBundleConfiguration(SwaggerBundleConfiguration swaggerBundleConfiguration) {
        this.swaggerBundleConfiguration = swaggerBundleConfiguration;
    }

    @JsonProperty
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    @JsonProperty
    public String getDbName() {
        return dbName;
    }
}
