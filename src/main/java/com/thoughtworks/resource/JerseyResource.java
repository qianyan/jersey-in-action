package com.thoughtworks.resource;

import com.thoughtworks.service.JerseyService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class JerseyResource {
    private final JerseyService service;

    @Inject
    public JerseyResource(JerseyService service) {
        this.service = service;
    }

    @GET
    public String greeting() {
        return "Hello " + service.getGreeting();
    }
}
