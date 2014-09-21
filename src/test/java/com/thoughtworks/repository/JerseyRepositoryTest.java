package com.thoughtworks.repository;

import com.thoughtworks.domain.Person;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JerseyRepositoryTest {
    @Test
    public void show_get_the_name_of_person() throws Exception {
        final JerseyRepository repository = new JerseyRepository();
        final Person person = repository.query(1);

        assertThat(person.getName(), is("carl"));
    }
}