package ru.job4j.collection;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Map<String, Long> bigText = Arrays.stream(origin.trim().split("\\s+"))
                .map(word -> word.replaceAll("\\P{L}", "").trim())
                .map(String::toLowerCase)
                .filter(word -> word.length() > 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> smallText = Arrays.stream(line.trim().split("\\s+"))
                .map(word -> word.replaceAll("\\P{L}", "").trim())
                .map(String::toLowerCase)
                .filter(word -> word.length() > 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int count = smallText.size();
        for (Map.Entry<String, Long> bigEntry : bigText.entrySet()) {
            for (Map.Entry<String, Long> smallEntry : smallText.entrySet()) {
                if (bigEntry.getKey().equals(smallEntry.getKey())
                        && bigEntry.getValue() >= smallEntry.getValue()) {
                    count--;
                }
            }
        }
        return count == 0;
    }
}
