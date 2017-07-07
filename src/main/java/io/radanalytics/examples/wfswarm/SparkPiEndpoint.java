package io.radanalytics.examples.wfswarm;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/sparkpi")
public class SparkPiEndpoint {
    
    @GET
    @Produces("text/plain")
    public Response doGet() {
        SparkPiProducer pi = new SparkPiProducer();
        return Response.ok(pi.GetPi()).build();
    }

}
