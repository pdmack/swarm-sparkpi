package io.radanalytics.examples.wfswarm;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class SparkPiSwarmApplication {

    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();
        swarm.start();

        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class, "swarm-sparkpi.war");
        deployment.addPackage(SparkPiSwarmApplication.class.getPackage());
        deployment.addResource(DefaultEndpoint.class);
        deployment.addResource(SparkPiEndpoint.class);

        deployment.addAllDependencies();
        swarm.deploy(deployment);
    }
}

