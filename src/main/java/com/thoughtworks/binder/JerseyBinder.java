package com.thoughtworks.binder;

import com.thoughtworks.service.JerseyService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

public class JerseyBinder extends AbstractBinder{
    @Override
    protected void configure() {
        bindAsContract(JerseyService.class).in(Singleton.class);
    }
}
