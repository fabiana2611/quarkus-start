package org.acme.quickstart.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class MyContainerResponseFilter implements ContainerResponseFilter {
    // Test in console: curl localhost:8080/ok -v
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().add("JAX-RS-Header", "New Header");
    }
}
