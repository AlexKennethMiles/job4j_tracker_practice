package ru.job4j.pojo;

public class Library {
    @SuppressWarnings("checkstyle:LineLength")
    public static void main(String[] args) {
        Book first = new Book("War and Piece", 1440);
        Book second = new Book("Crime and Punishment", 331);
        Book third = new Book("The Cherry Orchard", 92);
        Book fourth = new Book("Clean code", 0);
        Book[] data = new Book[4];
        data[0] = first;
        data[1] = second;
        data[2] = third;
        data[3] = fourth;
        for (int i = 0; i < data.length; i++) {
            System.out.println("In \"" + data[i].getName() + "\" "
                    + data[i].getNumberOfPages() + " pages.");
        }
        data[3] = first;
        data[0] = fourth;
        System.out.println("===");
        for (int i = 0; i < data.length; i++) {
            System.out.println("In \"" + data[i].getName() + "\" "
                    + data[i].getNumberOfPages() + " pages.");
        }
        System.out.println("===");
        for (int i = 0; i < data.length; i++) {
            if ("Clean code".equals(data[i].getName())) {
                System.out.println("In \"" + data[i].getName() + "\" "
                        + data[i].getNumberOfPages() + " pages.");
            }
        }
    }
}
