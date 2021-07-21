package com.techelevator.myFileReadingCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {
	// since the function contains the File I/O statement
//	and File I/O may cause Exceptions to happen (we discuss this tomorrow)
//	we have to tell Java we know that an Exception may happen in the function
//
//	adding the throws specification in the function header tells Java we know that this type of Exception can happen
//
//										   throws = I know I might have this type of Exception
	public static void main(String[] args) throws FileNotFoundException {

		// Define a File object for the file on our computer we want to read
		// Provide a path to the file when you define a File object
		//
		// Paths can be: absolute - code all parts from the root folder of your OS (Windows)
		//				 relative - code the parts from the assumed current position to the file
		//
		//	**absolute paths should be avoided - they tightly couple the program to the directory structure it was created on
		//											if the program was run on a machine with a different directory structure
		//											it wont work. The absolute path doesn't exist in a different directory structure
		//
		// relative paths are preferred because you have loosely couple the file to directory structure
		//					it is more likely that the relative paths will be the same from machine to machine
		//
		// path: . = current directory
		// 		 / = then
		//		 numbers.txt - file name
//		File theFile = new File("rtn.txt"); // give the File object the path to our file
		File theFile = new File("./data/numbers.txt");
//		File theFile = new File("./data/names.stuff");

		// Define a Scanner for the File object
		Scanner scannerForFile = new Scanner(theFile); // give Scanner the File object we created

		String aLine = "";    // Hold a line of input from the file

		int sum = 0;	//hold the sum of the numbers in a line

		// If we want to get all the lines in the file
		// We need to go through and get each line in the file one at a time - loop
		// We can't get a line from the file if there are no more lines in the file
		// We can use the Scanner class hasNextLine() method to see if there is another line in the file
		// We can set up a loop to get a line from the file and process it as long as there are lines in the file
		// We will use a while loop since we want to loop based on a CONDITION ( as long as there are lines in the file)
		//		and not a count of lines in the file, in which case we would use a for loop
		//**for each only works for COLLECTIONS - array, list, stack, queue

		// Add up and average each line from my file
		// the file has one or more numbers separated by spaces in each line
		while (scannerForFile.hasNextLine()) {    // Loop while there is a line in the file

			aLine = scannerForFile.nextLine();    // Get a line from the file and store it in aLine
			System.out.println("Line from the file: " + aLine);    // Display a line from the file

			//String.split(delimited) will create an array of Strings of the values separated by the delimiter
			String[] theNumbers = aLine.split(" ");  // break apart the numbers in the line based on spaces

			// ** reset the sum to 0 to clear it of the value from the last time thru the loop
			sum = 0;

			// Loop through the array of Strings holding the numbers from the line in the file
			for (String aNumber : theNumbers) {    //aNumber will hold the current element in the array
				sum = sum + Integer.parseInt(aNumber);	// add the number to a sum AFTER converting the String to an int
			}

			// Now that we have the sum, we can display it
			System.out.println("Sum of the numbers is: " + sum);
			System.out.println("Average of the numbers is: " + sum / theNumbers.length);

		}// end of while() loop
	}// end of main()
}// end of class containing main()