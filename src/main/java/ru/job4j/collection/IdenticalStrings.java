package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class IdenticalStrings {
    public static boolean eq(String left, String right) {
        char[] leftChars = left.toCharArray();
        char[] rightChars = right.toCharArray();
        Map<Character, Integer> leftMap = new HashMap<>();
        Map<Character, Integer> rightMap = new HashMap<>();
        for (char leftChar : leftChars) {
            Integer added = leftMap.putIfAbsent(leftChar, 1);
            if (added != null) {
                leftMap.computeIfPresent(leftChar, (k, v) -> v + 1);
            }
        }
        for (char rightChar : rightChars) {
            Integer added = rightMap.putIfAbsent(rightChar, 1);
            if (added != null) {
                rightMap.computeIfPresent(rightChar, (k, v) -> v + 1);
            }
        }
        return leftMap.equals(rightMap);
    }
}
