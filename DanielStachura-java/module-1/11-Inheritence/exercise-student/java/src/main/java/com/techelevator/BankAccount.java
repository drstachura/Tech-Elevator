package com.techelevator;

import java.util.Objects;

//Super class
public class BankAccount {

//Instance Variables
    private String accountHolderName;
    private String accountNumber;
    private int balance;

//Constructor
    public BankAccount(){
        this.accountHolderName = "Daniel";
        this.accountNumber = "121987";
        this.balance = 0;
    }
    public BankAccount (String accountHolderName, String accountNumber){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount (String accountHolderName, String accountNumber, int balance){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

//Getter
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
//Methods
    //amountToDeposit = add to balance
    //amountToWithdraw = subtract from balance

    public int deposit (int amountToDeposit) {
        this.balance = balance + amountToDeposit;
            return this.balance;
    }

    public int withdraw(int amountToWithdraw) {
        this.balance = balance - amountToWithdraw;
            return this.balance;
    }

//toString()
    @Override
    public String toString() {
        return "BankAccount{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

//equals()
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof BankAccount))
            return false;
        BankAccount that = (BankAccount) o;
        return getBalance() == that.getBalance() && Objects.equals(getAccountHolderName(),
                that.getAccountHolderName()) && Objects.equals(getAccountNumber(), that.getAccountNumber());
    }
    public BankAccount clone() {
        return new BankAccount(this.accountHolderName, this.accountNumber, this.balance);
    }

}
