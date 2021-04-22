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
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()), "replace item"};
        UserAction replaceItem = new ReplaceAction();
        replaceItem.execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replace item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        UserAction deleteItem = new DeleteAction();
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
                new ExitAction()
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
                new ReplaceAction(),
                new ExitAction()
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
                new DeleteAction(),
                new ExitAction()
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
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenSearchAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "First item", "0", "Second item", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ShowAllItems(),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + nxL +
                        "0. Create a new item" + nxL +
                        "1. Show all items" + nxL +
                        "2. Exit" + nxL +
                        "Menu." + nxL +
                        "0. Create a new item" + nxL +
                        "1. Show all items" + nxL +
                        "2. Exit" + nxL +
                        "Menu." + nxL +
                        "0. Create a new item" + nxL +
                        "1. Show all items" + nxL +
                        "2. Exit" + nxL +
                        "Menu." + nxL +
                        "0. Create a new item" + nxL +
                        "1. Show all items" + nxL +
                        "2. Exit" + nxL
        ));
    }

    @Test
    public void whenSearchByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "New item", "1", "New item", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new SearchByName(),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + nxL +
                        "0. Create a new item" + nxL +
                        "1. Find items by name" + nxL +
                        "2. Exit" + nxL +
                        "Menu." + nxL +
                        "0. Create a new item" + nxL +
                        "1. Find items by name" + nxL +
                        "2. Exit" + nxL +
                        "Menu." + nxL +
                        "0. Create a new item" + nxL +
                        "1. Find items by name" + nxL +
                        "2. Exit" + nxL
        ));
    }

    @Test
    public void whenSearchById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "New item", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new SearchByID(),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String nxL = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + nxL +
                        "0. Create a new item" + nxL +
                        "1. Find item by Id" + nxL +
                        "2. Exit" + nxL +
                        "Menu." + nxL +
                        "0. Create a new item" + nxL +
                        "1. Find item by Id" + nxL +
                        "2. Exit" + nxL +
                        "Menu." + nxL +
                        "0. Create a new item" + nxL +
                        "1. Find item by Id" + nxL +
                        "2. Exit" + nxL
        ));
    }
}
