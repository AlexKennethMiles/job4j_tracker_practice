package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case (0):
                    System.out.println("==== Creating a new Item ====");
                    System.out.print("Enter Item's name: ");
                    String name = scanner.nextLine();
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
                    System.out.println("==== Changing the item ====");
                    System.out.print("Enter the ID of the item: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter a new element name: ");
                    name = scanner.nextLine();
                    item = new Item(name);
                    if (tracker.replace(id, item)) {
                        System.out.println("+++ The change was successful +++");
                    } else {
                        System.out.println("!!! The change failed !!! ");
                    }
                    break;
                case (3):
                    System.out.println("==== Deleting the item ====");
                    System.out.print("Enter the ID of the item: ");
                    id = Integer.parseInt(scanner.nextLine());
                    if (tracker.delete(id)) {
                        System.out.println("+++ The deletion was successful +++");
                    } else {
                        System.out.println("!!! Deletion failed !!! ");
                    }
                    break;
                case (4):
                    System.out.println("==== Searching for item by id ====");
                    System.out.print("Enter the ID of the item: ");
                    id = Integer.parseInt(scanner.nextLine());
                    Item required = tracker.findById(id);
                    if (required != null) {
                        item = required;
                        System.out.println(item);
                    } else {
                        System.out.println("!!! Item by id NOT found !!!");
                    }
                    break;
                case (5):
                    System.out.println("==== Searching for item by name ====");
                    System.out.print("Enter the name of the item: ");
                    name = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
