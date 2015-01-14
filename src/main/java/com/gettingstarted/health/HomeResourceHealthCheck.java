package com.gettingstarted.health;

import com.codahale.metrics.health.HealthCheck;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

/**
 * @author rafailong
 */
public class HomeResourceHealthCheck extends HealthCheck {

    private final Client client;

    private final Long port;

    public HomeResourceHealthCheck(Client client, Long port) {
        super();
        this.client = client;
        this.port = port;
    }
    
    @Override
    protected Result check() throws Exception {
        WebResource r = client.resource("http://localhost:" + this.port + "/api/version");
        ClientResponse get = r.accept(MediaType.APPLICATION_JSON)
            .get(ClientResponse.class);
        if (get.getStatus() == 200) {
            return Result.healthy();
        }
        
        return Result.unhealthy("Version service is not responding!");
    }
}