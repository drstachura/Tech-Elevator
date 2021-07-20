package com.techelevator.tenmo.models.account;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JDBCAccountDAO implements AccountDAO{



        private JdbcTemplate jdbcTemplate;

        // ctor
        public JDBCAccountDAO(DataSource dataSource) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
        }


        @Override
        public List<Account> getAllAccounts() {
            List<Account> allAccounts = new ArrayList<>();
            String sqlGetAllAccounts =  " SELECT * " +
                    " FROM accounts;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllAccounts);
            while (results.next()) {
                Account accountResult = mapRowToAccount(results);
                allAccounts.add(accountResult);
            }
            return allAccounts;
        }

        @Override
        public Account getAccountByAccountId(Long accountId) {
            String sqlGetAccount =  " SELECT * " +              //should be SELECT * or SELECT account_id
                    " FROM accounts " +
                    " WHERE account_id = ? ";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAccount, accountId);
            if (results.next()) {
                return mapRowToAccount(results);
            }
            else {
                return null;
            }
        }



        @Override
        public Account getAccountByUserId(Long userId) {
            String sqlGetAccount =  " SELECT * " +              //should be SELECT * or SELECT account_id
                    " FROM accounts " +
                    " WHERE user_id = ? ;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAccount, userId);
            if (results.next()) {
                return mapRowToAccount(results);
            }
            else {
                return null;
            }



        }


        @Override
        public void updateAccount(Account accountToBeUpdated, double transactionAmount) {


            String sqlUpdateAccount = " Update accounts " +
                    " Set balance + ? " +
                    " Where account_id = ?;";

            jdbcTemplate.update(sqlUpdateAccount,transactionAmount,accountToBeUpdated.getAccount_id());

        }

        @Override
        public Account createAccount(Account newAccount) {


            String sqlCreateAccount = " Insert into accounts (user_id, balance) " +
                    " values (? , 1000) ;" ;

            Long accountId = jdbcTemplate.queryForObject(sqlCreateAccount,Long.class,newAccount.getAccount_id());

            return getAccountByAccountId(accountId);

        }



//--------------------------------HELPER METHOD---------------------------------------

        private Account mapRowToAccount(SqlRowSet results) {
            Account theAccount = new Account();
            theAccount.setAccount_id(results.getLong("account_id"));
            theAccount.setUser_id(results.getLong("user_id"));
            theAccount.setBalance(results.getDouble("balance"));

            return theAccount;
        }


    } // end
