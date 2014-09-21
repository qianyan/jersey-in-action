package com.thoughtworks.application;

import org.glassfish.jersey.server.ResourceConfig;

public class JerseyApplication extends ResourceConfig{
    public JerseyApplication() {
        setApplicationName("jersey-in-action");
        packages(false, "com.thoughtworks.resource");
    }
}
