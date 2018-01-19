package io.radanalytics.examples.wfswarm;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

@ApplicationScoped
public class SparkContextProvider {

    @Inject
    @ConfigurationValue("spark.submit.jarfile")
    String jarFile;

    private static final SparkContextProvider instance = new SparkContextProvider();

    private SparkConf sparkConf;
    private JavaSparkContext sparkContext;

    private SparkContextProvider() {
        this.sparkConf = new SparkConf().setAppName("WildFly Swarm SparkPi");
        this.sparkConf.setJars(new String[]{jarFile});
        this.sparkContext = new JavaSparkContext(sparkConf);
    }

    public static JavaSparkContext getContext() {
        return instance.sparkContext;
    }
}
