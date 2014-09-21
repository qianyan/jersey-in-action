package com.thoughtworks.service;

import com.thoughtworks.domain.Person;
import com.thoughtworks.repository.JerseyRepository;

import javax.inject.Inject;

public class JerseyService {
    private final JerseyRepository repository;

    @Inject
    public JerseyService(JerseyRepository repository) {
        this.repository = repository;
    }

    public Person getPerson(int id){
        return repository.query(id);
    }
}
