package com.techelevator;



import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		System.out.println("What is the Length?");

		Scanner theKeyboard = new Scanner(System.in);
		String aLine = "";
		aLine = theKeyboard.nextLine();

		System.out.println("Is the measurement in M or F");
		String measureType = "";
		measureType = theKeyboard.nextLine();
		if (measureType.equals("M")) {
			Double measureF = (Double.parseDouble(aLine) * 3.2808399);
			System.out.print(aLine + " Meters is " + measureF + " Feet");
		}
		if (measureType.equals("F")) {
			Double measureM = (Double.parseDouble(aLine) * 0.3048);
			System.out.print(aLine + " Feet is " + measureM + " Meters");

		}
	}
}
