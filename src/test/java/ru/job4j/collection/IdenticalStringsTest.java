package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class IdenticalStringsTest {
    @Test
    public void whenEq() {
        assertThat(IdenticalStrings.eq("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(IdenticalStrings.eq("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(IdenticalStrings.eq("heloo", "hello"), is(false));
    }
}
