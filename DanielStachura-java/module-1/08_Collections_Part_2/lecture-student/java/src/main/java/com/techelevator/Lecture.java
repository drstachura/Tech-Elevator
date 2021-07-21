package com.techelevator;

import java.util.*;

/*
// Map<data-type-of-key, data-type-of-value> name =
	//	new HashMap,data-type-of=key, data-type-of-value>();

Map<Integer, String> students = new HashMap<Integer,String>();

students.put(9, "Jess");
students.put(3, "Dana");
students.put(6, "Lindsay");

Key -Integer	Value - String
	03				Dana
	06				Lindsay
	09				Jess

Primitives cannot be stored in a Collections class object (only Objects are allowed)

"Wrapper Classes'
Primitive	Wrapper
int			Integer
double		Double
float		Float
boolean		Boolean
char		Character

Integer.parseInt(string) - convert a String to an int
Double.parseDouble(string) - convert a String to a double
Integer.toString - Convert an Integer object to a String

for more info on Wrapper Class:
https://www.w3schools.com/java/java_wrapper_classes.asp

 */
public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		// Map is a Collection class to store and access key-value pairs
		//
		// The key - is a unique identifier to associate with a value
		// The value - the data to be associated with a key
		//
		// A Map is also known as an 'associative array'
		//
		// the content of the key must be unique
		// the content of the value does not have to be unique
		//


		//Types of Maps - there are 3 in Java
			//	HashMap - entries are stored in an unknown order
			//	TreeMap - entries are stored in key sequence order
			//	LinkedHashMap - entries are stored in the order in which they were added

		// Two common ways of defining a map:
		//
		//		Map<key-data-type, value-data-type> 	   nameOfMap = new typeOfMap();
		//		typeOfMap<key-data-type, value-data-type>  nameOfMap = new typeOfMap();

		// Define a Map where the key is a String and the value is a String
		//		Map<String, String>     myMap = new HashMap();
		//		HashMap<String, String> myMap = new HashMap();
		//			**The below works the same as above, personal preference, just be consistent**
		//		Map<String, String>     myMap = new HashMap<String, String>();
		//		HashMap<String, String> myMap = new HashMap<String, String>();

		//		Map<String, String>     myMap = new TreeMap();
		//		TreeMap<String, String> myMap = new TreeMap();
		//		Map<String, String>     myMap = new TreeMap<String, String>();
		//		TreeMap<String, String> myMap = new TreeMap<String, String>();

		//		Map<String, String>       myMap = new LinkedMap();
		//		LinkedMap<String, String> myMap = new LinkedMap();
		//		Map<String, String>       myMap = new LinkedMap<String, String>();
		//		LinkedMap<String, String> myMap = new LinkedMap<String, String>();


		//----------------------------------------------------------------------------
		//	Define a Map to associate a person's name with where they live - ex. "Frank" - "Mayfield"
		//	key   - the person's name               - is a String
		//	value - the name of the place they live - is a String

		//  key		value
		//  type	type	'Map name' = new 'typOfMap'
		Map<String, String> residence = new HashMap();		// a HashMap stores the data in an unknown order
	//	Map<String, String> residence = new TreeMap();		// a TreeMap stores the data in order
	//	Map<String, String> residence = new LinkedHashMap();// a LinkedHashMap stores the data in entry order

		// Add a few people to our Map - use .put(content-of-key, content-of-value)
		residence.put("Frank" , "Mayfield");
		residence.put("Nia" , "Streetboro");
		residence.put("Anthony", "West Des Moines, Iowa");
		residence.put("JC" , "University Heights, OH");
		residence.put("Dana" , "Buffalo");
		residence.put("Daniel" , "Buffalo");

			//use .get(key) to retrieve any entry from the Map - returns the value associated with the key given or null
		System.out.println("Anthony lives in " + residence.get("Anthony"));
		System.out.println("Dana lives in " + residence.get("Dana"));
		System.out.println("Nia lives in " + residence.get("Nia"));

		String whoWeWant = "Daniel";
		System.out.println(whoWeWant + " lives in " + residence.get(whoWeWant));

		System.out.println("John lives in " + residence.get("John"));

		System.out.println("Frank lives in " + residence.get("Frank"));

		//Since the content of a key must be unique in a Map
		//**If you try to add an entry with an existing key -
			// 	it updates the value for the existing key - AND DOESN't TELL YOU**
		System.out.println("\n-------- add Frank living in Highland Heights-------");

		residence.put("Frank" , "Highland Heights");  //"Frank" is already in the Map
		System.out.println("Frank lives in " + residence.get("Frank"));


		// Check to see if a key is already in the Map before we try to add it
		if (residence.containsKey(whoWeWant)) {	// check to see if the Map contains the key in whoWeWant
			System.out.println(whoWeWant + " is already in the Map - continuing will update the value");
		}
		else {		// if whoWeWant is not already in the Map - add them
			residence.put(whoWeWant , "Timbucktu");
		}

		System.out.println("----------------------------------------------------------");

		// To process all the entries in a Map -
		// 		we need to get all the keys in the Map and use them to access them
		//
		// .keySet() may be use to retrieve all the keys from a Map as a Set object
		//		residence.keySet();
		//
		// A set object is an unique set of values from a Collection class
		//
		// To define a Set object: 	Set<data-type> name = something-that-gives-us-a-Set

		Set<String> theKeys = residence.keySet();  	// Hold all the keys from the Map - keys are String in our Map

		// We can go through the Set of keys one at a time retrieving an entry from the Map

		for (String aKey : theKeys) {        // Go through theKeys one at a time storing the current key in aKey
			System.out.println("Entry in Map for key: " + aKey + " is: " + residence.get(aKey)); // get the value for the current key
		}

		// .remove(key) - will remove an entry from the Map for the key given
		residence.remove("Frank"); //remove the entry for the "Frank" from the Map
		System.out.println("Frank lives in " + residence.get("Frank"));	// returns null because "Frank has been removed"

	}	// End of our program

}	// End of the class that contains our program



