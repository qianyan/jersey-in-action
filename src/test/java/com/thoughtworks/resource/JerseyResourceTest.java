package com.thoughtworks.resource;

import com.thoughtworks.application.AbstractResourceTest;
import org.junit.Test;

import javax.ws.rs.core.GenericType;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JerseyResourceTest extends AbstractResourceTest {

    @Test
    public void should_get_greeting() throws Exception {
        final String greeting =
                target()
                .request()
                .get(new GenericType<String>() {
                });

        assertThat(greeting, is("Hello Jersey DI"));
    }
}