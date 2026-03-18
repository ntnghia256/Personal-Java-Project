package entity;

import global.exceptions.InsufficientBalanceException;
import global.exceptions.InvalidAmountException;

public abstract class Account {
    private String accountNumber;
    private String owner;
    protected double balance;

    public Account(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    // Checked exception - Handle when do not enough balance
    public abstract void withdraw(double amount) throws InsufficientBalanceException;

    // Unchecked exception - Handle when user input amout below 0
    public synchronized void deposit(double amount) {
        if (amount <= 0) throw new InvalidAmountException("Deposit amount must be positive.");
        this.balance += amount;
    }

    @Override
    public String toString() {
        return String.format("[%s] Owner: %s, Balance: %,.0f VND", accountNumber, owner, balance);
    }
}
