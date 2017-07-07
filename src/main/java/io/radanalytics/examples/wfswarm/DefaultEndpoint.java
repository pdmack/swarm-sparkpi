package io.radanalytics.examples.wfswarm;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/")
public class DefaultEndpoint {
    
    @GET
    @Produces("text/plain")
    public Response doGet() {
        return Response.ok("WildFly Swarm SparkPi server ready").build();
    }

}

