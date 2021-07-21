package com.techelevator;
//Sub class of BankAccount
public class CheckingAccount extends BankAccount {

 /*   public CheckingAccount(){
        super();
    }
*/    public CheckingAccount (String accountHolderName, String accountNumber){

        super(accountHolderName,accountNumber);
    }

    public CheckingAccount (String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

@Override
public int withdraw(int amountToWithdraw) {
    if (super.getBalance() - amountToWithdraw < -100) {
        amountToWithdraw = 0;
    }
    else if (super.getBalance() - amountToWithdraw < 0) {
        amountToWithdraw += 10;
    }
        return super.withdraw(amountToWithdraw);
    }
}

//cant be overdrawn by <= -100 -> transaction fails, return balance - 2nd
//if balance after withdraw is < -100 process withdraw. them add $10 OD fee - 3rd
//if balance <0 and >-100 charge the fee to thr balance - 4th
//if balance is > withdraw -> withdraw the amountToWithdraw - 1st
//              100        > -100 &&         50       <          100
//    if (super.getBalance() < -100 && amountToWithdraw < super.getBalance()) {
//      super.withdraw(amountToWithdraw);
//  }
//  if (super.getBalance() > amountToWithdraw) {        //1
//      super.withdraw(- amountToWithdraw);
//  }
//   if (amountToWithdraw > super.getBalance()) {        //3
//        super.withdraw(amountToWithdraw);

//      if (super.getBalance() < 0 && super.getBalance() > -100){
//           return super.getBalance() +10;
//      }
//   }