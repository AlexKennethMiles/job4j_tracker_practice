package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("i.ivanov@gmail.com", "Ivanov Ivan Ivanovich");
        map.put("i.ivanov@gmail.com", "Ivanov Ivan Ivanovich");
        map.put("i.ivanov@gmail.com", "Ivanov Ivan Petrovich");
        map.put("a.sidorov@gmail.com", "Sidorov Andrey Anreevich");
        map.put("n.smirnov@gmail.com", "Smirnov Nikita Aleksandrovich");
        map.put("k.flynn@gmail.com", "Kevin Flynn Leon");
        System.out.println("=== keySet() ===");
        for (String s : map.keySet()) {
            String value = map.get(s);
            System.out.println(s + " = " + value);
        }
        System.out.println("=== Map.entry ===");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
