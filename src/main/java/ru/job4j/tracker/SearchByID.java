package ru.job4j.tracker;

public class SearchByID implements UserAction {
    private final Output output;

    public SearchByID(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("==== Searching for item by id ====");
        int id = input.askInt("Enter the ID of the item: ");
        Item required = tracker.findById(id);
        if (required != null) {
            output.println(required);
        } else {
            output.println("!!! Item by id NOT found !!!");
        }
        return true;
    }
}
