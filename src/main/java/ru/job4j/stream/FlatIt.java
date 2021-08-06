package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlatIt {
    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        List<Iterator<Integer>> buf = new ArrayList<>();
        while (it.hasNext()) {
            buf.add(it.next());
        }
        List<Integer> res = new ArrayList<>();
        for (Iterator<Integer> integerIterator : buf) {
            while (integerIterator.hasNext()) {
                res.add(integerIterator.next());
            }
        }
        return res;
    }
}
