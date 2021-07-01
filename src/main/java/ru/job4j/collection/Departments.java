package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            StringBuilder start = new StringBuilder();
            for (String el : value.split("/")) {
                if (start.isEmpty()) {
                    start.append(el);
                } else {
                    start.append("/").append(el);
                }
                tmp.add(start.toString());
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> deps) {
        deps.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> deps) {
        deps.sort(new DepDescComp());
    }
}
