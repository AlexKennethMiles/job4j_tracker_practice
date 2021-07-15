package ru.job4j.bank;

import java.util.*;

public class BankService {
    /**
     * База данных банка представлена в виде HashMap,
     * в которой ключом является пользователь User,
     * а значением по ключу - список List из счётов Account
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в базу данных (HashMap),
     * если на момент добавления в базе нет такого же.
     *
     * @param user пользователь, которого надо добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод производит поиск пользователя в текущей HashMap
     * на основе переданного паспорта. Получив коллекцию Set всех
     * пользователей через keySet(), запускается поток существующих
     * в базе пользователей класса User, после чего поток фильтруется
     * на основании совпадения поля passport конкретного пользователя
     * и паспорта, переданного в аргументе метода. Если происходит
     * совпадение, то метод возвращает объект User, на котором оно произошло.
     * В противном случае возвращает null.
     *
     * @param passport номер паспорта, по которому надо найти пользователя
     * @return возвращает найденного пользователя
     * или null, если пользователь не найден
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод добавляет к списку счётов пользователя новый счёт,
     * если пользователь с таким паспортом есть в базе
     * и на момент добавления добавляемый счет является уникальным
     * для списка счётов пользователя.
     *
     * @param passport номер паспорта, по которому надо найти пользователя
     * @param account  счёт, который надо добавить к списку List счётов,
     *                 найденного пользователя
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод производит поиск счёта по паспорту пользователя
     * и номером искомого счёта. Если пользователь по паспорту найден,
     * то запускается поток из элементов коллекции Account, которые
     * закреплены за этим пользователем. В случае совпадения с переданным
     * в аргументе метода счётом, метод возвращает объект класса Account,
     * на котором произошло совпадение. В противном случае возвращает null.
     *
     * @param passport  номер паспорта пользователя, у которого производится
     *                  поиск нужного счёта
     * @param requisite номер искомого счёта
     * @return возвращает найденный счёт или null, если счёт не найден
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(r -> r.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод производит перевод средств с счёта одного пользователя
     * на счёт другого. Пользователь может быть одним и тем же
     * (счёты тоже могут быть одинаковыми, но поле balance не поменяется).
     * Перевод производится только в случае если существуют,
     * пользователи перевода и соответствующие счёты, а так же
     * сумма перевода имеется на счету донора.
     * В случае успеха, переводимая сумма снимается с счёта источника
     * и начисляется на счёт принимающего.
     *
     * @param srcPassport   паспорт пользователя-источника
     * @param srcRequisite  номер счёта пользователя-источника,
     *                      с которго будут списана сумма перевода
     * @param destPassport  паспорт пользователя-принимающего
     * @param destRequisite номер счёта пользователя-принимающего,
     *                      на который будет начислена сумма перевода
     * @param amount        сумма перевода
     * @return возвращает true, если перевод произведен,
     * и false, если перевод не произведен
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> fromAcc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> toAcc = findByRequisite(destPassport, destRequisite);
        if (fromAcc.isPresent() && toAcc.isPresent() && fromAcc.get().getBalance() >= amount) {
            fromAcc.get().setBalance(fromAcc.get().getBalance() - amount);
            toAcc.get().setBalance(toAcc.get().getBalance() + amount);
            rsl = true;

        }
        return rsl;
    }
}
