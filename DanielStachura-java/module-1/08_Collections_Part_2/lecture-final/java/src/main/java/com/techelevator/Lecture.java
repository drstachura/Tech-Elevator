package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		// Map is a Collection class to store and access key-value pairs
		//
		// The key   - is a unique identifier to associate with a value
		// The value - the data to be associated with a key
		//
		// A Map is also known as as "associative array"
		//
		// the content of the key must be uniques
		// the content of the value does not have to be unique

		// Types of Maps"
		//
		//       HashMap       - entries are stored in an unknown order
		//       TreeMap       - entries are stored in key sequence order
		//       LinkedHashMap - entries are stored in the order in which they were added

		// Two common ways of defining a map:
		//
		//    Map<key-data-type, value-data-type>        nameOfMap = new typeOfMap();
		//
		//    typeOfMap<key-data-type, value-data-type>  nameOfMap = new typeOfMap();
		//
		// Define a Map where the key is a String and the value is String
		//
		//    Map<String, String>     myMap = new HashMap();
		//    HashMap<String, String> myMap = new HashMap();
		//    Map<String, String>     myMap = new HashMap<String, String>();
		//    HashMap<String, String> myMap = new HashMap<String, String>();
		//
		//    Map<String, String>     myMap = new TreeMap();
		//    TreeMap<String, String> myMap = new TreeMap();
		//    Map<String, String>     myMap = new TreeMap<String, String>();
		//    TreeMap<String, String> myMap = new TreeMap<String, String>();
		//
		//    Map<String, String>           myMap = new LinkedHashMap();
		//    LinkedHashMap<String, String> myMap = new LinkedHashMap();
		//    LinkedMap<String, String>     myMap = new LinkedHashMap<String, String>();
		//    HashMap<String, String>       myMap = new LinkedHashMap<String, String>();

		// Define a Map to associate a person's name with where they live - ex. "Frank" - "Mayfield"
		// key   - the person's name is a String
		// value - the name of the place they live is a String
		//
		//   key    value
		//   type ,  type   Map name =  new typeOfMap();
		Map<String, String> residence = new LinkedHashMap(); // a LinkedHashMap stores the entries in entry sequence
		                                                     // a TreeMap stores the entries in key sequence
		                                                     // a HashMap stores the entries in unknown sequence
		// Add a few people to our Map use .put(content-of-key, content-of-value)
		residence.put("Frank", "Mayfield");
		residence.put("Nia", "Streetsboro");
		residence.put("Anthony", "West Des Moines, Iowa");
		residence.put("JC","University Heights, OH");
		residence.put("Dana", "Buffalo");
		residence.put("Daniel","Buffalo");

		// use .get(key) to retrieve an entry from the Map - returns the value associated with key given or null
		System.out.println("Anthony lives in " + residence.get("Anthony"));
		System.out.println("Dana lives in " + residence.get("Dana"));
		System.out.println("Nia lives in " + residence.get("Nia"));

		String whoWeWant = "Daniel";
		System.out.println(whoWeWant + " lives in " + residence.get(whoWeWant));

		System.out.println("John lives in " + residence.get("John"));

		System.out.println("Frank lives in " + residence.get("Frank"));

		// Since the content of a key must be unique in a Map
		// If you try to add an entry with existing key - it updates the value for the existing key - AND DOESN'T TELL
		System.out.println("\n-------- add Frank living in Highland Heights ---------");
		residence.put("Frank", "Highland Heights"); // "Frank" is already a key in the Map
		System.out.println("Frank lives in " + residence.get("Frank"));



		// .containsKey(key) - Check to see if a key is already in the Map before we try to add it

		if (residence.containsKey(whoWeWant)) {   // Check to see if mMap contains the key in whoWeWant
			System.out.println(whoWeWant + " is already in the Map - continuing will update the value");
		}
		else {  // if whoWeWant is not already in the Map - add them
			residence.put(whoWeWant,"Timbutu");
		}

		System.out.println("------------------------------------------------------");

		// To process all the entries in a Map
		//    we need to get all the keys in the Map and use them to access them
		//
		// .keySet() may be used to retrieve all the keys from Map as a Set object
		//
		// A Set object an a unique set of values from a Collection class
		//
		//   To define a Set object:   Set<data-type> name = something-that-gives-us-a-Set

		Set<String> theKeys = residence.keySet();  // Hold all the keys from the Map - keys are String in our Map

		// We can go through the Set of keys one at time retrieving an entry from the Map

		for (String aKey : theKeys) {  // Go through theKeys one at a time storing the current key in aKey
			System.out.println("Entry in Map for key: " + aKey + " is: " + residence.get(aKey));  // get the value for current key
		}

		// .remove(key) - will remove an entry from the Map for the key given

		residence.remove("Frank"); // remove the entry for the "Frank" from the Map
		System.out.println("Frank lives in " + residence.get("Frank"));

	} // End of our program
} // End of the class that contains our program
