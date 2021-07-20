package com.techelevator.tenmo.models.account;

import java.util.List;

public interface AccountDAO {

    public List<Account> getAllAccounts();                      //display a list of accounts

    public Account getAccountByUserId(Long userId);             //get the userId - serial generated in USER table

    public Account getAccountByAccountId(Long accountId);       //get the accountId - serial generated in Account Table

    public void updateAccount(Account accountToBeUpdated,double transactionAmount);      //update account information

    public Account createAccount(Account newAccount);           //create new account

}
