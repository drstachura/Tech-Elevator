package com.techelevator.rental;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RentalDAO {

    // Get all rentals from the database
    List<Rental> getAllRentals();

    // Get a specific rental based on rentalId (Primary Key)
    Rental getARental(int rentalId);

    // Get all rentals for a specific customer
    List<Rental> getRentalsForCustomer(int customerId);

    // Get all rentals between two dates
    List<Rental> getRentalsForDate(LocalDateTime fromDate, LocalDateTime toDate);

    // Get all rentals for a specific staffer
    List<Rental> getRentalsForStaffer(int staffId);

    // Add a new a new row to the table using a Rental object and return Rental object with id stored in it
    Rental addRental(Rental newRental);

    // Remove a specific rental (Primary Key) and return
    void removeRental(int rentalId);

    // Remove rentals for a specific data range and return number of rentals deleted
    int removeRentalForDateRange(LocalDateTime fromDate, LocalDateTime toDate);
}
