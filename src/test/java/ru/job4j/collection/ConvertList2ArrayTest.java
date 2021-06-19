package ru.job4j.collection;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Ignore
public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when10ElementsThen20() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                9
        );
        int[][] expect = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {10, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when10ElementsIsJust10Elements() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                10
        );
        int[][] expect = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when10ElementsInOneColumn() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                1
        );
        int[][] expect = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8},
                {9},
                {10}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenIncorrectCells() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5),
                0
        );
        int[][] expect = {{}};
        assertThat(result, is(expect));
    }
}
