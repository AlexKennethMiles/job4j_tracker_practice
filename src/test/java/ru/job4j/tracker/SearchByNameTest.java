package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SearchByNameTest {

    @Test
    public void whenFindItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Test");
        tracker.add(item);
        SearchByName search = new SearchByName(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("Test");

        search.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("==== Searching for item by name ====" + ln + item + ln);
    }

    @Test
    public void whenNotFindItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        SearchByName search = new SearchByName(out);
        tracker.add(new Item("Test"));

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("TEST");

        search.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("==== Searching for item by name ====" + ln + "!!! Items by name NOT found !!!" + ln);
    }


}
