package ru.job4j.tracker;

public class StrongDeleteAction implements UserAction {
    private final Output output;

    public StrongDeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "STRONG Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("==== STRONG Deleting the items ====");
        int qty = input.askInt("Enter quantity: ");
        int count = 0;
        while (qty > 0 && qty <= tracker.findAll().size()) {
            if (tracker.delete(count)) {
                qty--;
            }
            count++;
        }
        return true;
    }
}
