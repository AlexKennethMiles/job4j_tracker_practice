package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(
                2351, // +
                0,
                381, // +
                -34,
                82, // +
                -357,
                -24,
                -134,
                -96,
                1252, // +
                0
        ));
        numbers.forEach(System.out::println);
        List<Integer> result = numbers.stream().filter(
                num -> num > 0
        ).collect(Collectors.toList());
        System.out.println("===");
        result.forEach(System.out::println);
    }
}
