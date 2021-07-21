package com.techelevator;

import com.techelevator.services.ConsoleService;
import com.techelevator.services.HotelService;

public class App {

    // Define a constant to hold the base URL for the server (like defining a datasource for DAOs)
    private static final String API_BASE_URL = "http://localhost:3000/";

    public static void main(String[] args) {
        int menuSelection = 999;
        int hotelId = -1;
        boolean keepLooping;

        // Define instances of the services we will be using (like defining JDBCDAO object for DAOs)
        ConsoleService consoleService = new ConsoleService();
        // Pass the base URL for our API server to the service that will be accessing the API
        //      (like instantiating a JDBCDAO object we pass it the datasouce)
        HotelService   hotelService   = new HotelService(API_BASE_URL);

        keepLooping = true;
        while (keepLooping) {
            menuSelection = consoleService.printMainMenu();  // Call ConsoleService method to display a menu
            if (menuSelection == 1) {    // List all hotels option
                // Call the HotelService method to get a List for hotels from the API
                //      then give that List to the ConsoleService method to display it.
                consoleService.printHotels(hotelService.listHotels());
            } else if (menuSelection == 2) { // List all reviews options
                consoleService.printReviews(hotelService.listReviews());
            } else if (menuSelection == 3) { // List hotel id=1
                consoleService.printHotel(hotelService.getHotelById(1));
            } else if (menuSelection == 4) {  // List reviews for a hotel id=1
                consoleService.printReviews(hotelService.getReviewsByHotelId(1));
            } else if (menuSelection == 5) {  // Get hotels with a specific star rating
                consoleService.printHotels(hotelService.getHotelsByStarRating(3));  // Get hotels with 3 star rating
            } else if (menuSelection == 6) {
                System.out.println(hotelService.getWithCustomQuery());
            } else if (menuSelection == 0) {
               keepLooping = false;
            } else {
                // anything else is not valid
                System.out.println("Invalid Selection");
            }
            // Press any key to continue...
            if(hotelId != 0) {
                consoleService.next(); // Call a ConsoleService method to display a message and wait for user to press enter
            }
        }

        // if the loop exits, so does the program
        consoleService.allDone();  // Call ConsoleService method to handle anything it need to do when we are done
        System.exit(0);            // Terminate program with return code 0
    }

}
