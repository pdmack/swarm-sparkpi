package io.radanalytics.examples.wfswarm;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.logging.LoggingFraction;

public class SparkPiSwarmApplication {

    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();

        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class, "swarm-sparkpi.war");
        deployment.addPackage(SparkPiSwarmApplication.class.getPackage());
        deployment.addResource(SparkPiEndpoint.class);

        deployment.addAllDependencies();
        swarm.fraction(LoggingFraction.createDefaultLoggingFraction()).start().deploy(deployment);
    }
}

