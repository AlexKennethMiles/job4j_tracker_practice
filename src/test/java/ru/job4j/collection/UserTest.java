package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        users.add(new User("Andrey", 25));
        users.add(new User("Mihail", 20));
        users.add(new User("Igor", 22));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Andrey", 25)));
        assertThat(it.next(), is(new User("Igor", 22)));
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Mihail", 20)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenAscWithDuplicate() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Ivan", 31));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenAscWithEqualName() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Andrey", 25));
        users.add(new User("Andrey", 21));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Andrey", 21)));
        assertThat(it.next(), is(new User("Andrey", 25)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareAndreyVSAndrey() {
        int rsl = new User("Andrey", 25)
                .compareTo(
                        new User("Andrey", 21)
                );
        assertThat(rsl, greaterThan(0));
    }
}
