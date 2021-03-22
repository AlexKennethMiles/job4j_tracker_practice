package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void whenAreaIs8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(8, 0.001));
    }

    @Test
    public void whenAreaIs6() {
        Point a = new Point(0, 0);
        Point b = new Point(3, 0);
        Point c = new Point(3, 4);
        Triangle abc = new Triangle(a, b, c);
        double rsl = abc.area();
        assertThat(rsl, closeTo(6, 0.001));
    }

    @Test
    public void whenTriangleDoesNotExist() {
        Point a = new Point(-5, 0);
        Point b = new Point(5, 0);
        Point c = new Point(0, 0);
        Triangle abc = new Triangle(a, b, c);
        double rsl = abc.area();
        assertThat(rsl, closeTo(-1, 0.001));
    }
}
