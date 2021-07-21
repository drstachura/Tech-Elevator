package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {

	//Given a file containing bank routing numbers, this program will display if they are valid or not
	// We are NOT going to discuss what is a valid bank routing number
	//	We are focusing on the reading of the file

	// this array is used to determine a valid routing number
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	// Note: the throws specification since we are doing File I/O in the program
	public static void main(String[] args) throws FileNotFoundException {

		printApplicationBanner();	// Call a function to display a "Hello Message"

		//Get a valid filename from the user and define a File object for it
		
		File inputFile = getInputFileFromUser();	//get a valid filename from user and define File object for it

		//we will talk about try thing tomorrow
		try(Scanner fileScanner = new Scanner(inputFile)) {	// Define a Scanner object for the File object above
			while(fileScanner.hasNextLine()) {				// loop while the File has a next line
				String line = fileScanner.nextLine();		// get the next line from the File
				String rtn = line.substring(0, 9);			// extract the first 9 characters from the line
				System.out.print("RTN : " + rtn);			// display the first 9 characters from the line
				if(checksumIsValid(rtn) == false) {			// check to see if we have valid rtn
					System.out.println(" - Invalid");		// if we don't, display "Invalid"
				}
					else {
						System.out.println(" - Valid");		// if we do, display "Valid"
				}
			}
		}
	}//End of main()
	//Any methods called by main() must be coded AFTER the end of main() and before the end of the class the holds main()

// these functions/methods are all static because they are called from a static method above
	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	// Get a valid file name from the user
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);							//Define a Scanner object for the keyboard
		System.out.print("Please enter path to input file >>> ");			//prompt the user for what we want them to enter
		String path = userInput.nextLine();									//get response from the user
		System.out.println("Path entered: "+ path + "\n");					//display what the user entered
		File inputFile = new File(path);									//define a File object for the path user gave
		// .exists() will return whether the path for a File object exists in the current file structure
		if(inputFile.exists() == false) { 									// checks for the existence of a file
			System.out.println(path+" does not exist");						// if it doesn't exist - print a message
			System.exit(1); // Ends the program								//		exit the program with a return code 1
		// .isFile() returns whether the path for a File object is a file
		} else if(inputFile.isFile() == false) {							//if the file path does exist, is it a file?
			System.out.println(path+" is not a file");						//if not a file - display message
			System.exit(1); // Ends the program								//	end the program with return code 1
		}
		return inputFile;													//if the user input was an existing filename
																			// return the File object we created for it
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}//End of class that holds main()
