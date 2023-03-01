package org.acme.quickstart.controller;

import org.acme.quickstart.infra.LogEvent;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/logevent")
public class LogResource {

        /*
    Every time the executeOrder method is called, the method in the interceptor that is
annotated with @javax.interceptor.AroundInvoke, logEvent in this case, will be
called before the actual executeOrder method is called.
     */
    @LogEvent
    @GET
    public void executeOrder(Object order) {
        System.out.println("@@@@@@");
    }
}
