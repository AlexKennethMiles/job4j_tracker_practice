package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Update the item ====");
        int id = input.askInt("Enter the ID of the item: ");
        String name = input.askStr("Enter a new element name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("+++ The change was successful +++");
        } else {
            System.out.println("!!! The change failed !!! ");
        }
        return true;
    }
}
