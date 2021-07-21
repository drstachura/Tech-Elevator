package com.techelevator;


import java.util.Scanner;   // give me access to the code that supports a Scanner

public class CommandLineSampleProgram {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Frank's Command Line Sample Program");

		// Read input from the keyboard

		// Define a Scanner object in our program to represent the keyboard
		// Java automatically give the keyboard the name: System.in
		// Scanner - scan the keyboard input and return data from the keyboard to the program

//    datatype  name        = initial-value   - no different than defining an int, double, String or an array
		Scanner theKeyboard = new Scanner(System.in); // Define a Scanner for System.in called theKeyboard

		String aLine = "";   // Hold a line of input from the keyboard

		System.out.println("Please enter a line and press enter...");  // Prompt the user for input

		// Get a line of input from the keyboard and store it in our variable called aLine
		aLine = theKeyboard.nextLine();   // .nextLine() - return a line from the keyboard using the Scanner we defined

		System.out.println("You typed: " + aLine);  // Display the line entered by the human at the keyboard

		System.out.println("Please enter a number: ");          // Ask the user to enter a number
		aLine = theKeyboard.nextLine();                         // Get a line from the user
		System.out.println("You entered the number: " + aLine); // Show them what we think they enetered

		// We need to convert the number they entered from a String to an int so we can multiply it
		//     Integer.parseInt() will convert a String containing numeric digits to an int
		//     Double.parseDouble() will convert a String containing numeric digits to a double

		int theNumber = Integer.parseInt(aLine); // convert what the user entered to an int so it is numeric
		System.out.println("double your number is: " + theNumber * 2);

		int sum = 0;  // hold the sum of the numbers entered by the user

		while(true) {  // Loop until we hit a break statement inside loop
			System.out.println("Enter a number or END to end");
			aLine = theKeyboard.nextLine(); //get a line of input from the user
			// Cannot use == to compare Strings - you learn why on Monday
			// use .equals() method to compare Strings
			if (aLine.equals("END")) { // if they entered the word END
				break;                 //    break out of the loop
			}
			// If we get here they did not enter the word END
			sum = sum + Integer.parseInt(aLine);  // Add to sum the number entered converted to an int
		}  // end of the while loop
		System.out.println("The sum of the numbers entered is: " + sum);

	}

}
