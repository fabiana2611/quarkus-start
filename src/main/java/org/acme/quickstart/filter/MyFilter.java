package org.acme.quickstart.filter;

import io.quarkus.vertx.http.runtime.filters.Filters;

import javax.enterprise.event.Observes;

public class MyFilter {
    // curl http://localhost:8080/ok -v
    public void filters(@Observes Filters filters) {
        filters
                .register(
                        rc -> {
                            rc.response()
                                    .putHeader("V-Header", "Header added by VertX Filter");
                            rc.next();
                        }, 10);
    }
}
