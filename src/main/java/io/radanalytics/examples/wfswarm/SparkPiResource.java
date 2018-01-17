package io.radanalytics.examples.wfswarm;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/")
public class SparkPiResource {

    @GET
    @Produces("text/plain")
    public Response getDefault() {
        return Response.ok("WildFly Swarm SparkPi server ready.\nAdd /sparkpi to invoke Pi computation.").build();
    }

    @GET
    @Path("/sparkpi")
    @Produces("text/plain")
    public Response getPi() {
        SparkPiProducer pi = new SparkPiProducer();
        return Response.ok(pi.getPi()).build();
    }

}
