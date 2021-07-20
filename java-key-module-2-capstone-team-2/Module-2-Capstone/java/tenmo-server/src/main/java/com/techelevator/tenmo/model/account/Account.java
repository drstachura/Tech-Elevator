package com.techelevator.tenmo.model.account;

//-------------------------POJO for account table---------------------------------------//
//                  **** MAKE SURE TO COPY TO CLIENT ****

//          accounts table
//account_id	user_id	        balance
//1	                1	        1000.00

public class Account {

    public static final double STARTING_BALANCE = 1000.00;

//member data
    private long account_id;
    private long user_id;
    private double balance;

//CTOR
    //Default
    public Account (){
        this.account_id = 0L;
        this.user_id = 0L;
        this.balance = STARTING_BALANCE;
    }
    //With Parameters
    public Account (Long account_id, Long user_id){
        this.account_id = account_id;
        this.user_id = user_id;
        this.balance = STARTING_BALANCE;
    }

//get/set
    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //toString
    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", user_id=" + user_id +
                ", balance=" + balance +
                '}';
    }


}//End
