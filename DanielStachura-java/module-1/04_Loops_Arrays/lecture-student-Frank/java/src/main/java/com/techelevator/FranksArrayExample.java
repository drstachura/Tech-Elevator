package com.techelevator;

public class FranksArrayExample {
	
	public static void main(String[] args) {  
		
		System.out.println("Welcome to Frank's Array Example Program");

		int score1 = 10;
		int score2 = 20;
		int score3 = 30;
		int score4 = 40;    //*this was added after the program was coded
		int score5 = 50;    //*this was added after the program was coded

		int sum = 0;        //hold the sum of the scores

		double avg = 0;     //hold the average of the scores

		sum = score1 + score2 + score3 + score4 + score5;   //*need to update the code for new data (score4 and score5)

		avg = sum / 5;                   //*need to update the code for new data (now 5 piece of data)

		//this code is *tightly coupled* - a change in the data, requires a change in the code
		//*tightly coupled code* is considered bad programming practice due to possibly forgetting to adjust
		//that is dependent on the data -> results in invalid processing

		System.out.println("Sum of the scores is: " + sum);
		System.out.println("Average of the scores is: " + avg);

//----------------------------------------------------------------------------------------

		//use an array to hold and process our scores - make the code *loosley coupled*
		//*loosley coupled code = code is not directly tied to the data
			//so changed to the data does not require changes to the code
			//also a sign of a professional programmer

	//define an empty array to hold scores and put the values in later
//		int[] myScores = new int[5];  //define an empty array of ints **add elements to 5
//
//		myScores[0] = 10;	//set first element in array to 10
//		myScores[1] = 20;	//set second element in array to 20
//		myScores[2] = 30;	//set third element in array to 30
//		myScores[3] = 40;	//added after coding set
//		myScores[4] = 50;	//added after coding set


	//define an array and initialize it to known value at the same time
	//code the values inside {} seperated by commas instead new datatype[number-elemnts]
		int[] myScores = {10,20,30}; 	//define and initialize and array - Java figures out the elements

		// use a for-loop to process an array from beginning to end
		// for-loop has 3 parts : for (initialization; condition; increment)

		// initialization - done once at the start of the process
		// condition - checked before each loop - controls how many times the loop body
		//	is exectuted
		// increment - done at the end of the loop body (just before it goes back and checks the
		//	condition

		// a for-loop will execute the statements in the loop body as long as the condition is true

		// when processing an array: initialization - set loop index to [0]
		//							 condition - loop as long as the index is inside the array
		//							 increment - add 1 to the index

		// for (int i=0; i < arrayName.length; i++)
		//		int i=0 - define and set loop index to [0] - start at first elemnt in the array
		// i < arrayName.length - keep the index inside the array (max value for i = length-1)
		// i++ - increment i (add 1 to loop index)


		int total = 0; 	//hold the sum total of all value in the array
		double average = 0;

			//loop through the array adding each element to the total
		for (int i=0; i < myScores.length; i++) {	//loop through the array adding each element to toal
			total = total + myScores[i];			//add the current element to the total (i=0, 1, 2)
		average = total / myScores.length;			//divide the sum of the elemnts by number of elements

		System.out.println("Total of array element: " + total);
		System.out.println("Average of array element is: " + average);

	//**see above - by using an array and the for loop with .length value - code is loosley coupled
	//adding or removing elements does not require coding changes

		}




	}   
   
}