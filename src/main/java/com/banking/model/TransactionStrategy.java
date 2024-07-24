package com.banking.model;

public interface TransactionStrategy {
    void executeTransaction(Account fromAccount, Account toAccount, double amount);
}

