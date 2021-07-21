package com.techelevator;

public class FranksArrayExample {
	
	public static void main(String[] args) {  
		
		System.out.println("Welcome to Frank's Array Example Program");

		int score1 = 10;
		int score2 = 20;
		int score3 = 30;
		int score4 = 40;   // This was added after the program was coded
		int score5 = 50;   // This was added after the program was coded

		int sum = 0;    // hold the sum of the scores

		double avg = 0; // hold the average of the scores

		sum = score1 + score2 + score3 + score4 + score5; // a change in data required a change in code

		avg = sum / 5;  // a change in data required a change in code

		// This code is tightly coupled because a change in the data requires a change to the code

		// tightly coupled code is considered a bad programming practice due to one possibly forgetting
		//         to change some code that depended on the data - lead to invalid processing

		System.out.println("Sum of the scores is: " + sum);
		System.out.println("Average of the scores is: " + avg);

//----------------------------------------------------------------------------------------

		// Use an array to hold and process our score - make code loosely coupled
		//
		// loosley coupled code means the code is not directly tied to the data
		//         so changes to data does not require changes to code
		//         sign of a professional programmer

		// Define an empty array to hold scores and put the values in it later

//		int[] myScores = new int[5]; // define an empty array of ints - changed to 5 after coding was done
//
//		myScores[0] = 10;  // Set the first element in the array to 10
//		myScores[1] = 20;  // Set the second element in the array to 20
//		myScores[2] = 30;  // Set the third element in the array to 30
//		myScores[3] = 40;  // Set the third element in the array to 40 - added after coding was done
//		myScores[4] = 50;  // Set the third element in the array to 50 - added after coding was done

		// Define an array and initialize it to known values at the same time
		// Code the values inside {} separated by commas instead of new datatype[number-elements]

		int[] myScores =  {10,20,30, 70, 90, 58}; // Define and initialize an array - Java figures out the number of element

		// myScores.length - the number of elements in the array
		// myScores.length - 1 = the largest valid index

		// Use a for-loop to process an array from the beginning to the end

		// a for-loop has 3-parts:  for (initialization; condition; increment)
		//
		//        initialization - done once at the start of the process
		//        condition      - is checked before each loop - controls how many times the loop is executed
		//        increment      - done at the end of the loop body (just before it goes back and checks condition)
		//
		// a for-loop will execute the statements in the loop body as long as the condition is true
		//
		// When processing an array:  initialization - set loop-index to 0
		//                            condition      - loop as long as the index is inside array
		//                            increment      - add 1 to index
		//
		// for (int i=0; i < arrayName.length; i++)
		//      int i=0 - define an set the loop-index to 0 - start at the first element in the array
		//      i < arrayName.length - keep the index inside the array (max value for i is length-1)
		//      i++ - increment i (add 1 to loop index)  - i = i+1 or i += 1 ok too

		int total = 0;  // hold the sum total of a;; value in the array
		double average= 0; // hold average od the values in the array

		//          i=3 < 3 (i will go from 0,1,2 - when i is 3 we exit the loop)
		for (int i=0; i < myScores.length; i++) {  // Loop through the array adding each element to total
			total = total + myScores[i];           //    add the current element to total (i=0, 1, 2) as we run
		}
		average = total / myScores.length;  // divide the sum of elements by the number of element

		System.out.println(" Total of array elements is: " + total);
		System.out.println("Average of array element is: " + average);

        // By using an array and the for loop with .length value - code is loosely coupled
		// Adding or removing elements does not require coding changes


	}   
   
}