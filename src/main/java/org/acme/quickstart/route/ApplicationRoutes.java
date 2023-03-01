package org.acme.quickstart.route;

import io.quarkus.vertx.web.Route;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class ApplicationRoutes {

    // Test in console:  $ curl http://localhost:8080/ok
    public void routes(@Observes Router router) {
        router.get("/ok").handler(rc -> rc.response().end("OK from Route"));
    }

    // Test in console:  $ curl http://localhost:8080/declarativeok\?myAttribute\=test
    @Route(path = "/declarativeok", methods = HttpMethod.GET)
    public void routesWithAnnotation(RoutingContext routingContext){
        String myAttribute = routingContext.request().getParam("myAttribute");
        routingContext.response().end("Declarative OK: " + myAttribute);
    }

}
