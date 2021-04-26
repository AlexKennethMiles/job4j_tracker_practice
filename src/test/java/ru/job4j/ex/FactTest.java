package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenNegative() {
        Fact.calc(-5);
    }

    @Test
    public void whenNonNegative() {
        int expected = 6;
        int rsl = Fact.calc(3);
        assertThat(expected, is(rsl));
    }
}
