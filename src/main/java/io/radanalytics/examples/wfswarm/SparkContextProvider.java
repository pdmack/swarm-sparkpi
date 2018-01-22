package io.radanalytics.examples.wfswarm;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.inject.Inject;
import javax.annotation.PostConstruct;

import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

@ApplicationScoped
public class SparkContextProvider {

    private SparkConf sparkConf;
    private JavaSparkContext javaSparkContext;

    @Inject
    @ConfigurationValue("spark.submit.jarfile")
    String appJarFile;

    public SparkContextProvider() {
        System.out.println("Constructor is called...");
    }

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        System.out.println("init is called...");
        this.sparkConf = new SparkConf().setAppName("WildFly Swarm SparkPi");
        this.sparkConf.setJars(new String[]{appJarFile});
        this.javaSparkContext = new JavaSparkContext(sparkConf);
    }

    public JavaSparkContext getContext() {
        return javaSparkContext;
    }

}
