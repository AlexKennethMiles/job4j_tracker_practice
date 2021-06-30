package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] left = o1.split("/");
        String[] right = o2.split("/");
        int comp = right[0].compareTo(left[0]);
        if (comp == 0) {
            for (int i = 1; i < Math.min(left.length, right.length); i++) {
                comp = left[i].compareTo(right[i]);
                if (comp != 0) {
                    return comp;
                }
            }
        } else {
            return comp;
        }
        return Integer.compare(left.length, right.length);
    }
}
