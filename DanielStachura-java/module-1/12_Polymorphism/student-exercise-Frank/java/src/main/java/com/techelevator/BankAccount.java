package com.techelevator;

//                       implement  interface
public class BankAccount implements Accountable { // a BankAccount is a type of Accountable class
    // these are instance variables
    private String accountHolderName;
    private String accountNumber;
    private int balance;

    // ctors - default, 3 arg
    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(String accountHolder, String accountNumber, int balance) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //getters
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    //from interface
    public int getBalance() {
        return balance;
    }

    //methods
    // Update the balance by using the DollarAmount.Plus method
    public int deposit(int amountToDeposit) {
        balance = balance + amountToDeposit;
        return balance;
    }

    // Update the balance by using the DollarAmount.Minus method
    public int withdraw(int amountToWithdraw) {
        balance = balance - amountToWithdraw;
        return balance;
    }

    public int transferTo(BankAccount destinationAccount, int transferAmount) {
        withdraw(transferAmount);
        destinationAccount.deposit(transferAmount);
        return balance;
    }

}


