package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenComparator() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        Item third = new Item("Third");
        Item fourth = new Item("Fourth");
        Item fifth = new Item("Fifth");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        tracker.add(fifth);
        Collections.sort(tracker.getItems(), new SortItemsDecreasing());
        List<Item> decreasingItems = new ArrayList<>(Arrays.asList(fifth, fourth, third, second, first));
        assertThat(tracker.getItems(), is(decreasingItems));
        List<Item> ascendingSort = new ArrayList<>(Arrays.asList(first, second, third, fourth, fifth));
        Collections.sort(tracker.getItems(), new SortItemsAscending());
        assertThat(tracker.getItems(), is(ascendingSort));
    }
}
