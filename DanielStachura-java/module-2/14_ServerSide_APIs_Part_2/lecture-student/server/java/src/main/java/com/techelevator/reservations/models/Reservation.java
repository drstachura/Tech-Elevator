package com.techelevator.reservations.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// Validation annotations may be specified in the POJO
<<<<<<< HEAD
//  if we would like Spring Boot to Validate our data before we process it
//
// @NotBlank        - there must be data in the field
// @Max(value= )    - set the max value
// @Min(value= )    - set the min value
=======
// if we would like Spring Boot to validate our data before we process it
//
// @NotBlank - there must be data in the field
// @Max      - Set the maximum value
// @Min      - Set the minimu, value
>>>>>>> b7638781d2ec5328c943a75f8fb406129d216b3f

public class Reservation {

    private int id;
    private int hotelID;
    private String fullName;

<<<<<<< HEAD
    @NotBlank(message = "Check-in Date Required")
=======
    @NotBlank
>>>>>>> b7638781d2ec5328c943a75f8fb406129d216b3f
    private String checkinDate;

    @NotBlank
    private String checkoutDate;

<<<<<<< HEAD
    @Max(value=4)
=======
    @Min(value=1, message="We need at one guest for a reservation")
    @Max(value=4, message="HEY JC! No wild parties!!!")
>>>>>>> b7638781d2ec5328c943a75f8fb406129d216b3f
    private int guests;

    public Reservation() {

    }

    public Reservation(int id, int hotelID, String fullName, String checkinDate, String checkoutDate, int guests) {
        this.id = id;
        this.hotelID = hotelID;
        this.fullName = fullName;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.guests = guests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" + "\n Reservation Details"
                + "\n--------------------------------------------" + "\n Id: " + id + "\n Hotel Id: " + hotelID
                + "\n Full Name: " + fullName + "\n Checkin Date: " + checkinDate + "\n Checkout Date: " + checkoutDate
                + "\n Guests: " + guests;
    }
}
