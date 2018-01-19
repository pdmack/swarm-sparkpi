package io.radanalytics.examples.wfswarm;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/app")
public class SparkPiApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> classes = new HashSet<Class<?>>();

    public SparkPiApplication()
    {
        singletons.add(new SparkPiResource());
    }

    @Override
    public Set<Class<?>> getClasses()
    {
        return classes;
    }

    @Override
    public Set<Object> getSingletons()
    {
        return singletons;
    }
}
