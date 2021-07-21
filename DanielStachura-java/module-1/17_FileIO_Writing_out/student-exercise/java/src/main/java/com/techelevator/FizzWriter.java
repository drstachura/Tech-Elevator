package com.techelevator;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FizzWriter {

	public static void main(String[] args) throws IOException {

		File theOutputFile = new File("./java/FizzBuzz.txt");
		theOutputFile.createNewFile();
		PrintWriter fileWriter = new PrintWriter(theOutputFile);

		Boolean multipleOfThree;
		boolean multipleOfFive;
		boolean containsA3;
		boolean containsA5;

		for (Integer i = 1; i < 300; i++) {

			multipleOfThree = i % 3 == 0;
			multipleOfFive = i % 5 == 0;
			containsA3 = i.toString().contains("3");
			containsA5 = i.toString().contains("5");

			if (multipleOfThree && multipleOfFive) {
				fileWriter.println("FizzBuzz");
			} else if (multipleOfThree || containsA3) {
				fileWriter.println("Fizz");
			} else if (multipleOfFive || containsA5) {
				fileWriter.println("Buzz");
			} else fileWriter.println(i);
		}
			fileWriter.close();
	}
}



