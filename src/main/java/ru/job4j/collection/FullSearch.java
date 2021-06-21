package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> rsl = new HashSet<>();
        for (Task task : list) {
            rsl.add(task.getNumber());
        }
        return rsl;
    }
}
