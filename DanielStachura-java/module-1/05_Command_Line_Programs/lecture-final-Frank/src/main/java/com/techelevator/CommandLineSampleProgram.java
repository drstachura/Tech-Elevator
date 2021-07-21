package com.techelevator;

import java.util.Scanner; //gives you access to the code

public class CommandLineSampleProgram {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Frank's Command Line Sample Program");

		// read input from the keyboard

		// Define a Scanner object in our program to represent the keyboard
		// Java automatically gives the keyboard the name: System.in
		// Scanner - scan the keyboard input and return data from the keyboard
		// to the program

	// datatype  name       = initial-value   - no different than defining and int/double/array
		Scanner theKeyboard = new Scanner(System.in);  // Define a scanner for System.in for theKeyboard

		String aLine ="";  //Hold a line of input from the keyboard

		System.out.println("Please enter a line and press enter..");	//prompt user for input.  this needs to come
				//before you ask for input

		// Get a line of input from the keyboard and store it in our variable aLine
		aLine = theKeyboard.nextLine();   // .nextline() - return a line from the keyboard using the Scanner option

		System.out.println("You typed: " + aLine);	//dysplay the line entered by the human at the keyboard

		System.out.println("Please enter a number: ");	//ask the user to enter a numner
		aLine = theKeyboard.nextLine();		// Get a line from the user
		System.out.println("You entered the number: " + aLine);	//should show the user what they entered

		//we need to convert the number they entered from a String to an int so we can multiply
		// function called Integer.parseInt() that will convert a String conatining digits to an int
		// function called Double.parseDouble() that will convert a String conatining digits to an double

		int theNumber = Integer.parseInt(aLine);	//convert what the user entered to an int

		System.out.println("Double your number is: " + theNumber * 2);

		int sum = 0;	//hold the sum of the numbers entered by the user

		while(true) {    //loop until we hit a 'break' statement inside the loop
			System.out.println("Enter a number or END to end");
			aLine = theKeyboard.nextLine();    //get a line of input from the user
			// below- you cannot use == to compare Strings - learn why on Monday
			// use .equals() method to compare Strings
			if (aLine.equals("END")) {    //if they entered the word END - CASE sensitive based on what programer input
					//== "END"	cannot be used
				break;                //break out of the loop
			}
			// if we get here the did not enter the word END\
			sum = sum + Integer.parseInt(aLine);    //add the sum the number entered converted to an int
		}	//end of the while loop
		System.out.println("The sum of the numbers entered is: " + sum);

	}


}
