package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Drive");
    }

    @Override
    public void passengers(int num) {
        System.out.println("The bus has " + num + " passengers");
    }

    @Override
    public int fillUp(int liters) {
        int price = 52;
        return liters * price;
    }
}
