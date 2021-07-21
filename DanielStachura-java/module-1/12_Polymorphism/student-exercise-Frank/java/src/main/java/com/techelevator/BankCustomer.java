package com.techelevator;

import java.util.ArrayList;
import java.util.List;

/**
 * BankCustomer
 */

//instance Variables
public class BankCustomer {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();   // List of Accountable objects

//CTOR
public BankCustomer() {
}

//add the accounts to 'accounts' list
    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }

//Getter/Setter - write them this time

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//  getAccount is a method that will return a array of Accountable objects and receive nothing
    public Accountable[] getAccounts() {
        return accounts.toArray((new Accountable[accounts.size()]));
    }
    // because this method is return a List and accounts is a List in this class
        //we need to convert the List to an Array in order to return it
        //List class method called toArray will create an array from a List
            // all we need to do is tell toArray() the type of array and the number of elements
        //.toArray((type of array[size-of-array]))
    //      array will be same size as the List

    //   return accounts.toArray(new Accountable[accounts.size()]);??

public boolean isVip (){
    int accountBalance = 0;
    for (Accountable account : accounts) {
        accountBalance = accountBalance + account.getBalance();
    }
    if (accountBalance >= 25000) {
        return true;
    }
    return false;
}
}
//
//add isVIP() method - no parameters.  add checking, savings, credit card