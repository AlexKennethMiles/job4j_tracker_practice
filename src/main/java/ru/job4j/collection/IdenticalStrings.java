package ru.job4j.collection;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IdenticalStrings {
    public static boolean eq(String left, String right) {
        Map<String, Long> leftMap = left.chars().mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> rightMap = right.chars().mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return leftMap.equals(rightMap);
    }
}
