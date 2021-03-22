package ru.job4j.oop;

public class Test {
    public static void main(String[] args) {
        TextReport simpleText = new TextReport();
        System.out.println(simpleText.generate("name", "body"));
        System.out.println("===");
        JSONReport simpleJSON = new JSONReport();
        System.out.println(simpleJSON.generate("name", "body"));
    }
}
