package org.acme.quickstart.controller;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

public class RecoverFaultToleranceFallback implements FallbackHandler<String> {
    @Override
    public String handle(ExecutionContext executionContext) {
        return "see you later, alligator";
    }
}
