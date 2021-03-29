package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            switch (select) {
                case (0):
                    String msg = "==== Creating a new Item ====" + System.lineSeparator()
                            + "Enter Item's name: ";
                    String name = input.askStr(msg);
                    Item item = new Item(name);
                    tracker.add(item);
                    break;
                case (1):
                    System.out.println("==== Showing all items ====");
                    Item[] buf = tracker.findAll();
                    for (Item value : buf) {
                        System.out.println(value);
                    }
                    break;
                case (2):
                    msg = "==== Changing the item ====" + System.lineSeparator()
                            + "Enter the ID of the item: ";
                    int id = input.askInt(msg);
                    name = input.askStr("Enter a new element name: ");
                    item = new Item(name);
                    if (tracker.replace(id, item)) {
                        System.out.println("+++ The change was successful +++");
                    } else {
                        System.out.println("!!! The change failed !!! ");
                    }
                    break;
                case (3):
                    msg = "==== Deleting the item ====" + System.lineSeparator()
                            + "Enter the ID of the item: ";
                    id = input.askInt(msg);
                    if (tracker.delete(id)) {
                        System.out.println("+++ The deletion was successful +++");
                    } else {
                        System.out.println("!!! Deletion failed !!! ");
                    }
                    break;
                case (4):
                    msg = "==== Searching for item by id ====" + System.lineSeparator()
                            + "Enter the ID of the item: ";
                    id = input.askInt(msg);
                    Item required = tracker.findById(id);
                    if (required != null) {
                        item = required;
                        System.out.println(item);
                    } else {
                        System.out.println("!!! Item by id NOT found !!!");
                    }
                    break;
                case (5):
                    msg = "==== Searching for item by name ====" + System.lineSeparator()
                            + "Enter the name of the item: ";
                    name = input.askStr(msg);
                    Item[] items = tracker.findByName(name);
                    if (items.length != 0) {
                        for (Item elem : items) {
                            System.out.println(elem);
                        }
                    } else {
                        System.out.println("!!! Items by name NOT found !!!");
                    }
                    break;
                case (6):
                    System.out.println("==== Exit the program ====");
                    run = false;
                    break;
                default:
                    System.out.println("!!!! Error! Incorrect menu item selected! !!!!");
                    break;
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
