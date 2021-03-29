package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("==== Creating a new Item ====");
        String msg = "Enter Item's name: ";
        String name = input.askStr(msg);
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("==== Showing all items ====");
        Item[] buf = tracker.findAll();
        for (Item value : buf) {
            System.out.println(value);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("==== Update the item ====");
        String msg = "Enter the ID of the item: ";
        int id = input.askInt(msg);
        String name = input.askStr("Enter a new element name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("+++ The change was successful +++");
        } else {
            System.out.println("!!! The change failed !!! ");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("==== Deleting the item ====");
        String msg = "Enter the ID of the item: ";
        int id = input.askInt(msg);
        if (tracker.delete(id)) {
            System.out.println("+++ The deletion was successful +++");
        } else {
            System.out.println("!!! Deletion failed !!! ");
        }
    }

    public static void searchByID(Input input, Tracker tracker) {
        System.out.println("==== Searching for item by id ====");
        String msg = "Enter the ID of the item: ";
        int id = input.askInt(msg);
        Item required = tracker.findById(id);
        if (required != null) {
            System.out.println(required);
        } else {
            System.out.println("!!! Item by id NOT found !!!");
        }
    }

    public static void searchByName(Input input, Tracker tracker) {
        System.out.println("==== Searching for item by name ====");
        String msg = "Enter the name of the item: ";
        String name = input.askStr(msg);
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item elem : items) {
                System.out.println(elem);
            }
        } else {
            System.out.println("!!! Items by name NOT found !!!");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            switch (select) {
                case (0) -> StartUI.createItem(input, tracker);
                case (1) -> StartUI.showAllItems(tracker);
                case (2) -> StartUI.replaceItem(input, tracker);
                case (3) -> StartUI.deleteItem(input, tracker);
                case (4) -> StartUI.searchByID(input, tracker);
                case (5) -> StartUI.searchByName(input, tracker);
                case (6) -> {
                    System.out.println("==== Exit the program ====");
                    run = false;
                }
                default -> System.out.println("!!!! Error! Incorrect menu item selected! !!!!");
            }
        }

    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
