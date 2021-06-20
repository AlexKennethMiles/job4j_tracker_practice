package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        UserAction createItem = new CreateAction(output);
        createItem.execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        Output output = new ConsoleOutput();
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()), "replace item"};
        UserAction replaceItem = new ReplaceAction(output);
        replaceItem.execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replace item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        UserAction deleteItem = new DeleteAction(output);
        deleteItem.execute((new StubInput(answers)), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced, is(nullValue()));
    }

    @Test
    public void whenCreateItem() {
        Input input = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItemStubInput() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Item item = tracker.add(new Item("Replaced item"));
        List<UserAction> actions = Arrays.asList(
                new ReplaceAction(output),
                new ExitAction(output)
        );
        Input input = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "New item name", "1"}
        );
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("New item name"));
    }

    @Test
    public void whenReplaceItemStubIncorrectInput() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        tracker.add(new Item("Replaced item"));
        List<UserAction> actions = Arrays.asList(
                new ReplaceAction(output),
                new ExitAction(output)
        );
        Input input = new StubInput(
                new String[]{"0", "123", "1234", "1"}
        );
        new StartUI(output).init(input, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu." + nxL
                        + "0. Edit item" + nxL
                        + "1. Exit" + nxL
                        + "==== Update the item ====" + nxL
                        + "!!! The change failed !!! " + nxL
                        + "Menu." + nxL
                        + "0. Edit item" + nxL
                        + "1. Exit" + nxL
                        + "==== Exit the program ====" + nxL
        ));
    }

    @Test
    public void whenDeleteItemStubInput() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Item item = tracker.add(new Item("Deleted item"));
        List<UserAction> actions = Arrays.asList(
                new DeleteAction(output),
                new ExitAction(output)
        );
        Input input = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenDeleteItemIncorrectStubInput() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Deleted item"));
        Input input = new StubInput(
                new String[]{"0", "123", "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new DeleteAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu." + nxL
                        + "0. Delete item" + nxL
                        + "1. Exit" + nxL
                        + "==== Deleting the item ====" + nxL
                        + "!!! Deletion failed !!!" + nxL
                        + "Menu." + nxL
                        + "0. Delete item" + nxL
                        + "1. Exit" + nxL
                        + "==== Exit the program ====" + nxL
        ));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu." + nxL
                        + "0. Exit" + nxL
                        + "==== Exit the program ====" + nxL
        ));
    }

    @Test
    public void whenSearchAll() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();
        Item first = new Item("First item");
        Item second = new Item("Second item");
        tracker.add(first);
        tracker.add(second);
        List<UserAction> actions = Arrays.asList(
                new ShowAllItems(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu." + nxL
                        + "0. Show all items" + nxL
                        + "1. Exit" + nxL
                        + "==== Showing all items ====" + nxL
                        + first + nxL
                        + second + nxL
                        + "Menu." + nxL
                        + "0. Show all items" + nxL
                        + "1. Exit" + nxL
                        + "==== Exit the program ====" + nxL
        ));
    }

    @Test
    public void whenSearchNothing() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new ShowAllItems(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu." + nxL
                        + "0. Show all items" + nxL
                        + "1. Exit" + nxL
                        + "==== Showing all items ====" + nxL
                        + "! There are no items in the repository !" + nxL
                        + "Menu." + nxL
                        + "0. Show all items" + nxL
                        + "1. Exit" + nxL
                        + "==== Exit the program ====" + nxL
        ));
    }

    @Test
    public void whenSearchByName() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"0", "New item", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("New item");
        tracker.add(item);
        List<UserAction> actions = Arrays.asList(
                new SearchByName(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu." + nxL
                        + "0. Find items by name" + nxL
                        + "1. Exit" + nxL
                        + "==== Searching for item by name ====" + nxL
                        + item + nxL
                        + "Menu." + nxL
                        + "0. Find items by name" + nxL
                        + "1. Exit" + nxL
                        + "==== Exit the program ====" + nxL
        ));
    }

    @Test
    public void whenSearchByNameNothing() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"0", "0", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new SearchByName(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu." + nxL
                        + "0. Find items by name" + nxL
                        + "1. Exit" + nxL
                        + "==== Searching for item by name ====" + nxL
                        + "!!! Items by name NOT found !!!" + nxL
                        + "Menu." + nxL
                        + "0. Find items by name" + nxL
                        + "1. Exit" + nxL
                        + "==== Exit the program ====" + nxL
        ));
    }

    @Test
    public void whenSearchById() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("New item");
        tracker.add(item);
        List<UserAction> actions = Arrays.asList(
                new SearchByID(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu." + nxL
                        + "0. Find item by Id" + nxL
                        + "1. Exit" + nxL
                        + "==== Searching for item by id ====" + nxL
                        + item + nxL
                        + "Menu." + nxL
                        + "0. Find item by Id" + nxL
                        + "1. Exit" + nxL
                        + "==== Exit the program ====" + nxL
        ));
    }

    @Test
    public void whenSearchByIdNothing() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"0", "0", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new SearchByID(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu." + nxL
                        + "0. Find item by Id" + nxL
                        + "1. Exit" + nxL
                        + "==== Searching for item by id ====" + nxL
                        + "!!! Item by id NOT found !!!" + nxL
                        + "Menu." + nxL
                        + "0. Find item by Id" + nxL
                        + "1. Exit" + nxL
                        + "==== Exit the program ====" + nxL
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"1", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu." + nxL
                        + "0. Exit" + nxL
                        + "Wrong input, you can select: 0 .. 0" + nxL
                        + "Menu." + nxL
                        + "0. Exit" + nxL
                        + "==== Exit the program ====" + nxL
                )
        );
    }
}
