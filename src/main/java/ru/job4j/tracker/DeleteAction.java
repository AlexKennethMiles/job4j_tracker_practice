package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output output;

    public DeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("==== Deleting the item ====");
        int id = input.askInt("Enter the ID of the item: ");
        if (tracker.delete(id)) {
            output.println("+++ The deletion was successful +++");
        } else {
            output.println("!!! Deletion failed !!! ");
        }
        return true;
    }
}
