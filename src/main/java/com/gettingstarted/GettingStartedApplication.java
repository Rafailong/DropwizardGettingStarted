package com.gettingstarted;

import com.gettingstarted.health.*;
import io.dropwizard.*;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.DefaultClientConfig;

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
        final HomeResource homeResource = new HomeResource();
        final TemplateHealthCheck templateHealthCheck = new TemplateHealthCheck(
                gettingStartedConfiguration.getTemplate()
        );

        // DefaultClientConfig conf = new DefaultClientConfig();
        // Client client = Client.create(conf);
        // final HomeResourceHealthCheck homeResourceHealthCheck = new HomeResourceHealthCheck(
        //     client, 
        //     gettingStartedConfiguration.getHealtChecksPort()
        // );

        environment.healthChecks().register("template", templateHealthCheck);
        // environment.healthChecks().register("HomeResource", homeResourceHealthCheck);
        environment.jersey().register(helloWorldResource);
        environment.jersey().register(homeResource);
    }
}
