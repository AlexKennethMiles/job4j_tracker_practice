package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int cells) {
        int group;
        if (cells > 0) {
            group = (int) Math.ceil((double) list.size() / cells);
        } else {
            return new int[][]{{}};
        }
        int[][] result = new int[group][cells];
        int row = 0, cell = 0;
        for (Integer value : list) {
            result[row][cell] = value;
            cell++;
            if (cell == cells) {
                cell = 0;
                row++;
            }
        }
        return result;
    }
}
