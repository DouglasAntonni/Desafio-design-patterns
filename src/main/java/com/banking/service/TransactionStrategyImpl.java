package com.banking.service;

import com.banking.model.Account;
import com.banking.model.TransactionStrategy;

public class TransactionStrategyImpl implements TransactionStrategy {

    @Override
    public void executeTransaction(Account fromAccount, Account toAccount, double amount) {
        if (fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transaction successful");
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }
}

