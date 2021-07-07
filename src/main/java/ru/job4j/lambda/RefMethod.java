package ru.job4j.lambda;

import java.util.List;
import java.util.function.Consumer;

import static java.util.Arrays.asList;

public class RefMethod {
    public static void main(String[] args) {
        List<String> names = asList(
                "Ivan",
                "Petr Arsentev"
        );
        Consumer<String> out = RefMethod::cutOut;
        names.forEach(out);
    }

    public static void cutOut(String str) {
        if (str.length() > 10) {
            System.out.println(str.substring(0, 10) + "..");
        } else {
            System.out.println(str);
        }
    }
}
