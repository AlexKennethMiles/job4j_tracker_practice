package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;
import static ru.job4j.ex.UserStore.findUser;
import static ru.job4j.ex.UserStore.validate;

public class UserStoreTest {
    @Test(expected = UserNotFoundException.class)
    public void whenUserWithNameNotFound() throws UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        findUser(users, "Ivan Ivanov");
    }

    @Test(expected = UserInvalidException.class)
    public void whenUserNotValidateByLength() throws UserInvalidException {
        User[] users = {
                new User("Ya", true)
        };
        validate(users[0]);
    }

    @Test(expected = UserInvalidException.class)
    public void whenUserNotValidateByStatus() throws UserInvalidException {
        User[] users = {
                new User("Anatoliy", false)
        };
        validate(users[0]);
    }
}
