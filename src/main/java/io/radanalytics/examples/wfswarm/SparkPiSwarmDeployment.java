package io.radanalytics.examples.wfswarm;

import java.net.URL;
import javax.ws.rs.ApplicationPath;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;

public class SparkPiSwarmDeployment {

    public static void main(String[] args) throws Exception {
        ClassLoader cl = SparkPiSwarmDeployment.class.getClassLoader();
        URL xmlConfig = cl.getResource("standalone.xml");

        assert xmlConfig!=null : "Failed to load standalone.xml";

        Swarm swarm = new Swarm(false).withXmlConfig(xmlConfig);
        swarm.start();

        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class, "swarm-sparkpi.war");
        deployment.addPackage(SparkPiSwarmApplication.class.getPackage());

        deployment.addAsWebInfResource(
                new ClassLoaderAsset("WEB-INF/web.xml", cl), "web.xml");

        deployment.addAllDependencies();
        swarm.deploy(deployment);
    }
}

