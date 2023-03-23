package org.acme.quickstart.controller;

//import io.agroal.api.AgroalDataSource;
//import io.quarkus.agroal.DataSource;
//
//import javax.enterprise.inject.Default;
//import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/datasource")
public class DatasourceResource {

//    @Inject
//    AgroalDataSource defaultDatasource;

//    @Inject
//    @DataSource("users")
//    DataSource datasourceUsers;

    // TEst: curl http://localhost:8080/datasource
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

}
