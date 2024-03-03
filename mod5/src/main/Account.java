package main;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Account implements Serializable {
    private int accountNumber;
    private String firstName;
    private String lastName;
    private double balance;


    public Account(int accountNumber, String firstName, String lastName, double balance) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void combine(TransactionRecord transaction) {
        if (this.accountNumber == transaction.getAccountNumber()) {
            this.balance += transaction.getAmount();
        }
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %.2f", accountNumber, firstName, lastName, balance);
    }
}