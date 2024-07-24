package com.banking;

import com.banking.facade.BankFacade;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankFacade bankFacade = new BankFacade();

        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View Balance");
            System.out.println("6. View Transactions");
            System.out.println("7. Close Account");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number (6 digits): ");
                    String accountNumber = scanner.next();
                    while (accountNumber.length() != 6 || !accountNumber.matches("\\d+")) {
                        System.out.println("Invalid account number. Please enter a 6-digit number.");
                        accountNumber = scanner.next();
                    }
                    System.out.println("Select account type:");
                    System.out.println("1. Checking");
                    System.out.println("2. Savings");
                    System.out.print("Enter your choice: ");
                    int accountTypeChoice = scanner.nextInt();
                    String accountType = accountTypeChoice == 1 ? "checking" : "savings";
                    bankFacade.createAccount(accountNumber, accountType);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    try {
                        bankFacade.deposit(accountNumber, depositAmount);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    try {
                        bankFacade.withdraw(accountNumber, withdrawAmount);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter source account number: ");
                    String fromAccountNumber = scanner.next();
                    System.out.print("Enter destination account number: ");
                    String toAccountNumber = scanner.next();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    try {
                        bankFacade.transfer(fromAccountNumber, toAccountNumber, transferAmount);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    try {
                        bankFacade.viewBalance(accountNumber);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    try {
                        bankFacade.viewTransactions(accountNumber);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    try {
                        bankFacade.closeAccount(accountNumber);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
