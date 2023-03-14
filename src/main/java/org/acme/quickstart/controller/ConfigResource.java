package org.acme.quickstart.controller;

import org.acme.quickstart.domain.invoice.Invoice;
import org.acme.quickstart.domain.invoice.InvoiceConfiguration;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
public class ConfigResource {

    static org.jboss.logging.Logger JBOSS_LOGGER = org.jboss.logging.Logger.getLogger(ConfigResource.class);
    static java.util.logging.Logger JUL_LOGGER = java.util.logging.Logger.getLogger(ConfigResource.class.getName());
    static org.apache.commons.logging.Log COMMONS_LOGGING = org.apache.commons.logging.LogFactory.getLog(ConfigResource.class);
    static org.slf4j.Logger SLF4J_LOGGER = org.slf4j.LoggerFactory.getLogger(ConfigResource.class);

    static {
        //No matter which one you use, or which one a third-party framework uses, all the logs will be
        //merged by Quarkus
        JBOSS_LOGGER.info("Trace produced by JBoss Logger");
        JUL_LOGGER.info("Trace produced by JUL");
        COMMONS_LOGGING.info("Trace produced by Commons Logging");
        SLF4J_LOGGER.info("Trace produced by SLF4J");
    }

    @Inject
    Config config;

    @Inject
    InvoiceConfiguration invoiceConfiguration;

    @ConfigProperty(name = "greeting.message")
    String message;

    @ConfigProperty(name = "greeting.suffix")
    List<String> suffixes;

    // Test: curl http://localhost:8080/hello/message
    @GET
    @Path("/message")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloMessage() {
        return message + suffixes.get(1);
    }

    @GET
    @Path("/invoice")
    public Float invoice() {
        Float value1 = config.getValue("invoice.vatRate", Float.class);
        Config configLocal = ConfigProvider.getConfig();
        Float value2 = configLocal.getValue("invoice.vatRate", Float.class);
        Float value3 = invoiceConfiguration.vatRate;
        return value1 + value2 + value3;
    }

    // TEst: curl http://localhost:8080/hello
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}
