package pl.wanderers.footprint.health;

import com.codahale.metrics.health.HealthCheck;

import java.util.Optional;

import pl.wanderers.footprint.core.Template;

/**
 * TemplateHealthCheck checks that the provided template is actually a well-formed format string, and that the template actually produces
 * output with the given name.
 */
public class TemplateHealthCheck extends HealthCheck {
    private final Template template;

    public TemplateHealthCheck(Template template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {

        final String saying = template.render(Optional.of("TEST"));
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }

        template.render(Optional.empty());

        return Result.healthy();
    }
}