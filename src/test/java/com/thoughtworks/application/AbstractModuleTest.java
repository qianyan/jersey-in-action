package com.thoughtworks.application;

import org.glassfish.hk2.api.DynamicConfiguration;
import org.glassfish.hk2.api.DynamicConfigurationService;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.utilities.Binder;
import org.jvnet.hk2.external.generator.ServiceLocatorGeneratorImpl;

public class AbstractModuleTest {
    protected ServiceLocator locator;

    public AbstractModuleTest(Binder... binders) {
        ServiceLocatorGeneratorImpl generator = new ServiceLocatorGeneratorImpl();
        ServiceLocatorFactory factory = ServiceLocatorFactory.getInstance();
        locator = factory.create(null, null, generator);
        for (Binder binder : binders) {
            bind(binder);
        }
    }

    private void bind(Binder binder) {
        DynamicConfigurationService dcs = locator.getService(DynamicConfigurationService.class);
        DynamicConfiguration dc = dcs.createDynamicConfiguration();

        locator.inject(binder);
        binder.bind(dc);

        dc.commit();
    }

    protected <T> T service(Class<T> clazz) {
        return this.locator.getService(clazz);
    }
}
