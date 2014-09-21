package com.thoughtworks.resource;

import com.thoughtworks.service.JerseyService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class JerseyResource {
    private final JerseyService service;

    @Inject
    public JerseyResource(JerseyService service) {
        this.service = service;
    }

    @GET
    @Path("/people/{id}")
    public String greeting(@PathParam("id") int id) {
        return "Hello " + service.getPerson(id).getName();
    }
}
