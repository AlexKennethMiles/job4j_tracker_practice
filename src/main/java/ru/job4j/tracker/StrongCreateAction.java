package ru.job4j.tracker;

public class StrongCreateAction implements UserAction {
    private final Output output;

    public StrongCreateAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "STRONG Create a new item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== STRONG Create a new items ====");
        int qty = input.askInt("Enter quantity: ");
        for (int i = 0; i < qty; i++) {
            Item item = new Item("Strong" + i);
            tracker.add(item);
        }
        return true;
    }
}
