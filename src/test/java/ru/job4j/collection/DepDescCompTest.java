package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class DepDescCompTest {
    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenEqual() {
        int rsl = new DepDescComp().compare(
                "K2/SK1",
                "K2/SK1"
        );
        assertThat(rsl, is(0));
    }

    @Test
    public void whenDifferentDepartment() {
        int rsl = new DepDescComp().compare(
                "K2/SK1",
                "K1/SK1"
        );
        assertThat(rsl, lessThan(0));
    }
}
