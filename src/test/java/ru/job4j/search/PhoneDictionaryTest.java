package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getName(), is("Petr"));
    }

    @Test
    public void whenFindBySurname() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(
                new Person("Ivan", "Sidorov", "8800", "Odessa")
        );
        ArrayList<Person> result = phoneDictionary.find("8800");
        assertThat(result.get(0).getPhone(), is("8800"));
    }

    @Test
    public void whenNotFind() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(
                new Person("Stepan", "Smirnov", "495123", "Moscow")
        );
        ArrayList<Person> result = phoneDictionary.find("499123");
        assertThat(result.size(), is(0));
    }
}
