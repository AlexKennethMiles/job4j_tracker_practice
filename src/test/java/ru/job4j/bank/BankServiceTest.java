package ru.job4j.bank;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434").get(), is(user));
    }

    @Test
    public void addDuplicateUser() {
        User prime = new User("3434", "Petr Arsentev");
        User dup = new User("3434", "Ivan Ivanov");
        BankService bank = new BankService();
        bank.addUser(prime);
        bank.addUser(dup);
        assertThat(bank.findByPassport("3434").get(), is(prime));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("34", "5546"), is(Optional.empty()));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
    }

    @Test
    public void addDuplicateAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("5546", 4000D));
        assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "5546").get().getBalance(), is(0D));
        assertThat(bank.findByRequisite(user.getPassport(), "113").get().getBalance(), is(200D));
    }

    @Test
    public void transferMoneyBetweenTwoUsers() {
        User first = new User("3434", "Petr Arsentev");
        User second = new User("6765", "Ivan Ivanov");
        BankService bank = new BankService();
        bank.addUser(first);
        bank.addUser(second);
        bank.addAccount(first.getPassport(), new Account("123", 150D));
        bank.addAccount(second.getPassport(), new Account("875", 300D));
        bank.transferMoney(first.getPassport(), "123", second.getPassport(), "875", 150D);
        assertThat(bank.findByRequisite("3434", "123").get().getBalance(), is(0D));
        assertThat(bank.findByRequisite("6765", "875").get().getBalance(), is(450D));
    }

    @Test
    public void failedTransfer() {
        User first = new User("3434", "Petr Arsentev");
        User second = new User("6765", "Ivan Ivanov");
        BankService bank = new BankService();
        bank.addUser(first);
        bank.addUser(second);
        bank.addAccount(first.getPassport(), new Account("123", 30D));
        bank.addAccount(second.getPassport(), new Account("875", 70D));
        bank.transferMoney(first.getPassport(), "123", second.getPassport(), "875", 40D);
        assertThat(bank.findByRequisite("3434", "123").get().getBalance(), is(30D));
        assertThat(bank.findByRequisite("6765", "875").get().getBalance(), is(70D));
    }

    @Test
    public void theSameAccountWhenTransferring() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("123", 100D));
        bank.transferMoney(user.getPassport(), "123", user.getPassport(), "123", 100D);
        assertThat(bank.findByRequisite("3434", "123").get().getBalance(), is(100D));
    }
}
