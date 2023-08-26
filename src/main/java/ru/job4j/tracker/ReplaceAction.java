package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output output;

    public ReplaceAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("==== Update the item ====");
        int id = input.askInt("Enter the ID of the item: ");
        String name = input.askStr("Enter a new element name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            output.println("+++ The change was successful +++");
        } else {
            output.println("!!! The change failed !!!");
        }
        return true;
    }
}
