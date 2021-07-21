package com.techelevator;

// Intellj may automatically provide the imports frp classes you are using
// Not all IDE will do this

import java.util.ArrayList;    // Give me access to code to support ArrayList class
import java.util.Collections;  // Give me access to code to support Collection classes
import java.util.List;         // Give me access to code to support List class

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		// ArrayList is a Collection class that allows use a more flexible type of array
		//    variable size, add/remove element anywhere in the list, access using methods
		// Elements are stored in the ordered there are added when using .add()
		//
		// An ArrayList is a type of List class object

		// Two common ways to define an Arraylist:
		//
		//   ArrayList<data-type> name = new ArrayList();
		//   List<data-type>      name = new ArrayList();  // More about using this style next week
		// <data-type> is the type of data to be stored in the Array list (cannot be primitive type)

		// Define a new ArrayList to hold Strings

		ArrayList<String> names = new ArrayList();  // Instantiate an empty ArrayList object

		// .add() method will add elements to the end of the ArrayList
		names.add("Frank");  // Add "Frank" to the ArrayList
		names.add("Dana");   // Add "Dana" to the ArrayList
		names.add("Alex");
		names.add("Vanese");
		names.add("Jared");

		// names.add(1) - error! Because the ArrayList is defined to hold Strings and 1 is not a String

		// .size() will return the current number of elements in an ArrayList
		System.out.println("Our Arraylist contains " + names.size() + " elements");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		// .get(index) will return the element at the index specified from the ArrayList - index starts at 0

		System.out.println("The first element is: " + names.get(0));
		System.out.println("The third element is: " + names.get(2));
		System.out.println("The last  element is: " + names.get(names.size()-1));  // index of last element is .size() - 1

		// We can use a for-loop with .get() to process all the elements from beginning to end

		for (int i=0; i < names.size(); i++) {
			System.out.println("Element at index #" + i + " is: " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add("Frank"); // We can a duplicate value to the ArrayList

		System.out.println("----------------------------------------------------------");
		for (int i=0; i < names.size(); i++) {
			System.out.println("Element at index #" + i + " is: " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		// .add(index,object) - add object to any place in the array list - index is where you want it

		names.add(3,"Jess");  // Add "Jess" at element index 3
		names.add(3,"Amber"); // Add "Amber" at element index 3

		System.out.println("----------------------------------------------------------");
		for (int i=0; i < names.size(); i++) {
			System.out.println("Element at index #" + i + " is: " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		// .remove(index) - remove the element at the index from the ArrayList

		names.remove(0); // remove the element at index 0

		System.out.println("----------------------------------------------------------");
		for (int i=0; i < names.size(); i++) {
			System.out.println("Element at index #" + i + " is: " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		// .contains(object) - return true if the object is in the ArrayList

		System.out.println("Is Amber in the list? " + names.contains("Amber"));
		System.out.println("Is Vanese in the list? " + names.contains("Vanese"));
		System.out.println("Is John is in the list? " + names.contains("John"));

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		// .indexOf(object) - return the index of the first occurrence object in the ArrayList -1 if not in ArrayList

		System.out.println("Jess is at index: " + names.indexOf("Jess"));
		System.out.println("Alex is at index: " + names.indexOf("Alex"));
		System.out.println("John is at index: " + names.indexOf("John"));

		// If "Frank" is in the ArrayList, delete him
		// .remove(index) - remove the element at the index
		// .indexOf(object) - return the index of the object in the ArrayList or -1 if it's not there
		// We can nest methods to achieve the result

		if (names.contains("Frank")) { // If "Frank" is the ArrayList
			names.remove(names.indexOf("Frank"));  // Find where "Frank" is in the ArrayList and remove him
		}

		System.out.println("----------------------------------------------------------");
		for (int i=0; i < names.size(); i++) {
			System.out.println("Element at index #" + i + " is: " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// .toArray(new datatype[0]) - convert the ArrayList to an array of the datatype after new
		//
		// This is useful when a function needs an array and you have an ArrayList

		String[] namesArray = names.toArray(new String[0]); // Convert the ArrayList to an array

		// Note: length for an array is a property - so no () follow it
		//       size() for an ArrayList is a method - so () follow it
		//       length() for a String is a method - so () follow it
		// methods always have ()
		//
		// A property is a value automatically defined by Java related to a Java data structure
		//
		// Whenever you see a word followed by () it's a method - except for if, for, while


		System.out.println("----------------------------------------------------------");
		for (int i=0; i < namesArray.length; i++) {
			System.out.println("Element at index #" + i + " is: " + namesArray[i]);
		}

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		// Collections.sort(ArrayList) - sort an ArrayList
		// .sort() is member of the Collections class so it can be used with any Collection class
		//                          ArrayList, Queue, Stack are members of the Collection class
		//
		// Collections.sort(name) - it will sort alphabetically because it contains Strings
		//                          it uses the sort/collating sequence for the coding of characters

		Collections.sort(names);  // Sort the ArrayList

		System.out.println("----------------------------------------------------------");
		for (int i=0; i < names.size(); i++) {
			System.out.println("Element at index #" + i + " is: " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		// Collections.reverse(ArrayList) - reverse the order of teh elements in the ArrayList

		Collections.reverse(names);  // Reverse the order of the ArrayList

		System.out.println("----------------------------------------------------------");
		for (int i=0; i < names.size(); i++) {
			System.out.println("Element at index #" + i + " is: " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		// for-each loop is shorthand for-loop when you want to go from the beginning to end of an array/ArrayList
		//
		// for-each ALWAYS goes from beginning to end one element at a time
		// You have no way of knowing in the loop the index or location of the current element
		// You cannot skip elements in the for-each loop
		//
		// a for-each is less flexible that a regular for-loop - easier to code
		//
		// format of for-each loop:  for (datatype element-name : array/ArrayList-name)
		//
		//          the data-type is the data-type of array/ArrayList
		//          each time through the loop, the element-name contains the current element
		//
		//          use the element-name to reference the element from the array the loop

		// Use a for-each to display all the elements in our ArrayList

		System.out.println("-----------------------------------------------------");
		for (String anElement : names) {
			System.out.println("Element from ArrayList: " + anElement);
		}
		// The for-each does the same this as:
		//        for (int i=0; i < names.size(); i++) {
		//	         System.out.println("Element at index #" + i + " is: " + names.get(i));
		//        }





	}
}
