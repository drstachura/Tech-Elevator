package com.techelevator.tenmo.model.transfer;

import com.techelevator.tenmo.model.account.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCTransferDAO implements TransferDAO {

private JdbcTemplate jdbcTemplate;

public JDBCTransferDAO(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
}

    @Override
    public List<Transfer> getAllTransfers() {
    List<Transfer> allTransfers = new ArrayList<>();
    String sqlGetAllTransfers = " SELECT * " +
                                " FROM transfers " ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllTransfers);
        while(results.next()) {
            Transfer transferResult = mapRowToTransfer(results);
            allTransfers.add(transferResult);
        }
        return allTransfers ;
    }

    @Override
    public List<Transfer> getSentTransfers() {
    List<Transfer> sentTransfers = new ArrayList<>();
    String sqlGetSentTransfers = " SELECT * " +
                                 " FROM transfers " +
                                 " WHERE transfer_type_id = 2 ";
    SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetSentTransfers);
        while(results.next()) {
            Transfer transferSentResult = mapRowToTransfer(results);
            sentTransfers.add(transferSentResult);
        }
        return sentTransfers;
    }

    @Override
    public List<Transfer> getReceivedTransfers() {

    List<Transfer> receivedTransfers = new ArrayList<>();
        String sqlGetReceivedTransfers = " SELECT * " +
                " FROM transfers " +
                " WHERE transfer_type_id = 1 ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetReceivedTransfers);
        while(results.next()) {
            Transfer transferReceivedResult = mapRowToTransfer(results);
            receivedTransfers.add(transferReceivedResult);
        }
        return receivedTransfers;
    }

    @Override
    public Transfer searchByTransferId(Long transferId) {
    String sqlSearchByTransferId = " SELECT * " +
                                    " FROM transfers " +
                                    " WHERE transfer_id = ? " ;
    SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchByTransferId, transferId);
        if(results.next()) {
            return mapRowToTransfer(results);
        }
        else {
            return null;
        }
    }

    @Override
    public Transfer createNewTransfer(Transfer newTransfer) {
        String sqlCreateNewTransfer = " INSERT INTO transfers (transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                " VALUES (?, ?, ?, ?, ?, ?) ";
        newTransfer.setTransfer_id(getNextTransferId());
        jdbcTemplate.update(sqlCreateNewTransfer
                , newTransfer.getTransfer_id()
                , newTransfer.getTransfer_type_id()
                , newTransfer.getTransfer_status_id()
                , newTransfer.getAccount_from().getAccount_id()
                , newTransfer.getAccount_to().getAccount_id()
                , newTransfer.getAmount());

        return newTransfer;

    }





//----------------------------------HELPER------------------------------------------------------------
    private Transfer mapRowToTransfer(SqlRowSet results) {
        Transfer theTransfer = new Transfer();
        theTransfer.setAccount_from((Account) results.getObject("account_from"));
        theTransfer.setAccount_to((Account) results.getObject("account_to"));
        theTransfer.setTransfer_status_id(results.getInt("transfer_status_id"));
        theTransfer.setTransfer_type_id(results.getInt("transfer_type_id"));
        theTransfer.setTransfer_id(results.getLong("transfer_id"));
        theTransfer.setAmount(results.getDouble("amount"));

        return theTransfer;
    }

    private Long getNextTransferId() {
     SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_transfer_id')");
     if (nextIdResult.next()) {
         return nextIdResult.getLong(1);
     }else {
         throw new RuntimeException("There was an error getting the ID");
     }

    }


}// END

