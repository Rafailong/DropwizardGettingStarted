package com.gettingstarted;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class HomeResource {

    @GET
    @Timed
    public Object sayHello(){
        return "Home";
    }
}
