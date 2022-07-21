package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class MemTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item();
        item.setName("test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenComparatorSortItemsDecreasing() {
        Item first = new Item(1, "First");
        Item second = new Item(2, "Second");
        Item third = new Item(3, "Third");
        Item fourth = new Item(4, "Fourth");
        Item fifth = new Item(5, "Fifth");
        List<Item> list = new ArrayList<>(Arrays.asList(first, second, third, fourth, fifth));
        Collections.sort(list, new SortItemsDecreasing());
        List<Item> decreasingItems = new ArrayList<>(
                Arrays.asList(fifth, fourth, third, second, first)
        );
        assertThat(list, is(decreasingItems));
    }

    @Test
    public void whenComparatorSortItemsAscending() {
        Item first = new Item(1, "First");
        Item second = new Item(2, "Second");
        Item third = new Item(3, "Third");
        Item fourth = new Item(4, "Fourth");
        Item fifth = new Item(5, "Fifth");
        List<Item> list = new ArrayList<>(Arrays.asList(third, fifth, fourth, first, second));
        List<Item> ascendingSort = new ArrayList<>(
                Arrays.asList(first, second, third, fourth, fifth)
        );
        Collections.sort(list, new SortItemsAscending());
        assertThat(list, is(ascendingSort));
    }
}
