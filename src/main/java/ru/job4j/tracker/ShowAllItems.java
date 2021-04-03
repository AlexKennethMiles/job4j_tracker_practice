package ru.job4j.tracker;

public class ShowAllItems implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
//        System.out.println("==== Showing all items ====");
        Item[] buf = tracker.findAll();
        for (Item value : buf) {
            System.out.println(value);
        }
        return true;
    }
}
