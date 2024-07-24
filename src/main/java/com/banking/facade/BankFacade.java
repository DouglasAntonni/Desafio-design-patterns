package com.banking.facade;

import com.banking.model.Account;
import com.banking.model.CheckingAccount;
import com.banking.model.SavingsAccount;
import com.banking.service.BankService;
import com.banking.service.TransactionStrategyImpl;

public class BankFacade {
    private BankService bankService;
    private TransactionStrategyImpl transactionStrategy;

    public BankFacade() {
        bankService = BankService.getInstance();
        transactionStrategy = new TransactionStrategyImpl();
    }

    public void createAccount(String accountNumber, String type) {
        Account account;
        if (type.equalsIgnoreCase("checking")) {
            account = new CheckingAccount(accountNumber);
        } else if (type.equalsIgnoreCase("savings")) {
            account = new SavingsAccount(accountNumber);
        } else {
            throw new IllegalArgumentException("Invalid account type");
        }
        bankService.addAccount(account);
        System.out.println("Account created: " + accountNumber);
    }

    public void deposit(String accountNumber, double amount) {
        Account account = bankService.getAccount(accountNumber);
        account.deposit(amount);
        System.out.println("Deposited " + amount + " to account " + accountNumber);
        System.out.println("Remaining balance: " + account.getBalance());
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = bankService.getAccount(accountNumber);
        account.withdraw(amount);
        System.out.println("Withdrew " + amount + " from account " + accountNumber);
        System.out.println("Remaining balance: " + account.getBalance());
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = bankService.getAccount(fromAccountNumber);
        Account toAccount = bankService.getAccount(toAccountNumber);
        transactionStrategy.executeTransaction(fromAccount, toAccount, amount);
        System.out.println("Transferred " + amount + " from " + fromAccountNumber + " to " + toAccountNumber);
        System.out.println("Remaining balance for source account: " + fromAccount.getBalance());
        System.out.println("Remaining balance for destination account: " + toAccount.getBalance());
    }

    public void viewBalance(String accountNumber) {
        Account account = bankService.getAccount(accountNumber);
        System.out.println("Balance for account " + accountNumber + ": " + account.getBalance());
    }

    public void viewTransactions(String accountNumber) {
        Account account = bankService.getAccount(accountNumber);
        System.out.println("Transactions for account " + accountNumber + ":");
        for (String transaction : account.getTransactions()) {
            System.out.println(transaction);
        }
    }

    public void closeAccount(String accountNumber) {
        bankService.removeAccount(accountNumber);
        System.out.println("Account closed: " + accountNumber);
    }
}
