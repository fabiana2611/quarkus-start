package org.acme.quickstart.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.quickstart.domain.NoTransact;

@Path("/transaction")
@Transactional
public class TransactResource {

    @Inject
    NoTransact noTx;

    @GET
    public String transact(){
        return "Transaction";
    }

    @GET
    @Path("/no")
    @Produces(MediaType.TEXT_PLAIN)
    public String hi() {
        return noTx.word();
    }
}
