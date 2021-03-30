package ru.job4j.tracker;

public class SearchByName implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Searching for item by name ====");
        String name = input.askStr("Enter the name of the item: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item elem : items) {
                System.out.println(elem);
            }
        } else {
            System.out.println("!!! Items by name NOT found !!!");
        }
        return true;
    }
}
