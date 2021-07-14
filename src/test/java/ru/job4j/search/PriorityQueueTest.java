package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        var result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenEqualPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("first", 2));
        queue.put(new Task("second", 2));
        queue.put(new Task("third", 2));
        var result = queue.take();
        assertThat(result.getDesc(), is("first"));
        result = queue.take();
        assertThat(result.getDesc(), is("second"));
        result = queue.take();
        assertThat(result.getDesc(), is("third"));
    }

    @Test
    public void whenNoElement() {
        var queue = new PriorityQueue();
        queue.put(new Task("element", 123));
        var result = queue.take();
        assertThat(result.getDesc(), is("element"));
        result = queue.take();
        assertThat(result, is(nullValue()));
    }

    @Test
    public void whenUnusualPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("negative", -321));
        var result = queue.take();
        assertThat(result.getDesc(), is("negative"));
    }
}
