package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("Hello Java Class"); //system dot out represents the screen
												// .println  tells to display whats in ()
												// "" defines the string of characters

		// variables are used to hold Data for a program
		// variables in Java are assigned a specific type of Data they will hold

		// *to define a variable in Java: datatype name = initial-value;*

		// Choose a datatype based on what you want it to hold:
		//
		// if numeric, without decimals use int(integer)
		// if numeric, with decimals use double(.00)
		// if true/false use boolean
		// if a single character use char
		// if multiple character use string - string is a special type in Java - more to come next monday
		// avoid float if at all possible - double is better - *more to come*
		// if no decimal and outside the range +- 2 billion- use long


		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/

		int numberOfExercises = 26;

		System.out.println("numberOfExercise is: " + numberOfExercises); 	// display contents of the string and the value of numberOfExercises


		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/

		double half = 0.5;

		System.out.println("the variable half contains the value: " + half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/

		String name = "TechElevator";

		System.out.println("name is: "+ name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/

		int seasonsOfFirefly = 1;

		System.out.println("there were " + seasonsOfFirefly + " seasons of Firefly");

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/

		String myFavoriteLanguage = "Java";

		System.out.println("i love " + myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/

//		double	  = double  - data types must match on both sides of the equal sign
		double pi = 3.1416;  //3.1416 is considered a double because we didn't specify it as anything else

		System.out.println("Pie = " + pi);

//		float	  = double	- data types were incompatible - double may not fit in a float
//		float pi2 = 3.1416

//		float	  = float
		float pi2 = 3.1416F;  //because we want a float, we have to identify the number as a float using the 'F'

		System.out.println("Pie = " + pi2);

	// casting tells Java to pretend something is a different datatype for just this specific statement (datatype)
		float pi3 = (float) 3.1416; //data shows as a double, (float) represents the casting

		System.out.println("Pie = " + pi3);


		/*
		7. Create and set a variable that holds your name.
		*/

		String myName ="Daniel Stachura";

		System.out.println("Your name is: " + myName);

		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/

		int mouseButtons = 2;
		System.out.println("Mouse buttons " + mouseButtons);

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/

		double pctBatteryLeft = .70;
		int howMuchBatteryLeft = 70;
		System.out.println("battery life " + pctBatteryLeft + " left");

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/

		int dif = 121-27;
		System.out.println("diff = " + dif);

		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/

		double sum = 12.3 + 32.1;
		System.out.println("sum is: " + sum); //displays 44.4 '00000006' due to the conversion of double (binary type) to decimal
		                                      //internally a double and a float are stored in binary format (a bunch of 0,1's)
											//fractions are stored as binary points, NOT decimal points
		                                    // some binary point values cannot be directly converted to decimal points values
                                            // approximations of decimal values are sometimes done when displaying
		                                    //the value is still correct inside the code, it just displays as an approximation
		                                    //**more to come on how to make it display correctly - later this week**

		/*
		12. Create a String that holds your full name.
		*/

		String fullName = "Daniel R Stachura";
		System.out.println("the value in fullName is: " + fullName);

		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/

		String newString = "Hello " + fullName; //+ with String types means combine them)
		System.out.println("newString: " + newString);

		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/

		fullName = fullName + " Esquire"; //you can store new values into an existing variable
		System.out.println("the value in fullName is: " + fullName);

		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/

		fullName += "Esquire";  //if you assign back in to the same variable you can use the shorthand assignment operators
		System.out.println(fullName);

		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/

		String movieTitle = "saw" + 2;

		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		String movieTitle += "0"; //us a string to concatenate
		String movieTitle += 0; // use a non-string to concatenate

		/*
		18. What is 4.4 divided by 2.2?
		*/



		/*
		19. What is 5.4 divided by 2?
		*/

		/*
		20. What is 5 divided by 2?
		*/

		/*
		21. What is 5.0 divided by 2?
		*/

		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/

		/*
		23. If I divide 5 by 2, what's my remainder?
		*/

		/*
		24. What is 1,000,000,000 * 3?
		*/

		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/

		/*
		26. Now set doneWithExercise to true.
		*/
		
	}

}
