package io.radanalytics.examples.wfswarm;

import java.net.URL;
import javax.ws.rs.ApplicationPath;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;

public class SparkPiSwarmDeployment {

    // NOTE: The use of main() is deprecated in WildFly Swarm.
    // However this technique allows us to dynamically create
    // a "virtual" JAX-RS WAR deployment while the Maven build
    // renders an app jar suitable for deployment to a Spark cluster.
    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();
        swarm.start();

        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class, "swarm-sparkpi.war");
        deployment.addPackage(SparkPiApplication.class.getPackage());

        deployment.addAllDependencies();
        swarm.deploy(deployment);
    }
}

