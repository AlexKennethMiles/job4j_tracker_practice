package ru.job4j.calculator;

public class Calculator {
    private static int x = 5;

    private int sum(int y) {
        return x + y;
    }

    private static int minus(int y) {
        return y - x;
    }

    private int multiply(int y) {
        return x * y;
    }

    private int divide(int y) {
        /* Without checking for NullPointerException */
        return y / x;
    }

    private int sumAllOperations(int y) {
        return sum(y) + minus(y) + multiply(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.print(calc.sum(5) + " + ");
        System.out.print(minus(5) + " + ");
        System.out.print(calc.multiply(5) + " + ");
        System.out.print(calc.divide(5) + " = ");
        System.out.print(calc.sumAllOperations(5));
    }
}
