package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void simpleConvertMatrixToList() {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3),
                List.of(4, 5, 6)
        );
        Matrix machine = new Matrix();
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertThat(machine.convertMatrixToList(matrix), is(expected));
    }

    @Test
    public void whenEmptyMatrix() {
        List<List<Integer>> matrix = List.of(
                List.of()
        );
        Matrix machine = new Matrix();
        List<Integer> expected = List.of();
        assertThat(machine.convertMatrixToList(matrix), is(expected));
    }
}
