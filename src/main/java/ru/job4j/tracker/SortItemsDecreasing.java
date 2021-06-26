package ru.job4j.tracker;

import java.util.Comparator;

public class SortItemsDecreasing implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Item first = (Item) o1;
        Item second = (Item) o2;
        return second.getId() - first.getId();
    }
}
