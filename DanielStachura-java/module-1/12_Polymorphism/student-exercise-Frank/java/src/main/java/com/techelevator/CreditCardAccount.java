package com.techelevator;

/**
 * CreditCardAccount
 */
public class CreditCardAccount implements Accountable { //this is a type of Accountable class
	
/*******************************************************************
 * Place the code for  your CreditCard class here
 *******************************************************************/

//Instance variables
    private String accountHolder;
    private String accountNumber;
    private int debt;

public int getBalance() {
        //***************************************************************
        // This should return the negative of the debt data member
        //***************************************************************

        return -debt;
    }
//CTOR
public CreditCardAccount(String accountHolder, String accountNumber) {
    this.accountHolder = accountHolder;
    this.accountNumber = accountNumber;
    this.debt = 0;
}

//Getter/Setter
    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }

//Methods
    public int pay(int amountToPay) {
        this.debt = debt - amountToPay;
        return this.debt;
    }
    public int charge(int amountToCharge) {
        this.debt = debt + amountToCharge;
        return this.debt;
}

//Override


    }



