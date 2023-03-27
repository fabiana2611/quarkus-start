package org.acme.quickstart.controller;

import org.acme.quickstart.domain.NoTransact;
import org.acme.quickstart.infra.ApplicationEventListener;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.TimeUnit;

@Path("/faulttolerance")
public class FaultToleranceResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(FaultToleranceResource.class);

    // Test: curl http://localhost:8080/faulttolerance
    @GET
    public String faultTolerance() {
        LOGGER.info("Starting process...");
        String result = test();
        //testWithTimeout();
        return result;
    }

    @Retry(maxRetries = 3, delay = 1000)
    @Timeout(value = 2000)
    @Fallback(RecoverFaultToleranceFallback.class)
    public String test() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            LOGGER.error("Exception....");
        }
        int x = 2 / 0;
        return "X:" + x;
    }

}
