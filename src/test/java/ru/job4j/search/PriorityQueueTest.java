package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenEqualPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("first", 2));
        Task result = queue.take();
        assertThat(result.getDesc(), is("first"));
        queue.put(new Task("second", 2));
        result = queue.take();
        assertThat(result.getDesc(), is("second"));
        queue.put(new Task("third", 2));
        result = queue.take();
        assertThat(result.getDesc(), is("third"));
    }

    @Test
    public void whenNoElement() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("element", 123));
        Task result = queue.take();
        assertThat(result.getDesc(), is("element"));
        result = queue.take();
        assertThat(result, is(nullValue()));
    }
}
