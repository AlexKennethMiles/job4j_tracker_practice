package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getName(), is("Petr"));
    }

    @Test
    public void whenFindBySurname() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(
                new Person("Ivan", "Sidorov", "", "Odessa")
        );
        var result = phoneDictionary.find("dorov");
        assertThat(result.get(0).getSurname(), is("Sidorov"));
    }

    @Test
    public void whenFindByPhone() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(
                new Person("Adnrey", "Kolobkov", "7812", "Saint-Petersburg")
        );
        var result = phoneDictionary.find("812");
        assertThat(result.get(0).getPhone(), is("7812"));
    }

    @Test
    public void whenFindByAddress() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(
                new Person("Alexander", "Morozov", "7383", "Novosibirsk")
        );
        var result = phoneDictionary.find("sibirsk");
        assertThat(result.get(0).getAddress(), is("Novosibirsk"));
    }

    @Test
    public void whenNotFind() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(
                new Person("Stepan", "Smirnov", "495123", "Moscow")
        );
        var result = phoneDictionary.find("499123");
        assertThat(result.size(), is(0));
    }
}
