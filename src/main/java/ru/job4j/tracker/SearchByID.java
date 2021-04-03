package ru.job4j.tracker;

public class SearchByID implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
//        System.out.println("==== Searching for item by id ====");
        int id = input.askInt("Enter the ID of the item: ");
        Item required = tracker.findById(id);
        if (required != null) {
            System.out.println(required);
        } else {
            System.out.println("!!! Item by id NOT found !!!");
        }
        return true;
    }
}
