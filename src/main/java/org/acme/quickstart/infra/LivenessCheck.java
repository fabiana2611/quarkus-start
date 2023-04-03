package org.acme.quickstart.infra;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

/**
 * Example get from Quarkus Cookbook
 */
@ApplicationScoped
@Liveness
public class LivenessCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder builder = HealthCheckResponse.named("custom liveness");

        if(isUpAndRunning()) {
            return builder.up().build();
        } else {
            return builder.down().build();
        }

    }

    private boolean isUpAndRunning(){
        return true;
    }
}
