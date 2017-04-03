package io.radanalytics;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class SparkPiSwarmApplication {

    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();

        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class, "sparkpi-app.war");
        deployment.addPackage(SparkPiSwarmApplication.class.getPackage());

        deployment.addAllDependencies();
        swarm.start().deploy(deployment);
    }
}
