package ru.job4j.tracker;

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
        Item[] buf = tracker.findAll();
        for (Item value : buf) {
            output.println(value);
        }
        return true;
    }
}
