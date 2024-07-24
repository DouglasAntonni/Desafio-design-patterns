package com.banking.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected List<String> transactions;
    public static final double MAX_BALANCE = 1_000_000;

    public Account(String accountNumber) {
        if (accountNumber == null || accountNumber.length() != 6 || !accountNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Account number must be 6 digits");
        }
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    protected void addTransaction(String transaction) {
        transactions.add(transaction);
    }
}
