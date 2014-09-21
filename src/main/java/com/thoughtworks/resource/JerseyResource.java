package com.thoughtworks.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class JerseyResource {
    @GET
    public String greeting() {
        return "Hello jersey";
    }
}
