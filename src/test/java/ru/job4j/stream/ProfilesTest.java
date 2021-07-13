package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void collectAddress() {
        List<Profile> profiles = List.of(
                new Profile("Sherlock Holmes",
                        new Address("London", "Baker Street", 221, 2)),
                new Profile("Mikhail Bulgakov",
                        new Address("Moscow", "Bolshaya Sadovaya ulitsa", 10, 50)),
                new Profile("Antoine Marie Jean-Baptiste Roger vicomte de Saint-Exupéry",
                        new Address("Lyon", "rue Peyrat", 8, 1))
        );
        Profiles prof = new Profiles();
        List<Address> expected = List.of(
                new Address("London", "Baker Street", 221, 2),
                new Address("Lyon", "rue Peyrat", 8, 1),
                new Address("Moscow", "Bolshaya Sadovaya ulitsa", 10, 50)
        );
        assertThat(prof.collect(profiles), is(expected));
    }

    @Test
    public void collectAndSortAddress() {
        List<Profile> profiles = List.of(
                new Profile("Mikhail Bulgakov",
                        new Address("Moscow", "Bolshaya Sadovaya ulitsa", 10, 50)),
                new Profile("Sherlock Holmes",
                        new Address("London", "Baker Street", 221, 2)),
                new Profile("Dr John H. Watson",
                        new Address("London", "Baker Street", 221, 2)),
                new Profile("Antoine Marie Jean-Baptiste Roger vicomte de Saint-Exupéry",
                        new Address("Lyon", "rue Peyrat", 8, 1)),
                new Profile("Jean de Saint-Exupéry",
                        new Address("Lyon", "rue Peyrat", 8, 1))
        );
        Profiles prof = new Profiles();
        List<Address> expected = List.of(
                new Address("London", "Baker Street", 221, 2),
                new Address("Lyon", "rue Peyrat", 8, 1),
                new Address("Moscow", "Bolshaya Sadovaya ulitsa", 10, 50)
        );
        assertThat(prof.collect(profiles), is(expected));
    }
}
