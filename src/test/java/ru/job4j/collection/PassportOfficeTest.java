package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen first = new Citizen("2f44a", "Ivan Ivanov");
        Citizen second = new Citizen("5d12c", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(first);
        office.add(second);
        assertThat(office.get(first.getPassport()), is(first));
        assertThat(office.get(second.getPassport()), is(second));
        Citizen error = new Citizen("2f44a", "error");
        office.add(error);
        assertThat(office.get(first.getPassport()), is(error));
    }
}
