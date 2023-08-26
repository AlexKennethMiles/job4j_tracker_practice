package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeleteActionTest {

    @Test
    public void whenDeleted() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("New item name");
        tracker.add(item);
        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        assertThat(tracker.findAll().get(0)).isEqualTo(item);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("==== Deleting the item ====" + ln + "+++ The deletion was successful +++" + ln);
        assertThat(tracker.findAll()).isEqualTo(emptyList());
    }

    @Test
    public void whenNotDeleted() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("New item name");
        tracker.add(item);
        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        assertThat(tracker.findAll().get(0)).isEqualTo(item);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("==== Deleting the item ====" + ln + "+++ The deletion was successful +++" + ln);
        assertThat(tracker.findAll()).isEqualTo(emptyList());
    }

}
