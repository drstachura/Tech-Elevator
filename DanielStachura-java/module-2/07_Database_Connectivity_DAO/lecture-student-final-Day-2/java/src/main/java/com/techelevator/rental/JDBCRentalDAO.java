package com.techelevator.rental;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JDBCRentalDAO implements RentalDAO {

    private JdbcTemplate theDataBase;

    // constructor for the class which takes the dataSource as a parameter
    // dataSource will be provided when this DAO is instantiated (from application program)
    public JDBCRentalDAO(DataSource theDataSource) {
        // Instantiate a JdbcTemplate object with the dataSource give and assign it to our reference
        this.theDataBase = new JdbcTemplate(theDataSource);
    }


    @Override
    public List<Rental> getAllRentals() {

        List<Rental> allRentals = new ArrayList();

        String selectAllRentals = "Select * from rental limit 20"; // Note limit is for testing only

        SqlRowSet allRentalRows = theDataBase.queryForRowSet(selectAllRentals);

        while(allRentalRows.next()) {
            allRentals.add(MapRowToRental(allRentalRows));
        }
        return allRentals;
    }

    @Override
    public Rental getARental(int rentalId) {

        Rental theRental = new Rental();

        String getRentalSQL = "Select * "       // note space at end of code to ensure it is interpeted correctly
                             +"  from rental "  // note space at end of code to ensure it is interpeted correctly
                             +"Where rental_id = ?";

        SqlRowSet theRow = theDataBase.queryForRowSet(getRentalSQL, rentalId);

        if (theRow.next()) {
            theRental = MapRowToRental(theRow);
        }

        return theRental;
    }

    @Override
    public List<Rental> getRentalsForCustomer(int customerId) {

        List<Rental> theRentals = new ArrayList();

        String getRentalSQL = "Select * "       // note space at end of code to ensure it is interpeted correctly
                +"  from rental "  // note space at end of code to ensure it is interpeted correctly
                +"Where customer_id = ?";

        SqlRowSet theRows = theDataBase.queryForRowSet(getRentalSQL, customerId);

       while(theRows.next()) {
           Rental aRental = MapRowToRental(theRows);
           theRentals.add(aRental);
        }
        return theRentals;
    }


    @Override
    public List<Rental> getRentalsForDate(LocalDateTime fromDate, LocalDateTime toDate) {
        return null;
    }

    @Override
    public List<Rental> getRentalsForStaffer(int staffId) {
        return null;
    }

    @Override
    public Rental addRental(Rental newRental) {
        return null;
    }

    @Override
    public void removeRental(int rentalId) {

        String deleteRentalSQL = "delete from rental where rental_id = ?";

        theDataBase.update(deleteRentalSQL, rentalId);
    }

    @Override
    public int removeRentalForDateRange(LocalDateTime fromDate, LocalDateTime toDate) {
        int numberOfRowsDeleted = 0;


        String deleteRentalSQL = "delete from rental " +
                                 "where rental_date between ? and ?";

        String deletePaymentSQL = "delete from payment " +
                                  "where rental_id in ( select rental_id from rental where rental_date between ? and ?)";


        // Delete any dependent row in payment for the rentals before deleting rentals
        theDataBase.update(deletePaymentSQL, fromDate, toDate);

        // Now that any dependents are gone, we can remove the parent rows
        numberOfRowsDeleted = theDataBase.update(deleteRentalSQL, fromDate, toDate);

        return numberOfRowsDeleted;
    }
    /*********************************************************************************************
     * Helper Methods
     ********************************************************************************************/

    // Create a Rental object from an SQLRowSet
    // Note: All columns for the Rental table are assumed to have been included in the SELECT
    //       that generated the SQLRowSet
    Rental MapRowToRental(SqlRowSet aRow) {
        Rental aRental = new Rental();

        aRental.setRentalId(aRow.getLong("rental_id"));
        aRental.setRentalDate(aRow.getTimestamp("rental_date").toLocalDateTime());
        aRental.setInventoryId(aRow.getInt("inventory_id"));
        aRental.setCustomerId(aRow.getInt("customer_id"));
        aRental.setStaffId(aRow.getInt("staff_id"));

        // Since rentalDate and returnDate allow nulls,
        // special processing is required when mapping them to an object
        //
        // if null was returned from the SELECT for rental_date or return_date
        //    do not set the object data member
        //    if you try you will get a NullPointerException when using the value with toLocalDateTime()
        //    the object data will autimatically be set to null by Java
        Timestamp rentalDateFromTable = aRow.getTimestamp("rental_date");  // Get rental_date from SQL result
        if (!(aRow.wasNull())) {                                           // if previous column was not null
            aRental.setRentalDate(rentalDateFromTable.toLocalDateTime());  // set the object data member to the value
        }

        Timestamp returnDateFromTable = aRow.getTimestamp("return_date");  // Get rental_date from SQL result
        if (!(aRow.wasNull())) {                                           // if previous column was not null
            aRental.setReturnDate(returnDateFromTable.toLocalDateTime());  // set the object data member to the value
        }

        return aRental;
    }

}
