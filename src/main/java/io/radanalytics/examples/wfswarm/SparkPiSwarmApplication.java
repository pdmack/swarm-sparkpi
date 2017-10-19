package io.radanalytics.examples.wfswarm;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/app")
public class SparkPiSwarmApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new LinkedHashSet<Class<?>>();
        resources.add(DefaultEndpoint.class);
        resources.add(SparkPiEndpoint.class);
        return resources;
    }
}

