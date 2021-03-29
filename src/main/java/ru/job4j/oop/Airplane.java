package ru.job4j.oop;

public class Airplane implements Vehicle {
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху.");
    }
}
