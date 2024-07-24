package com.banking.service;

import com.banking.model.Account;
import java.util.HashMap;
import java.util.Map;

public class BankService {
    private static BankService instance;
    private Map<String, Account> accounts;

    private BankService() {
        accounts = new HashMap<>();
    }

    public static synchronized BankService getInstance() {
        if (instance == null) {
            instance = new BankService();
        }
        return instance;
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found: " + accountNumber);
        }
        return account;
    }

    public void removeAccount(String accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account not found: " + accountNumber);
        }
        accounts.remove(accountNumber);
    }
}
