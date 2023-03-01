package org.acme.quickstart.controller;

import org.acme.quickstart.domain.percentage.Percentage;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/percentage")
public class ConverterResource {

    @ConfigProperty(name = "greeting.percentage")
    Percentage percentage;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public double percentage() {
        return percentage.getPercentage();
    }

}
