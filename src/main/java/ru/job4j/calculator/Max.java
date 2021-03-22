package ru.job4j.calculator;

public class Max {
    public double max(double first, double second) {
        return first >= second ? first : second;
    }

    public double max(double first, double second, double third) {
        return third >= max(first, second) ? third : max(first, second);
    }

    public double max(double first, double second, double third, double fourth) {
        return fourth >= max(first, second, third) ? fourth : max(first, second, third);
    }
}
