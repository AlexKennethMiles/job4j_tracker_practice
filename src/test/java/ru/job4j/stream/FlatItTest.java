package ru.job4j.stream;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class FlatItTest {
    @Test
    public void whenIt() {
        Iterator<Iterator<Integer>> it = List.of(
                List.of(1, 2).iterator(),
                List.of(3, 4).iterator(),
                List.of(5, 6).iterator()
        ).iterator();
        assertThat(
                FlatIt.flatten(it),
                is(List.of(1, 2, 3, 4, 5, 6))
        );
    }

    @Test
    public void whenItDifferentNestedIterators() {
        Iterator<Iterator<Integer>> it = List.of(
                List.of(1, 2, 3, 4, 5).iterator(),
                List.of(6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        assertThat(
                FlatIt.flatten(it),
                is(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9))
        );
    }
}
