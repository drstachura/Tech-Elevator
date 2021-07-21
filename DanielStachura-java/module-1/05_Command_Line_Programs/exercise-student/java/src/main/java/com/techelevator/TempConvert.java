package com.techelevator;

import java.util.Scanner;	//need this to use Scanner

public class TempConvert {

	public static void main(String[] args) {
			//ask for the temp
			//enter the temp
			//ask if C or F
			//convert the temp
			//print conversion

		System.out.println("What is the temperature?");			//ask the initial question

		Scanner theKeyboard = new Scanner(System.in);
		String aLine ="";
		aLine = theKeyboard.nextLine();							//allow for user input - the temperature

		System.out.println("Is the Temperature: C or F");		//ask to specify if C or F
		String tempType = "";
		tempType = theKeyboard.nextLine();						//user input
		if (tempType.equals( "C")) {							//if statement to convert IF number is C to convert to F
			int tf = (Integer.parseInt(aLine) * 9 / 5) + 32;	//cant multiply a string, must parse to an INT
			System.out.println(aLine + "C is " + tf + "F");		//print the conversion
		}
		if (tempType.equals( "F")) {
			int tc = (Integer.parseInt(aLine) - 32) * 5 / 9;
			System.out.println(aLine + "F is " + tc + "C");
		}
	}

}
