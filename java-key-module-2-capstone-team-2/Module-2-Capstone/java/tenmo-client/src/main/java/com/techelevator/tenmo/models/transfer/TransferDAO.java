package com.techelevator.tenmo.models.transfer;

import java.util.List;

public interface TransferDAO {

    // we need to be able to retrieve transfer by transfer id

    // retrieve a list of sent  transfers

    // retrieve of received transfers

    // list of all transfers

    public List<Transfer> getAllTransfers();

    public List<Transfer> getSentTransfers();

    public List<Transfer> getReceivedTransfers();

    public Transfer searchByTransferId(Long transferId);

    public Transfer createNewTransfer(Transfer newTransfer);



}
