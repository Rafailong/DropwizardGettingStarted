package com.gettingstarted;

import com.gettingstarted.health.TemplateHealthCheck;
import io.dropwizard.*;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by sergionearbpo on 9/8/14.
 */
public class GettingStartedApplication extends Application<GettingStartedConfiguration> {

    public static void main(String[] args) throws Exception {
        new GettingStartedApplication().run(args);
    }

    @Override
    public String getName() {
        return "getting started with drop wizard";
    }

    @Override
    public void initialize(Bootstrap<GettingStartedConfiguration> gettingStartedConfigurationBootstrap) {

    }

    @Override
    public void run(GettingStartedConfiguration gettingStartedConfiguration, Environment environment) throws Exception {
        final HelloWorldResource helloWorldResource = new HelloWorldResource(
                gettingStartedConfiguration.getDefaultName(),
                gettingStartedConfiguration.getTemplate()
        );
        final TemplateHealthCheck templateHealthCheck = new TemplateHealthCheck(
                gettingStartedConfiguration.getTemplate()
        );

        environment.healthChecks().register("template", templateHealthCheck);
        environment.jersey().register(helloWorldResource);
    }
}
