package com.techelevator.rental;

import java.time.LocalDateTime;

/* This was copied from dbVisualizer Columns screen for the table
TABLE_NAME	COLUMN_NAME  TYPE_NAME	IS_NULLABLE	COLUMN_DEF
rental	    rental_id	 serial	        NO	    nextval('rental_rental_id_seq'::regclass)
rental	    rental_date	 timestamp	    NO
rental	    inventory_id int4	        NO
rental	    customer_id	 int4	        NO
rental	    return_date	 timestamp	    YES
rental	    staff_id	 int4	        NO
 */

public class Rental {
    private Long rentalId;             // serial in the table
    private LocalDateTime rentalDate;  // timestamp in the table
    private int inventoryId;           // integer in the table
    private int customerId;            // integer in the table
    private LocalDateTime returnDate;  // timestamp in the table
    private int staffId;               // integer in the table

    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "rental{" +
                "rentalId=" + rentalId +
                ", rentalDate=" + rentalDate +
                ", inventoryId=" + inventoryId +
                ", customerId=" + customerId +
                ", returnDate=" + returnDate +
                ", staffId=" + staffId +
                '}';
    }

    @Override
    public boolean equals(Object otherRental) {
        if (this == otherRental) return true;
        if (!(otherRental instanceof Rental)) return false;
        Rental rental = (Rental) otherRental;
        return getInventoryId() == rental.getInventoryId() && getCustomerId() == rental.getCustomerId() && getStaffId() == rental.getStaffId() && getRentalId().equals(rental.getRentalId()) && getRentalDate().equals(rental.getRentalDate()) && getReturnDate().equals(rental.getReturnDate());
    }
}