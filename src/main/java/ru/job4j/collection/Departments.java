package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            StringBuilder start = new StringBuilder();
            for (String el : value.split("/")) {
                if (el.equals(value.split("/")[0])) {
                    tmp.add(el);
                    start.append(el);
                } else {
                    tmp.add(start + "/" + el);
                    start.append("/").append(el);
                }
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
