package ru.job4j.ex;

import org.junit.Test;

public class UserStoreTest {
    @Test(expected = UserNotFoundException.class)
    public void whenUserWithNameNotFound() throws UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        UserStore.findUser(users, "Ivan Ivanov");
    }

    @Test(expected = UserInvalidException.class)
    public void whenUserNotValidateByLength() throws UserInvalidException {
        User[] users = {
                new User("Ya", true)
        };
        UserStore.validate(users[0]);
    }

    @Test(expected = UserInvalidException.class)
    public void whenUserNotValidateByStatus() throws UserInvalidException {
        User[] users = {
                new User("Anatoliy", false)
        };
        UserStore.validate(users[0]);
    }
}
