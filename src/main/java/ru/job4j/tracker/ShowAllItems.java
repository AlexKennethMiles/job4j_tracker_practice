package ru.job4j.tracker;

import java.util.List;

public class ShowAllItems implements UserAction {
    private final Output output;

    public ShowAllItems(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("==== Showing all items ====");
        List<Item> buf = tracker.findAll();
        if (buf.size() > 0) {
            for (Item value : buf) {
                output.println(value);
            }
        } else {
            output.println("! There are no items in the repository !");
        }
        return true;
    }
}
