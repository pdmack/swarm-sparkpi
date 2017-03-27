package io.radanalytics;

import javax.inject.Singleton;
import javax.ejb.Startup;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

@Singleton
@Startup
public class SparkContextProvider {
   private static final SparkContextProvider instance = new SparkContextProvider();

   private SparkConf sparkConf;
   private JavaSparkContext sparkContext;

   private SparkContextProvider() {
       this.sparkConf = new SparkConf().setAppName("Wildfly Swarm SparkPi");
       this.sparkConf.setJars(new String[]{"/tmp/src/target/SparkPiBoot-0.0.1-SNAPSHOT.jar.original"});
       this.sparkContext = new JavaSparkContext(sparkConf);
   }

   public static JavaSparkContext getContext() {
       return instance.sparkContext;
   }
}
