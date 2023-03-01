package org.acme.quickstart.controller;

import org.acme.quickstart.domain.computer.Computer;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/validate")
public class ValidateResource {

    private static final List<Computer> computers = new ArrayList<>();

    /*
    curl \
    -d '<computer><brand>iMac</brand><serialNumber>111-111-111</serialNumber></computer>' \
    -H "Content-Type: application/xml" -X POST http://localhost:8080/validate/computers
     */
    @POST
    @Path("/computers")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response addComputer(@Valid Computer computer) {
        computers.add(computer);
        System.out.println("######: " + computers.size());
        return Response.ok().build();
    }

    /*
    curl localhost:8080/validate/computers
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?><collection><computer>
    <brand>iMac</brand><serialNumber>111-111-111</serialNumber>
    </computer></collection>
     */
    @GET
    @Path("/computers")
    @Produces(MediaType.TEXT_PLAIN)
    public @Valid List<Computer> getComputers() {
        return computers;
    }

}
