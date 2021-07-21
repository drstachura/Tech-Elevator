package com.techelevator.hotels;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.Reservation;
import com.techelevator.hotels.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;

import java.util.Map;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    public static void main(String[] args) {
        int menuSelection = 999;
        int hotelId = -1;

        ConsoleService consoleService = new ConsoleService();
        HotelService hotelService = new HotelService(API_BASE_URL);
        AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);

        while (menuSelection != 0) {
            menuSelection = consoleService.printMainMenu();
            try {
                if (menuSelection == 1) {
                    // List all hotels
                    consoleService.printHotels(hotelService.listHotels());
                } else if (menuSelection == 2) {
                    hotelId = consoleService.promptForHotel(hotelService.listHotels(), "List Reservations");
                    consoleService.printReservations(hotelService.listReservationsByHotel(hotelId), hotelId);
                } else if (menuSelection == 3) {
                    // Create new reservation for a given hotel
                    String newReservationString = consoleService.promptForReservationData();
                    Reservation reservation = hotelService.addReservation(newReservationString);
                } else if (menuSelection == 4) {
                    // Update an existing reservation
                    Reservation[] reservations = hotelService.listReservations();
                    int reservationId = consoleService.promptForReservation(reservations, "Update Reservation");
                    Reservation existingReservation = hotelService.getReservation(reservationId);
                    if (existingReservation != null) {
                        String csv = "" + reservationId + ",";
                        csv += consoleService.promptForReservationData();
                        hotelService.updateReservation(csv);
                    }
                } else if (menuSelection == 5) {
                    // Delete reservation
                    Reservation[] reservations = hotelService.listReservations();
                    int reservationId = consoleService.promptForReservation(reservations, "Delete Reservation");
                    hotelService.deleteReservation(reservationId);
                } else if (menuSelection == 6) {
                    // Get the user login from the ConsoleService
                    String credentials = consoleService.promptForLogin();
                    // Make sure we got exactly 2 words separated by ,
                    if( credentials.split(",").length == 2 ) {
                        // if we got properly formatted input, send it to the AuthenicationService login()
                        // the login() is returning an HTTP response which we are storingin a variable called response
                        ResponseEntity<Map> response = authenticationService.login(credentials);
                        // get the JWT from the response (Map key named: token) and tell the HotelService about it
                        //     the response is a Map, so use .get(key) to get the value in a Map
                        if (response.hasBody()) {                                   // if the response has a body...
                            String token = (String) response.getBody().get("token");// get the JWT and store it in token
                            hotelService.AUTH_TOKEN = token;                        // set the AUTH_TOKEN variable in
                                                                                    //     in teh HotelService to JWT
                            System.out.println("Login Successful");
                        }
                    } else {
                        consoleService.printError("Please enter username and password separated by a comma.");
                    }
                }

                else if (menuSelection == 0) { // Exit
                    consoleService.exit();
                } else {
                    // anything else is not valid
                    System.out.println("Invalid Selection");
                }
                // Press any key to continue...
                if (hotelId != 0) {
                    consoleService.next();
                }
            } catch (AuthenticationServiceException ex) {
                consoleService.printError(ex.getMessage());
                consoleService.next();
            } catch (HotelServiceException ex) {
                consoleService.printError(ex.getMessage());
                consoleService.next();
            } catch (ResourceAccessException ex) {
                consoleService.printError(ex.getMessage());
                consoleService.next();
            }

            // Ensure loop continues
            menuSelection = 999;
        }
        // if the loop exits, so does the program
        consoleService.exit();
    }

}
