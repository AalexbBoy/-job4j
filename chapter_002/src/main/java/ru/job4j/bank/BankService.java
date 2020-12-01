package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BankService {
    /**
     * users - множество клиентов банка.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * @param user клиент банка
     */
    public void addUser(final User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * @param passport паспорт клиента.
     * @param account  реквизиты счета клиента
     */
    public void addAccount(final String passport, final Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    /**
     * Поиск клиента по паспорту.
     *
     * @param passport паспорт клиента
     * @return найденный клиент
     */
    public User findByPassport(final String passport) {
        return users.keySet().stream().filter(
                user -> passport.equals(user.getPassport())
        ).findFirst().orElse(null);
    }

    /**
     * Поиск клиента по реквизитам счета.
     *
     * @param passport  паспорт клиента
     * @param requisite реквизиты счета клиента
     * @return счет клиента
     */
    public Account findByRequisite(final String passport, final String requisite) {
        User user = findByPassport(passport);
        Account rsl = null;
        if (user != null) {
            rsl = users.get(user).stream().filter(account -> requisite.equals(account.getRequisite())).
                    findFirst().orElse(null);
        }
        return rsl;
    }

    /**
     * выполение банковского перевода.
     *
     * @param srcPassport   паспорт клиента
     * @param srcRequisite  реквизиты счета клиента
     * @param destPassport  паспорт
     * @param destRequisite получатель реквизиты счета
     * @param amount        сумма перевода
     * @return true, если перевод выполен
     */
    public boolean transferMoney(final String srcPassport, final String srcRequisite,
                                 final String destPassport, final String destRequisite,
                                 final double amount) {
        boolean rsl = false;
        Account accSource = findByRequisite(srcPassport, srcRequisite);
        if (accSource != null && accSource.getBalance() - amount >= 0) {
            Account accDest = findByRequisite(destPassport, destRequisite);
            if (accDest != null) {
                accSource.setBalance(accSource.getBalance() - amount);
                accDest.setBalance(accDest.getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}
