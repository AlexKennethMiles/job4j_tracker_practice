package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxTest {
    @Test
    public void whenFirstMaxOfTwo() {
        double a = 2;
        double b = -1;
        Max rsl = new Max();
        double expected = 2;
        assertThat(expected, is(rsl.max(a, b)));
    }

    @Test
    public void whenSecondMaxOfThree() {
        double a = 1;
        double b = 10;
        double c = 0;
        Max rsl = new Max();
        double expected = 10;
        assertThat(expected, is(rsl.max(a, b, c)));
    }

    @Test
    public void whenThirdMaxOfFour() {
        double a = -2;
        double b = -8;
        double c = -1;
        double d = -4;
        Max rsl = new Max();
        double expected = -1;
        assertThat(expected, is(rsl.max(a, b, c, d)));
    }

    @Test
    public void whenAllEquals() {
        double a = 10;
        double b = 10;
        double c = 10;
        double d = 10;
        Max rsl = new Max();
        double expected = 10;
        assertThat(expected, is(rsl.max(a, b, c, d)));
    }
}
