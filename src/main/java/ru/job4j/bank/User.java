package ru.job4j.bank;

import java.util.Objects;

public class User {
    /**
     * У пользователя есть два приватных поля:
     * passport - номер паспорта,
     * username - фамилия и имя
     */
    private String passport;
    private String username;

    /**
     * Параметризованный конструктор инициализирует поля
     * и определяет их занчения равными тем, что были
     * переданы в аргументах.
     *
     * @param passport номер паспорта создаваемого пользователя
     * @param username имя и фамилия создаваемого пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает значение поля passport
     * объекта, на котором был вызван.
     *
     * @return возвращает номер паспорта пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод устанавливает значение поля passport
     * равное переданному аргументу для
     * объекта, на котором был вызван.
     *
     * @param passport новое значение номера паспорта пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает значение поля username
     * объекта, на котором был вызван.
     *
     * @return возвращает значение имени и фамилии пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод определяет значение поля username,
     * равное переданному аргументу для
     * объекта, на котором был вызван.
     *
     * @param username новое значение имени и фамилии пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод возвращает захэшированное
     * значение поля passport.
     *
     * @return возвращает захэшированное значение номера паспорта пользователя
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    /**
     * Метод определяет равны ли объекты класса User.
     * Если переданный объект и объект, на котором вызвали метод,
     * находятся в одной ячейке памяти, то вернёт true.
     * Если переданный объект является null или у него класс
     * отличный от User, то вернёт false.
     * Если после приведения к типу User, поля passport одинаковые,
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
        User user = (User) obj;
        return Objects.equals(passport, user.passport);
    }
}
