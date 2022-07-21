package ru.job4j.tracker;

import java.util.List;

public class SearchByName implements UserAction {
    private final Output output;

    public SearchByName(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("==== Searching for item by name ====");
        String name = input.askStr("Enter the name of the item: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() != 0) {
            for (Item elem : items) {
                output.println(elem);
            }
        } else {
            output.println("!!! Items by name NOT found !!!");
        }
        return true;
    }
}
