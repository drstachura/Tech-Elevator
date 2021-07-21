package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */

		/* Create a new instance of a String literal (a literal is a value that says what it is)
		 *
		 * Two ways to define a new String:
		 *
		 *     String name = new String();  // Create a new empty String
		 *
		 *     String name = "some value";  // Create a new String containing the value
		 *
		 *  A String literal is enclosed in " "  - a series of one or more characters
		 *
		 *  A char literal is enclosed in ' ' - a SINGLE character - only one character
		 *
		 * a String is NOT a char and a char is NOT a String
		 *
		 */

		String softDrink = "Diet Mtn Dew";  // Assign a literal to a String

		String beverage = softDrink + " by Pepsi";  // + used with a String means concatenation

		System.out.println(beverage);   // Strings can be displayed just by using their name


//--------------------------------------------------------------------------------------------------------		
		System.out.println();
		System.out.println("***********************************");
		System.out.println("****** String MEMBER METHODS ******");
		System.out.println("***********************************");
		System.out.println();

		/*
		 * String is a class - class names start with Capital letters
		 *
		 * A Class is a description of what an object should look like
		 * and what it should/can do (it's behavior) - ALOT tomorrow and next week
		 *
		 * an object is an instance of a class.
		 *
		 * a cake recipe is a description of how to make a cake - it is NOT the cake
		 *
		 *        ingredients (data) and process (what to do)
		 *
		 * The cake you make is an instance of the recipe
		 *     cake is an object recipe is a class
		 *
		 * A class contains methods to interact and manipulate objects of the class
		 *
		 * a method is a function associated with a class
		 *
		 * a member method is a method belonging to a specific class
		 *
		 * to use a method for a class:  anObjectForTheMethod.methodName(parameters)
		 *
		 */

		/* Commonly used methods:  stringName.methodName(parameters)
		 *
		 * .length() - return the number of characters in a String
		 * .charAt(index) - returns the character at the index - 0 is first character
		 * .endsWith(search-string) - return true if the String ends with the search-string 
		 * .startsWith(search-string) - return true if the String starts with the search-string
		 * .indexOf(search-string) - return the index of the start of the 1st occurrence of search-string in the String
		 * .lastIndexOf(search-string) - return the index of the start of the last occurrence of search-string in the Stri
		 * .substring(start-index) - return from the start-index to rest of String
		 * .substring(start-index,end-index) - return from the start-index to the end-index (but not the char at end-index)
		 * .toLowerCase() - return the String in all lowercase
		 * .toUpperCase() - return the String in all uppercase
		 * .trim() - return the String with spaces removed from beginning and end of the String
		 * .split(delimiter) - returns and array of strings containing the characters between the delimiter specified
		 */
//             indexes:012345678911  -  use index to reference individuals chars using charAt()
		String name = "HalyMcHalHal";

		System.out.println("The variable name contains: " + name);
		System.out.println("The number of chars in name is: " + name.length());

		System.out.println("The first char in name is: " + name.charAt(0)); // indexes start at 0
		System.out.println("The second char in name is: " + name.charAt(1));
		System.out.println("The ninth char in name is: " + name.charAt(8));

		System.out.println("name in all uppercase is: " + name.toUpperCase());
		System.out.println("name in all lowercase is: " + name.toLowerCase());

		System.out.println("Does name start with Hal? " + name.startsWith("Hal"));
		System.out.println("Does name start with a J? " + name.startsWith("J"));

		System.out.println("Does name end with Hal? " + name.endsWith("Hal"));
		System.out.println("Does name end with a J? " + name.endsWith("J"));

		System.out.println("Where does Mc start in name? "  + name.indexOf("Mc"));
		System.out.println("Where does Hal start in name? " + name.indexOf("Hal"));
		System.out.println("Where does hal start in name? " + name.indexOf("hal"));  // -1 is returned if string not found
		System.out.println("Where does the last Hal start in name? " + name.lastIndexOf("Hal"));

		// substring allows the extraction of a String from inside a String
        // .substring(start-index,end-index) - return from the start-index to the end-index
		//                                     (but not the char at end-index)

		// If we want the MC from name - it's at indexes 4 & 5 we have to specify 4,6
		System.out.println("Here is Mc from the name: " + name.substring(4,6));
		                                               // start at index 4 to index 6, but not what's at index 6

		System.out.println("Here is middle Hal from the name: " + name.substring(6,9));

		String answer = "        Here is the answer       ";
		System.out.println("The value in answer is: " + answer + "the end of it");
		System.out.println("The value in answer using trim()is: " + answer.trim()  + "the end of it");
		
//--------------------------------------------------------------------------------------------------------
		System.out.println();
		System.out.println("**************************");
		System.out.println("****** USING .split ******");
		System.out.println("**************************");
		System.out.println();
		String person = "Guy Montag, Fire Fighter";

		// Display each word in the variable person - words are separated by spaces
		// Scan the variable and split it at the spaces
		//
		// .split(delimiter) - returns an array of strings containing the characters between the delimiter specified

		// Define an array of Strings to hold the result of .split()
		String[] words = person.split(" ");  // split the String in person based on spaces and store in String[] words

		// Go through the array words and display each one
		for (int i=0; i < words.length; i++) {
			System.out.println("Word #"+i + " is: " + words[i]);
		}

		// Break apart the value in the variable person to get his name and profession
		// There is a comma in the value that separates the name and profession
		words = person.split(",");

		System.out.println("The name is: " + words[0] + " the profession is: " + words[1].trim());

//--------------------------------------------------------------------------------------------------------
		
		/*   A String may also be created easily from an array of characters (char) */

		char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' }; // Array of characters (String)
		
		String hello1 = new String(helloArray);  // Create a String using the array of characters
		String hello2 = new String(helloArray);  // Create a String using the array of characters
		
//--------------------------------------------------------------------------------------------------------			
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */

		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}




	}
}
