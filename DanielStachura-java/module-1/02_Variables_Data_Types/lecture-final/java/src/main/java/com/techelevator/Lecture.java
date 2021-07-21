// This is a comment in a Java Program - slash-slash tells Java ignore what comes after me
// Comments are used to document/describe what a program is doing

/* this is a block comment which starts with a slash-asterisk and ends with asterisk slash

   ignore everything in between them

   This is block comment

 */
package com.techelevator;   // define the start of a package called com.techelevator
                            // a package is a group of related Java code

public class Lecture {      // define the class to hold the group of related things for our applications

	public static void main(String[] args) {  // This is the state of the main function for our application
        // System.out - defined by Java to represent the screen
		// .println() - function that tell System.out to display whatever is inside the ()
		// "" - used to define a string of characters

		System.out.println("Hello Java Class");  // Display the words inside the "" on the screen

		// variables are used to hold data for a program
		// variables in Java are assigned a specific type of data they will hold

		// to define a variable in Java:  datatype name = initial-value;

		// Choose a datatype base don what you want it to hold:
		//
		//  if numeric, without decimal places use int
		//  if numeric, with decimal places use double
		//  if a single character use char
		//  if true/false use boolean
		//  if it's multiple chars use String - String is special type in Java - next Monday we talk about it
		//
		//  avoid float if at all possible - double is better
		//  if number has no decimal places and is outside range of +/- 2 billion, use long


		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
 //   datatype name              = initial-variable
		int    numberOfExercises = 26;

		System.out.println("numberOfExercise is: " + numberOfExercises);  // display the String and the contents of the variable numberOfExercises

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/

		double half = 0.5;

		System.out.println("The variable half contains the value of " + half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/

		String name = "Tech Elevator";

		System.out.println("name is: " + name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/

		int seasonsOfFirefly = 1;

		System.out.println("There were " + seasonsOfFirefly + " seasons of FireFly");

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";
		System.out.println("I love " + myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
//      double    = double   - data types must match on both sides of the equal sign
		double pi = 3.1416;   // 3.1416 is considered a double because we didn't say it was anything else.
		System.out.println("Pi=" + pi);

//      float     = double   - data types are incompatible on either side of equal sign - a double value may not fit in float variable
//      float pi2 = 3.1416;

		float pi2 = 3.1416F;  // Because we want a float we have to identify he number as a float using F
		System.out.println("Pi2=" + pi2);

//   casting tells Java to pretend something is a different datatype for just statement (datatype)
		float pi3 = (float) 3.1416;  // Because we want a float we have tell Java to pretend it's a float by casting
		System.out.println("Pi3=" + pi3);

		long aNum = 23;
//      int               = long      - incompatible types because a long might have a value that doesn't fit in an int
		int anotherNUmber = (int) aNum;  // cast the long value in aNum to an int so Java can assign it

		/*
		7. Create and set a variable that holds your name.
		*/

		String myName = "Jessica Harper";
		System.out.println("Your name is: " + myName);
		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/

		int mouseButtons = 2;
		System.out.println("My mouse has " + mouseButtons + " buttons");

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
			double pctBatteryLeft     = .70;
			int    howMuchBatteryLeft =  70;

			System.out.println("pctLife= " + pctBatteryLeft + " howMuch= " + howMuchBatteryLeft+"%");
		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int diff = 121-27;
		System.out.println("diff=" + diff);
		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double sum = 12.3 + 32.1;  // + with numerics means add
		System.out.println("sum is: " + sum);  // 44.40000000000000006 is displayed due to the conversion of double (binary type) to decimal
		                                       // internally double and float are stored in binary format (a bunch of 1's and 0's)
		                                       // fractions are stored as binary points not decimal points
		                                       // some binary point values cannot be directly converted to decimal point values
		                                       // so approximations of decimal values are sometimes done when displaying
		                                       // the value is still correct inside th code, it just displays as an approximation
		                                       // we will learn how to make it display correctly later this week
		/*
		12. Create a String that holds your full name.
		*/
		String fullName = "Jess J. Java";
		System.out.println("the value in fullName is: " + fullName);
		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String newString = "Hello " + fullName;  // + with String types means concatenate (stick 'em together)
		System.out.println("newString: " + newString);
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		fullName = fullName + " Esquire"; // you can store new values into an existing variable
		System.out.println("the value in fullName is: " + fullName);
		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		fullName += " Esquire"; // if you assign back into the same variable you can use the shorthand assignment operators
		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		//                 String + int
		String movieTitle = "Saw" + 2;  // if you concatenate a String + a non-String, it converts the non-String to a String
		System.out.println("title=" + movieTitle);
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		movieTitle += "0";  // Use a String to concatenate
		movieTitle += 0;    // Use a non-String to concatenate
		/*
		18. What is 4.4 divided by 2.2?
		*/
		System.out.println("4.4 / 2.2 =" + 4.4 / 2.2);  // You can code an expression for System.out.println
		/*
		19. What is 5.4 divided by 2?
		*/
		System.out.println("5.4 / 2 = " + 5.4 / 2);
		/*
		20. What is 5 divided by 2?
		*/
		System.out.println("5 / 2 = " + 5 / 2); // int / int - result is int - result is 2
		                                        // integer arithmetic returns a int quotient and an int remainder
		/*
		21. What is 5.0 divided by 2?
		*/
		System.out.println("5.0 / 2 = " + 5.0 / 2); // double / int - result is a double - result is 2.5
		                                            // double / double - Java converts the int to a double to do the arithmetic
		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		System.out.println("66.6 / 100 = " + 66.6 / 100);  // result is 0.665999999999999
		                                                   // binary point to decimal point conversion issue
		                                                   // the value is still correct inside the code, it just displays as an approximation
		                                                   // we will learn how to make it display correctly later this week
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		System.out.println("5 % 2 = " + 5 % 2); // quot=2, rem=1 integer arithmetic returns a int quotient and an int remainder
		/*
		24. What is 1,000,000,000 * 3?
		*/
		//                                          int     * long   - convert the int to a lomg - long * long = result
		System.out.println("1000000000 * 3 = " + 1000000000 * (long) 3); // 1 billion * 3 is 3 billion
		                                                                 // 3 billion exceeds the maximum size of an int
		                                                                 // We need to cast one of the operands to be a long
		//                                            int   * long  convert the int ot along
		System.out.println("1000000000 * 3 = " + 1000000000 * 3L);  // Explicitly tell Java the 3 is long value
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		boolean doneWithExercise = false; // boolean values do not have ""
		System.out.println("done=" + doneWithExercise);
		/*
		26. Now set doneWithExercise to true.
		*/
		doneWithExercise = true;
		System.out.println("done=" + doneWithExercise);
	}   // end of main() function

}  // end of Lecture class
