package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accountList = users.get(user);
        if (!accountList.contains(account)) {
            accountList.add(account);
            users.put(user, accountList);
        }
    }

    public User findByPassport(String passport) {
        List<User> keyList = new ArrayList(users.keySet());
        User rsl = null;
            for (User user : keyList
            ) {
                if (passport.compareTo(user.getPassport()) == 0) {
                    rsl = user;
                }
            }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            for (Account account : accountList
            ) {
                if (requisite.compareTo(account.getRequisite()) == 0) {
                    rsl = account;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
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