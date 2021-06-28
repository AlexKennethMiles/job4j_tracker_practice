package ru.job4j.bank;

import java.util.Objects;

public class Account {
    /**
     * У счёта два приватных поля:
     * requisite - номер счёта,
     * balance - баланс счёта.
     */
    private String requisite;
    private double balance;

    /**
     * Параметризованный конструктор инициализирует поля
     * и определяет их занчения.
     *
     * @param requisite номер создаваемого счёта
     * @param balance   баланс создаваемого счёта
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод возвращает значение поля requisite
     * объекта, на котором был вызван.
     *
     * @return возвращает строку с номером счёта
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод устанавливает значение поля requisite
     * равное переданному аргументу для
     * объекта, на котором был вызван.
     *
     * @param requisite новое значение номера счёта
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает значение поля balance
     * объекта, на котором был вызван.
     *
     * @return возвращает значение баланса счёта
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод устанавливает значение поля balance
     * равное переданному аргументу для
     * объекта, на котором был вызван.
     *
     * @param balance новое значение баланса счёта
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод возвращает захэшированное
     * значение поля requisite.
     *
     * @return возвращает захэшированное значение номера счёта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }

    /**
     * Метод определяет равны ли объекты класса Account.
     * Если переданный объект и объект, на котором вызвали метод,
     * находятся в одной ячейке памяти, то вернёт true.
     * Если переданный объект является null или у него класс
     * отличный от Account, то вернёт false.
     * Если после приведения к типу Account, поля requisite одинаковые,
     * то вернёт true.
     *
     * @param obj объект, с которым сравнивается инициирующий
     * @return возвращает логический результат сравнения
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Account account = (Account) obj;
        return Objects.equals(requisite, account.requisite);
    }
}
