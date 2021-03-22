package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void dist5() {
        Point a = new Point(0, 0);
        Point b = new Point(3, 4);
        double dist = a.distance(b);
        double expected = 5;
        assertThat(expected, is(dist));
    }

    @Test
    public void dist0() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 1);
        double dist = a.distance(b);
        double expected = 0;
        assertThat(expected, is(dist));
    }

    @Test
    public void dist10() {
        Point a = new Point(-5, -5);
        Point b = new Point(-5, 5);
        double dist = a.distance(b);
        double expected = 10;
        assertThat(expected, is(dist));
    }
}
