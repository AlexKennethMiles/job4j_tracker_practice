package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4};
        int rsl = 0;
        for (int value : number) {
            rsl += add(
                    () -> value
            );
        }
        System.out.println(rsl); // 10
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
