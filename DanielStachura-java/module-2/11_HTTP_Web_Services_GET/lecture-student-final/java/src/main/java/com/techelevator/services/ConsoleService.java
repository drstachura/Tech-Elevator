package com.techelevator.services;

import com.techelevator.models.Hotel;
import com.techelevator.models.Review;

import java.util.Scanner;

public class ConsoleService {

    private Scanner scanner;

    public ConsoleService() {
        scanner = new Scanner(System.in);
    }

    // Display a menu of choices
    public int printMainMenu() {
        int menuSelection;
        System.out.println("");
        System.out.println("Welcome to Tech Elevator Hotels." + "\n" + "We elevate your stay!" + "\n\n"+  "Please make a selection: ");
        System.out.println("1: List Hotels");
        System.out.println("2: List Reviews");
        System.out.println("3: Show Details for Hotel ID 1");
        System.out.println("4: List Reviews for Hotel ID 1");
        System.out.println("5: List Hotels with star rating 3");
        System.out.println("6: Public API Query");
        System.out.println("0: Exit");
        System.out.println("");
        System.out.print("Please choose an option: ");
        // ensures no InputMisMatchException is thrown
        if (scanner.hasNextInt()) {
            menuSelection = scanner.nextInt();
            if (menuSelection != 0) {
                scanner.nextLine();
            }
        } else {
            menuSelection = 999;
        }
        return menuSelection;
    }

    // Display an array of Hotel objects passed to it
    public void printHotels(Hotel[] hotels) {
        System.out.println("--------------------------------------------");
        System.out.println("Hotels");
        System.out.println("--------------------------------------------");
        for (Hotel hotel : hotels) {
            System.out.println(hotel.getId() + ": " + hotel.getName());
        }
    }

    // Display a single Hotel object passed to it
    public void printHotel(Hotel hotel) {
        System.out.println(hotel.toString());
    }

    // Display the array of Review objects passed to it
    public void printReviews(Review[] reviews) {
        for (Review review : reviews) {
            System.out.println(review.toString());
        }
    }

    // Display a message and wait for enter from the user
    public void next() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    // CLose the Scanner object used in the service and terminate the program
    public void allDone() {
        System.out.println("-".repeat(70));
        System.out.println("Thank you for using Tech Elevator Hotels Customer Interface");
        System.out.println("-".repeat(70));

        scanner.close();
    }

}
