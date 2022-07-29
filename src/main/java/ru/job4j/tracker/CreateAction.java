package ru.job4j.tracker;

public class CreateAction implements UserAction {
    private final Output output;

    public CreateAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Create a new item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Create a new item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}
