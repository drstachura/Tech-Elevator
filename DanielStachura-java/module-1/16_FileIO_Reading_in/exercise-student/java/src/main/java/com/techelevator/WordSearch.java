package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner userWordInput = new Scanner(System.in);

		System.out.println("Please enter path to input file >>> ");
		String path = userWordInput.nextLine();


		System.out.println("What is the search word you are looking for?");
		String searchWord = userWordInput.nextLine();


		System.out.println("Should the search be case sensitive? (Y\\N)");
		String caseSensitive = userWordInput.nextLine();

//		File aliceAdventures = new File("alices_adventures_in_wonderland.txt");
//		File aliceAdventures = new File("./java/src/test/resources/dr_jekyll_mr_hyde.txt");
		File aliceAdventures = new File(path);

		Scanner scanAlice = new Scanner(aliceAdventures);

		String aLine = "";
		int lineCount = 0;

		while (scanAlice.hasNextLine()) {

			aLine = scanAlice.nextLine();
			lineCount++;

			String[] wordsInTest = aLine.split(" ");

			for (String theWord : wordsInTest) {
				if (caseSensitive.equals("Y")) {
					if (theWord.contains(searchWord)) {
						System.out.println(lineCount + ") " + aLine);
					}
				}
					if (caseSensitive.equals("N")) {
						if (theWord.toLowerCase().contains(searchWord.toLowerCase())) {
							System.out.println(lineCount + ") " + aLine);
						}
					}
				}
			}// End of main()
		}
	}





