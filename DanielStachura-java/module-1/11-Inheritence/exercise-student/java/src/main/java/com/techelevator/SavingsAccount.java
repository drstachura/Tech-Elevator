package com.techelevator;
//Sub class of BankAccount
public class SavingsAccount extends BankAccount {

public SavingsAccount(){
    super();
}
    public SavingsAccount (String accountHolderName, String accountNumber){
    super(accountHolderName,accountNumber);
    }

public SavingsAccount (String accountHolderName, String accountNumber, int balance){
    super(accountHolderName, accountNumber,balance);

}

@Override
public int withdraw(int amountToWithdraw) {
    if (super.getBalance() < amountToWithdraw || amountToWithdraw < 0) {
        return super.getBalance();
    }
        if (super.getBalance() > 150) {
            super.withdraw(amountToWithdraw);
        }
        if (super.getBalance() < 150) {
            super.withdraw(+2);
        }
    return super.getBalance();
    }

    }





