package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        products[index] = null;
        for (int i = 0; i < products.length - 1; i++) {
            if (products[i] == null) {
                products[i] = products[i + 1];
                products[i + 1] = null;
            }
        }
        return products;
    }
}
