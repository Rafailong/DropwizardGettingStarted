package com.gettingstarted.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by sergionearbpo on 9/8/14.
 */
public class TemplateHealthCheck extends HealthCheck {
    private String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST"))
            return Result.unhealthy("template does not include a name");

        return Result.healthy();
    }
}
