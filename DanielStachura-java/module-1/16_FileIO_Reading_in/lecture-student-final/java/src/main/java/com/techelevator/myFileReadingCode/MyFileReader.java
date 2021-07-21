package com.techelevator.myFileReadingCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {
	// since the function contains the File I/O statements
	// and File I/O may cause Exceptions to happen (we discuss this tomorrow)
	// we have to tell Java we know that an Exception may happen in the function
	//
	// adding the throws specification in the function header we are telling
	// Java we know that this type of Exception can happen
	//
	//                   throws = I know I might have this type of Exception
	public static void main(String[] args) throws FileNotFoundException {

		// Define a File object for the file on our computer we want to read
		// Provide a path to the file when defining a File object
		//
		// Paths can be: absolute - code all parts from the root folder of your OS (Windows)
		//
		//               relative - code the parts from the assumed current position to the file
		//
		// absolute paths should be avoid - they tightly coupled the program to directory structure it was created on
		//                                  if the program is run on a machine with a different directory it won't work
		//                                                 the absolute path doesn't exist in a different directory structure
		//
		// relatives paths are preferred because you have loosely coupled the file to directory structure
		//                 it is more likely that the relative paths will be the same from machine to machine
		//
		// relative path: . = current directory
		//                / = then (sub-directory or file follows)
		//                numbers.txt - file name
		//
		File theFile = new File("./data/numbers.txt"); // give the File object the path to our file

		// Define a Scanner for the File object we created for the file on our computer
		Scanner scannerForFile = new Scanner(theFile); // Give Scanner the File object we created

		String aLine = "";   // Hold a line of input from the file

		int sum = 0;         // Hold the sum of the numbers in a line

		// If we want to get all the lines in the file
		// We need to go through and get each line in the file file one at a time
		// We can't get a line from the file if there are no more lines in the file
		// We can use the Scanner class hasNextLine() method to see if there is another line in the file
		// We can set a loop to get a line from the file and process it as long as there lines in the file
		// We will use while loop since we want loop based on a condition (as long as there are lines in the file)
		//         and not a count of lines the file, in which case we would use a for loop

		// Add up and average each line from my file
		// the file has one or more numbers separated by a single space in each line
		while(scannerForFile.hasNextLine()) {  // Loop while there is a line in the file

			aLine = scannerForFile.nextLine();      // Get a line from the file and store it in aLine
			System.out.println("Line from the file: " + aLine);  // Display the line from the file

			// String .split(delimited) will create an array of Strings of the values separated by the delimited
			String[] theNumbers = aLine.split(" ");  // break apart the numbers in the line based on spaces

			// Reset the sum to 0 to clear it of the value from the last time thru the loop
			sum = 0;

			// Loop through the array of Strings holding the numbers from the line in the file
			for(String aNumber : theNumbers) { // aNumber will hold the current element in the array
				sum = sum + Integer.parseInt(aNumber); // add the number to a sum after converting the String to an int
			}
			// Now that we have the sum, we can display it
			System.out.println("Sum of the numbers is: " + sum);
			System.out.println("Avg of the numbers is: " + sum / theNumbers.length);

	} // end of while() loop

	}  // end of main()
}  // end of class containing main()