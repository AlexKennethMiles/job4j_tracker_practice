package ru.job4j.collection;

public class Parentheses {
    public static boolean valid(char[] data) {
        boolean rsl = false;
        if (data.length % 2 == 0) {
            int countOp = 0;
            int countCl = 0;
            for (int i = 0; i < data.length; i++) {
                if (data[i] == '(') {
                    countOp++;
                }
                if (data[i] == ')') {
                    countCl++;
                }
            }
            if (countOp == countCl && data[0] == '(' && data[data.length - 1] == ')') {
                rsl = true;
            }
        }
        return rsl;
    }
}
