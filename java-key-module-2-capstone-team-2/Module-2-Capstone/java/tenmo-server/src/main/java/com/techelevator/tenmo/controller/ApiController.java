package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.model.transfer.Transfer;
import com.techelevator.tenmo.model.account.Account;
import com.techelevator.tenmo.model.account.AccountDAO;
import com.techelevator.tenmo.model.transfer.TransferDAO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*******************************************************************************************************
 * This is where you code any API controllers you may create
 *
 * Feel free to create additional controller class if you would
 * like to have separate controller classes base on functionality or use
********************************************************************************************************/

@RestController
@PreAuthorize("isAuthenticated()")

public class ApiController {

    private AccountDAO accountDAO;
    private TransferDAO transferDao;

    public ApiController (AccountDAO theAccountMethods, TransferDAO theTransferMethods) {
        accountDAO = theAccountMethods;
        transferDao = theTransferMethods;
    }


    @RequestMapping (path = "accounts/{id}", method = RequestMethod.GET)
    public Account getAnAccount(@PathVariable Long id) {
        LogAPIRequest.logAPICall("Get - /accounts" + id);
      //System.out.println("Get /accounts/" + id);
        Account theAccount = new Account();
        theAccount = accountDAO.getAccountByUserId(id);

        return theAccount;
    }

    @RequestMapping (path = "accounts", method = RequestMethod.GET)
    public List<Account> getAllAccount(){
        LogAPIRequest.logAPICall("Get - /accounts");
        List<Account> allAccount;
        allAccount = accountDAO.getAllAccounts();

        return allAccount;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping (path = "accounts", method = RequestMethod.POST)
    public Account createNewAccount(@RequestBody Account newAccount) {
        LogAPIRequest.logAPICall("Post - /accounts");
        return accountDAO.createAccount(newAccount);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping (path = "accounts/transfers", method = RequestMethod.POST)
    public Transfer updatedAccountBalance(@RequestBody Transfer newTransfer) {
        LogAPIRequest.logAPICall("Post - /accounts/transfers" + newTransfer);
      //System.out.println("Post " + newTransfer);
        accountDAO.updateAccount(newTransfer.getAccount_from(), -newTransfer.getAmount());
        accountDAO.updateAccount(newTransfer.getAccount_to(), newTransfer.getAmount());
        // updates data in database

        newTransfer.setAccount_from(accountDAO.getAccountByAccountId(newTransfer.getAccount_from().getAccount_id()));
        newTransfer.setAccount_to(accountDAO.getAccountByAccountId(newTransfer.getAccount_to().getAccount_id()));
        // updates transfer objects

         transferDao.createNewTransfer(newTransfer);

        return newTransfer; // create JDBCTransferDAO to add transfer to table
    }



} // end controller class
