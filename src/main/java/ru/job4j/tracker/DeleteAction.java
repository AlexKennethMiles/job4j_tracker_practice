package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Deleting the item ====");
        int id = input.askInt("Enter the ID of the item: ");
        if (tracker.delete(id)) {
            System.out.println("+++ The deletion was successful +++");
        } else {
            System.out.println("!!! Deletion failed !!! ");
        }
        return true;
    }
}
