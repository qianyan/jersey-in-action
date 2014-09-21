package com.thoughtworks.binder;

import com.thoughtworks.service.JerseyService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class JerseyBinder extends AbstractBinder{
    @Override
    protected void configure() {
        bindAsContract(JerseyService.class);
    }
}
