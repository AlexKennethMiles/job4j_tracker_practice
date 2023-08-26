package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SearchByIDTest {

    @Test
    public void whenFindItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("New item name");
        tracker.add(item);
        SearchByID search = new SearchByID(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        search.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("==== Searching for item by id ====" + ln + item + ln);
    }

    @Test
    public void whenNotFindItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        SearchByID search = new SearchByID(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        search.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("==== Searching for item by id ====" + ln + "!!! Item by id NOT found !!!" + ln);
    }

}
