package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void addOne() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addADuplicate() {
        Citizen first = new Citizen("2f44a", "Ivan Ivanov");
        Citizen second = new Citizen("2f44a", "ERROR");
        PassportOffice office = new PassportOffice();
        office.add(first);
        office.add(second);
        assertThat(office.get(first.getPassport()), is(first));
        assertThat(office.get(second.getPassport()), is(first));
    }

    @Test
    public void addMultipleCitizens() {
        Citizen first = new Citizen("2f44a", "Ivan Ivanov");
        Citizen second = new Citizen("5d12c", "Petr Arsentev");
        Citizen third = new Citizen("8a78e", "Andrey Pavlov");
        Citizen error = new Citizen("2f44a", "ERROR");
        PassportOffice office = new PassportOffice();
        office.add(first);
        office.add(second);
        office.add(third);
        office.add(error);
        assertThat(office.get(first.getPassport()), is(first));
        assertThat(office.get(second.getPassport()), is(second));
        assertThat(office.get(third.getPassport()), is(third));
        assertThat(office.get(error.getPassport()), is(first));
    }
}
