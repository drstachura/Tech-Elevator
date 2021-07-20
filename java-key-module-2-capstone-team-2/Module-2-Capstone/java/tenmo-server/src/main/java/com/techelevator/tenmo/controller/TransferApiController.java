package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.model.account.Account;
import com.techelevator.tenmo.model.transfer.Transfer;
import com.techelevator.tenmo.model.transfer.TransferDAO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")

public class TransferApiController {

    private TransferDAO transferDao;

    public TransferApiController (TransferDAO theTransferMethods) {
        transferDao = theTransferMethods;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping (path = "transfers" , method = RequestMethod.POST)
    public Transfer createNewTransfer(@RequestBody Transfer newTransfer) {
        LogAPIRequest.logAPICall("POST - /transfers");

        return transferDao.createNewTransfer(newTransfer);
    }

    @RequestMapping (path = "transfers", method = RequestMethod.GET)
    public List<Transfer> getAllTransfers(){
        LogAPIRequest.logAPICall("GET - /transfers");
        List<Transfer> allTransfers;
        allTransfers = transferDao.getAllTransfers();

        return allTransfers;
    }

}//END
