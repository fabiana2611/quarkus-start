package org.acme.quickstart.controller;

import org.acme.quickstart.domain.book.Book;
import org.acme.quickstart.infra.SpainLocale;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Locale;

@Path("/qualifier")
public class QualifierResource {

    @Inject
    @Named("en_US")
    Locale en_US;

    @Inject
    @Named("es_ES")
    Locale es_ES;

    @Inject
    @SpainLocale
    Locale spain;

    @GET
    @Path("/{locale}")
    public String getGreeting(@PathParam("locale") String locale) {
        if (locale.startsWith("en"))
            return "Hello from " + en_US.getDisplayCountry();
        if (locale.startsWith("es"))
            return "Hola desde " + es_ES.getDisplayCountry() + " - " + spain.getDisplayCountry();
        return "Unknown locale";
    }

}
