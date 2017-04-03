package io.radanalytics;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkContextProvider {
   private static final SparkContextProvider instance = new SparkContextProvider();

   private SparkConf sparkConf;
   private JavaSparkContext sparkContext;

   private SparkContextProvider() {
       this.sparkConf = new SparkConf().setAppName("Wildfly Swarm SparkPi");
       this.sparkConf.setJars(new String[]{"/tmp/src/target/swarm-sparkpi.jar"});
       this.sparkContext = new JavaSparkContext(sparkConf);
   }

   public static JavaSparkContext getContext() {
       return instance.sparkContext;
   }
}
