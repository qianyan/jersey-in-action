package com.thoughtworks.application;

import com.thoughtworks.binder.JerseyBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyApplication extends ResourceConfig{
    public JerseyApplication() {
        setApplicationName("jersey-in-action");
        register(new JerseyBinder());

        packages(false, "com.thoughtworks.resource");
    }
}
