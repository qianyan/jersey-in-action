package com.thoughtworks.application;

import com.thoughtworks.binder.JerseyBinder;
import com.thoughtworks.binder.JerseyRepositoryBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyApplication extends ResourceConfig{
    public JerseyApplication() {
        setApplicationName("jersey-in-action");
        register(new JerseyBinder());
        register(new JerseyRepositoryBinder());

        packages(false, "com.thoughtworks.resource");
    }
}
