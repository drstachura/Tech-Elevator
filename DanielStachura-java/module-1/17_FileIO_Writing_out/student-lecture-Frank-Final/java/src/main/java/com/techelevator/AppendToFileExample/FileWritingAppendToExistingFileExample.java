package com.techelevator.myFileProcessingCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Scanner;

public class FileWritingAppendToExistingFileExample {
	/*********************************************************************************
	 * This program will read each line from the numbers.txt file
	 * and write each number in the line and the sum of those numbers to a file
	 * 
	 * If the file already exists, it will ask the user if they want to add to it (append)
	 *                             or replace it.
	 *                             
	 * BufferedWriter is used instead of PrintWriter due to BufferedWriter efficiency 
	 *                over PrintWriter.
	 * @throws IOException 
	 *********************************************************************************/
	
	public static void main(String[] args) throws IOException {  // IOExcpetion is super class of all I/O Exceptions
		
		System.out.println("Program has started...");
		
		// Define a Scanner object to get user input
		Scanner userInput = new Scanner(System.in);
		
		// Define the input file and Scanner object to read it - file is in the data folder of the project folder
		File myFile = new File("./data/numbers.txt");  // Assign a File object to numbers.txt

		// Check to be sure the File Object is assigned an existing file - terminate if not
		if (!myFile.exists() || !myFile.isFile()) {
			System.out.println("path specified for input file is not an existing file");
			System.exit(16);   // terminate program with a return code 16
		}
		
		Scanner theFile = new Scanner(myFile);         // Assign the File Object to a Scanner
		
		// Define the output file we are writing the program to be in the project data folder
		File outputFile = new File("./data/program.out");  
		
		boolean appendToFile = false;  // used to determine if we should add to the end of file or not - true=append, false=replace
		
		// 1. If the output file already exists:
		//    a. Ask the user if they want to add to it (append) or replace it.
		//    b. If they want to add to the file - Set appendToFile switch to true
		// 2. If the output file does NOT already exist - Create it		
		// 3. Define a diskFileWriter object with the appendToFile switch
		// 4. Define a BufferedWriter object for the diskFileWriter object
		
		if (outputFile.exists()) {
			String choiceLetter = ""; 
			boolean isGoodResponse = false;
			do {
				System.out.print("Output file already exists - Do you want to Add to it or Replace it? (A / R): ");
				String userResponse = userInput.nextLine();
				choiceLetter = userResponse.substring(0,1).toUpperCase();
				switch (choiceLetter) { 
					case "A": 
						appendToFile = true;
						isGoodResponse = true;
						break;
		
					case "R":
						appendToFile = false;
						isGoodResponse = true;
						break;
					default:
						isGoodResponse = false;
						break;
				}
			}	while (!isGoodResponse);
			}
			else {
				 // Create the file on the disk - file must exist before we can write to it
				 outputFile.createNewFile();  // Will destroy any existing copy of the file
			     }

		// Define a FileWriter object for the File with the append switch value
		// appendToFile is set to true or falsein the logic above based on user response
		FileWriter aFileWriter = new FileWriter(outputFile, appendToFile);  // If the file already exists, it will overylay teh existing data
		
		// Define a BufferedWriter Object for the output file
		BufferedWriter aBufferedWriter= new BufferedWriter(aFileWriter);
		PrintWriter diskFileWriter = new PrintWriter(aBufferedWriter);
		
		
		// Get a String format for the current timestamp to write to the file

        Timestamp timestampNow = Timestamp.valueOf(LocalDateTime.now());   // Get the current timestamp
        
		diskFileWriter.println("--------------------------------------------------");
		diskFileWriter.println("Processing started: " + timestampNow);
		diskFileWriter.println("--------------------------------------------------");
		
		int lineTotal  = 0;  // hold the sum of the numbers in the line we read
		String theLine = ""; // hold the line with the numbers from the file
		int lineCount  = 0;  // Keep track of the number of lines read from the file
		
		// Loop through the file one line at a time while there are lines in the file
		while(theFile.hasNextLine()) {
			// Read a line from the file and store it in theLine
			theLine = theFile.nextLine();
			// Count the line as read
			lineCount++;
			// Break the line up into separate values based on the , separating the value
			String[] theValues = theLine.split(",");
			//    For each value in the line...
			for(int i=0; i < theValues.length; i++) {
				// Convert the individual value from String to numeric so we can add them
				int aValue = Integer.parseInt(theValues[i]);
				// Add each value from the line to sum
				lineTotal += aValue;
				// Display the values in the line
				diskFileWriter.println("Input Line#" +lineCount + " Value[" +(i+1)+"] is: " + aValue);
			}
		//    Display the sum of the values
			diskFileWriter.println("The sum of the values in the line #" + lineCount + " is: " + lineTotal);
		//    Reset sum before looping again to be sure we only get the sum of the numbers in the line
		    lineTotal = 0;
		}

        timestampNow = Timestamp.valueOf(LocalDateTime.now());    // Get the current timestampe
        diskFileWriter.println("--------------------------------------------------");
        diskFileWriter.println("Processing ended:   " + timestampNow);
		diskFileWriter.println("--------------------------------------------------");
		
		// Close the file to avoid a resource leak
		theFile.close();        // release resources
		diskFileWriter.close(); // release resources AND write any data in the buffer to the file
		
		System.out.println("Program has ended...");
	}
}
	
