package org.acme.quickstart.infra;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.event.Event;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@LogEvent
@Interceptor
public class LogEventInterceptor {
//    private static final Logger log = LoggerFactory.getLogger(LogEventInterceptor.class);

    @AroundInvoke
    public Object logEvent(InvocationContext ctx) throws Exception {
//        log.info("###### Interceptor ....");
//        log.info(ctx.getMethod().getName());
//        log.info(Arrays.deepToString(ctx.getParameters()));
        return ctx.proceed();
    }
}
