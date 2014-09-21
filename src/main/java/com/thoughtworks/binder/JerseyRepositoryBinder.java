package com.thoughtworks.binder;

import com.thoughtworks.repository.JerseyRepository;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

public class JerseyRepositoryBinder extends AbstractBinder{
    @Override
    protected void configure() {
        bindAsContract(JerseyRepository.class).in(Singleton.class);
    }
}
