package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MinMethodTest {
    @Test
    public void test() {
        assertEquals(
                "a",
                MinMethod.min(List.of("ccc", "bb", "a"))
        );
    }

    @Test
    public void emptyList() {
        List<String> emptyList = new ArrayList<>();
        assertEquals(
                "Error",
                MinMethod.min(emptyList)
        );
    }
}
