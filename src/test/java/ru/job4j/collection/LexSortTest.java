package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Arrays;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Conditions and task.",
                "2. Addition to the task."
        };
        String[] out = {
                "1. Conditions and task.",
                "2. Addition to the task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void sortDuplicateNum() {
        String[] input = {
                "3. Task.",
                "3. Conditions and task.",
                "3. Addition to the task."
        };
        String[] out = {
                "3. Task.",
                "3. Conditions and task.",
                "3. Addition to the task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}
