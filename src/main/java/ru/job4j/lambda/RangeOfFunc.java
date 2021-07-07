package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RangeOfFunc {
    public static List<Double> diapason(Integer x, Integer y, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (int i = x; i < y; i++) {
            rsl.add(func.apply((double) i));
        }
        return rsl;
    }
}
