package com.thoughtworks.application;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.grizzly2.servlet.GrizzlyWebContainerFactory;
import org.glassfish.jersey.server.ApplicationHandler;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.spi.TestContainer;
import org.glassfish.jersey.test.spi.TestContainerException;
import org.glassfish.jersey.test.spi.TestContainerFactory;

import javax.ws.rs.core.Application;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;

public class AbstractResourceTest extends JerseyTest {
    protected Application configure() {
        return new JerseyApplication();
    }

    protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
        return new TestContainerFactory() {
            @Override
            public TestContainer create(URI baseUri, ApplicationHandler application) throws IllegalArgumentException {
                return new JerseyTestContainer(baseUri);
            }
        };
    }

    private class JerseyTestContainer implements TestContainer {

        private final URI baseUri;
        private HttpServer server;

        private JerseyTestContainer(URI baseUri) {
            this.baseUri = baseUri;
        }

        @Override
        public ClientConfig getClientConfig() {
            return null;
        }

        @Override
        public URI getBaseUri() {
            return baseUri;
        }

        @Override
        public void start() {
            try {
                server = GrizzlyWebContainerFactory.create(baseUri,
                        Collections.singletonMap("javax.ws.rs.Application", "com.thoughtworks.application.JerseyApplication"));
            } catch (IOException e) {
                throw new TestContainerException(e);
            }
        }

        @Override
        public void stop() {
            server.shutdownNow();
        }
    }
}
