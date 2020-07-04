package pl.wanderers.footprint.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * TemplateHealthCheck checks that the provided template is actually a well-formed format string, and that the template actually produces
 * output with the given name.
 */
public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}