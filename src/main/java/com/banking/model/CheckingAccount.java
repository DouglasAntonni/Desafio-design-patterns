package com.banking.model;

public class CheckingAccount extends Account {

    public CheckingAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }
        if (balance + amount > MAX_BALANCE) {
            throw new IllegalArgumentException("Deposit exceeds maximum account balance");
        }
        balance += amount;
        addTransaction("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be greater than zero");
        }
        if (balance >= amount) {
            balance -= amount;
            addTransaction("Withdrew: " + amount);
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }
}

