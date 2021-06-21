package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UniqueTextTest {
    @Test
    public void isEquals() {
        String origin = "My cat eats a mouse and milk (milk milk milk milk)";
        String text = "My cat eats milk and a mouse mouse mouse mouse";
        assertThat(UniqueText.isEquals(origin, text), is(true));
    }

    @Test
    public void isNotEquals() {
        String origin = "My cat eats a mouse (mouse mouse mouse mouse)";
        String text = "A mouse is eaten by a cat";
        assertThat(UniqueText.isEquals(origin, text), is(false));
    }
}
