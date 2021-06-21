package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {
    private static SingleTracker instance = null;
    private Tracker tracker = new Tracker();

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }
}
