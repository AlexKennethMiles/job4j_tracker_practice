package ru.job4j.function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionalInterfacesTest {
    @Test
    public void whenCorrectWork() {
        List<String> expected = new ArrayList<>(asList(
                "ONE",
                "TWO",
                "THREE",
                "FOUR",
                "FIVE",
                "SIX",
                "SEVEN"
        ));
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (key, value) -> map.put(key, value);
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");

        List<String> rsl = new ArrayList<>();
        Consumer<String> con = s -> rsl.add(s);
        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        Function<String, String> func = s -> s.toUpperCase();
        for (String s : sup.get()) {
            con.accept(func.apply(s));
        }
        assertThat(rsl, is(expected));
    }
}
