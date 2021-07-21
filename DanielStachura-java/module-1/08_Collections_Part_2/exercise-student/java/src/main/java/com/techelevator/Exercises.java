package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {

		if (animalName == null) { //if no animalName was given to the method
			return "unknown";     // 	return "unknown"
		}

		String groupName = "";    // hold the value to be returned

		// Associate an animal to a group name - use a Map
		// 	key   - animal - String
		//	value - group name - String

		Map<String, String> animals = new HashMap<String, String>();

		// we need to add the animals and their associated group names
		// since the animal name is supposed to be case INsensitive -
		// pick a case we are using - lowercase
		animals.put("rhino", "Crash");        // .put(key, value)
		animals.put("giraffe", "Tower");
		animals.put("elephant", "Herd");
		animals.put("lion", "Pride");
		animals.put("pigeon", "Kit");
		animals.put("flamingo", "Pat");
		animals.put("deer", "Herd");
		animals.put("dog", "Pack");
		animals.put("crocodile", "Float");
		animals.put("crow", "Murder");

		// Check to see if the animal name passed in to the method is in our Map - .get(animalName)
		// if we try to use the animal name passed into the method to access the Map and it's not there
		//		we get back a null
		// 		if it is there we get back the groupName
		//	Since we have to be case INsensitive and the animal name in our Map are all lowercase
		//		we need to convert the animalName passed to the method to all lowercase

		groupName = animals.get(animalName.toLowerCase());
		if (groupName == null) {    // if the animal is not in the Map
			groupName = "unknown";    // set the groupName to unknown
		}
		// if it is - set the groupName to the value from the Map for the animalName
		// if it is not - set the groupName to "unknown"


		return groupName;
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00. 				//separate return
	 *
	 * If the item number is empty or null, return 0.00. 		//separate return
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {
		if (itemNumber == null) {            // need this statement to account for itemNumbers that are not in the list
			return 0.00;
		}

		Double discountPercent = 0.00;            //this is what should be returned

		Map<String, Double> discount = new HashMap();    //create the new MAP

		discount.put("kitchen4001", 0.20);        // .put(key, value) /case INsensitive
		discount.put("garage1070", 0.15);        //String is ""  Double is just 0.00
		discount.put("livingroom", 0.10);
		discount.put("kitchen6073", 0.40);
		discount.put("bedroom3434", 0.60);
		discount.put("bath0073", 0.15);

		discountPercent = discount.get(itemNumber.toLowerCase());
		if (discountPercent == null) {    // if the itemnumber is not in the Map
			discountPercent = 0.00;    // set the discountPercent to 0.00
		}

		return discountPercent;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */

	/*
	 * Modify current map so get Peters money and get Pauls money
	 * Money is an int and not a double so $10.00 is 1000.
	 * If Peter has more than 0 divide half of it then give it to Paul
	 * Only take half of the money from Peter if Paul has less than 1000.
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {

		return null;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		return null;
	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {        //no particular order HasMap
	/*																	// first character = key
																		//last character = value
		String firstLast ="";

		Map<String, String> firstLastChar = new HashMap();
															//first character always index 0, last character .length()-1
															//Integer.toString - Convert an Integer object to a String
															//create a for loop to convert indexes to a string - index 0 and .length()-1
		ArrayList<String> names = new ArrayList();			//create new array list to .get the indexes

		for (int i=0; i <names.size(); i++){
			if names.get(0)
					Integer.toString(String[]);
		}
		firstLastChar.put("String[0]", "String[String.length()-1]") ;	//this should be the return

		return firstLast;	//this was setup just because i thought i needed to set up opening line String firsLast
	}
*/
		Map<String, String> firstLastChar = new HashMap();            //generate new map

		String firstChar = "";                                        // 2 differnt strings 1 for first char 1 for last cahr
		String lastChar = "";

		for (int i = 0; i < words.length; i++) {                        //array .length is not a method because words is not a class
			String eachWord = words[i];
			firstChar = eachWord.substring(0, 1);
			lastChar = eachWord.substring(eachWord.length() - 1);

			firstLastChar.put(firstChar, lastChar);
		}
		return firstLastChar;

	}


	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {        //new map, pull each index in the string - key,
	/*															// count them - value
																//if array is empty, return nothing

			String keyChar = "";								//key
			String valueChar = "";								//value

		Map<String, String> keyCounter = new HashMap();


		for (int i = 0; i < words.length; i++) {				//loop the array to find all values
			String eachWord = words[i];
				keyChar = eachWord.substring(0);
				valueChar = eachWord.c			//count each key to return an int

			Integer.parseInt(valueChar); 		// convert a String to an int

			keyCounter.put(keyChar, valueChar);
		}
			return keyCounter;
	}
*/
		Map<String, Integer> keyCounter = new HashMap();

		for (int i = 0; i < words.length; i++) {            //loop the array to find all values
			String eachWord = words[i];                        // when i = 0 the String contains the value in index 0 - ba
			//	is = to eachWord
			if (keyCounter.containsKey(eachWord) == false) {    // if else stmt - if flase, add to the map. if tru increase the value
				keyCounter.put(eachWord, 1);
				//				ba , 	1
			} else {
				keyCounter.put(eachWord, keyCounter.get(eachWord) + 1);//get the value of whatever key
				//					ba,					get value at ba(1) +1
				//					ba,					 get value at ba(2)	+ 1 = ba, 3
			}

		}
		return keyCounter;
	}


	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */

	//key = each int
	//value = # of times int appears
	public Map<Integer, Integer> integerCount(int[] ints) {


		Map<Integer, Integer> intCounter = new HashMap();

		for (int i = 0; i < ints.length; i++) {            //loop the array to find all values
			Integer eachInt = ints[i];                        // i = each integer in the array

			if (intCounter.containsKey(eachInt) == false) {    // if else stmt - if flase, add to the map. if tru increase the value
				intCounter.put(eachInt, 1);                    //if the int is NOT(==false) add it to the Map
			} else {
				intCounter.put(eachInt, intCounter.get(eachInt) + 1);    // same as above where if the int appears more
				//than once, increase the value by 1
			}
		}
		return intCounter;
	}









	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */

	//make it true/false for every element			//run a loop in the loop, look at index 0, then run through a loop to compare to all other elements
	//tru only if String appears >=2 times			//come out of inner for loop if count is >= 2 then add to the map with return tru
	//else false
	//map each element
	//key - element value
	//value - boolean - true if key appears more than once
	//
	public Map<String, Boolean> wordMultiple(String[] words) {

/*		Map<String, Boolean> multipleKey = new HashMap();

		for (int i = 0; i < words.length; i++) {		//run for loop, to find the elements, nest a new for loop to check
			String keyElement = words[i];				//if the element appears more than once, add to a counter
														// come out of the loop and add to the map - true if counter >=2
			boolean keyMoreThanOne = true;
			boolean keyLessTwo = false;

			if (multipleKey.containsKey(keyElement) >= 2) {    //if the key appears more than once, ==true
																	//not working because 2 is int?
																		//Integer.toString
				multipleKey.put(keyElement, keyMoreThanOne);
			}
			else (multipleKey.containsKey(keyElement) <= 2); {  //if the key appears less than 2 time, ==false
																	//not working because 2 is int?
																		//Integer.toString
				multipleKey.put(keyElement, keyLessTwo);
			}
		}


		return multipleKey;
 */

		return null;
	}




	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {
		return null;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		return null;
	}

}
