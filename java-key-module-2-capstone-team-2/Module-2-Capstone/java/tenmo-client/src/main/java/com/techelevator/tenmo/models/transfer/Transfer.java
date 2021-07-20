package com.techelevator.tenmo.models.transfer;



import com.techelevator.tenmo.models.account.Account;

//    transfer_id	serial
//    transfer_type_id	int4
//    transfer_status_id	int4
//    account_from	int4
//    account_to	int4
//    amount	numeric

public class Transfer {

    private Long transfer_id;
    private Integer transfer_type_id;
    private Integer transfer_status_id;
    private Account account_from;
    private Account account_to;
    private Double amount;

    // default ctor
    /*public Transfer() {
        this.transfer_id = 0L;
        this.transfer_type_id = 2;
        this.transfer_status_id = 2;
        this.account_from = null;
        this.account_to = null;
        this.amount = 0.0;
    }*/

    public Transfer() {
    }

    //ctor
    public Transfer(Long transfer_id, Account theSendingAccount, Account theReceivingAccount, Double transferAmount) {
        this.transfer_id = transfer_id;
        transfer_type_id = 2;
        transfer_status_id = 2;
        account_from = theSendingAccount;
        account_to = theReceivingAccount;
        amount = transferAmount;
    }

    public Long getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(Long transfer_id) {
        this.transfer_id = transfer_id;
    }

    public int getTransfer_type_id() {
        return transfer_type_id;
    }

    public void setTransfer_type_id(int transfer_type_id) {
        this.transfer_type_id = transfer_type_id;
    }

    public int getTransfer_status_id() {
        return transfer_status_id;
    }

    public void setTransfer_status_id(int transfer_status_id) {
        this.transfer_status_id = transfer_status_id;
    }

    public Account getAccount_from() {
        return account_from;
    }

    public void setAccount_from(Account account_from) {
        this.account_from = account_from;
    }

    public Account getAccount_to() {
        return account_to;
    }

    public void setAccount_to(Account account_to) {
        this.account_to = account_to;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transfer_id=" + transfer_id +
                ", transfer_type_id=" + transfer_type_id +
                ", transfer_status_id=" + transfer_status_id +
                ", account_from=" + account_from +
                ", account_to=" + account_to +
                ", amount=" + amount +
                '}';
    }
}

