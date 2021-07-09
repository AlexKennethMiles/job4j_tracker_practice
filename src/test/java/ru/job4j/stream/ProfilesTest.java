package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
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
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("London", "Baker Street", 221, 2));
        expected.add(new Address("Moscow", "Bolshaya Sadovaya ulitsa", 10, 50));
        expected.add(new Address("Lyon", "rue Peyrat", 8, 1));
        assertThat(prof.collect(profiles), is(expected));
    }
}
