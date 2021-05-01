package ru.job4j.tracker;

import org.junit.Test;

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
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItemStubInput() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Item item = tracker.add(new Item("Replaced item"));
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction(output)
        };
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "New item name", "1"}
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("New item name"));
    }

    @Test
    public void whenDeleteItemStubInput() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Item item = tracker.add(new Item("Deleted item"));
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1", "2"}
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
                        + "==== Exit the program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenSearchAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();
        Item first = new Item("First item");
        Item second = new Item("Second item");
        tracker.add(first);
        tracker.add(second);
        UserAction[] actions = {
                new ShowAllItems(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(out.toString(), is(
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
    public void whenSearchByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "New item", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("New item");
        tracker.add(item);
        UserAction[] actions = {
                new SearchByName(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(out.toString(), is(
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
    public void whenSearchById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("New item");
        tracker.add(item);
        UserAction[] actions = {
                new SearchByID(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(out.toString(), is(
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
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                        + "==== Exit the program ====" + ln
                )
        );
    }
}
