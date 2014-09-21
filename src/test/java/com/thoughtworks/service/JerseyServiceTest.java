package com.thoughtworks.service;

import com.thoughtworks.application.AbstractModuleTest;
import com.thoughtworks.binder.JerseyBinder;
import com.thoughtworks.binder.JerseyRepositoryBinder;
import com.thoughtworks.domain.Person;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JerseyServiceTest extends AbstractModuleTest {
    public JerseyServiceTest() {
        super(new JerseyBinder(), new JerseyRepositoryBinder());
    }

    @Test
    public void should_get_person_when_given_a_person_id() throws Exception {
        final JerseyService service = service(JerseyService.class);

        final Person person = service.getPerson(1);

        assertThat(person.getName(), is("carl"));
    }
}