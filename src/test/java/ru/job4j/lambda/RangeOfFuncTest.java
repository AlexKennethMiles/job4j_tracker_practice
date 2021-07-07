package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RangeOfFuncTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = RangeOfFunc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenTheQuadraticFunction() {
        List<Double> result = RangeOfFunc.diapason(0, 4, x -> x * x);
        List<Double> expected = Arrays.asList(0D, 1D, 4D, 9D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenTheExponentialFunction() {
        List<Double> result = RangeOfFunc.diapason(0, 8, x -> Math.pow(2D, x));
        List<Double> expected = Arrays.asList(1D, 2D, 4D, 8D, 16D, 32D, 64D, 128D);
        assertThat(result, is(expected));
    }
}
