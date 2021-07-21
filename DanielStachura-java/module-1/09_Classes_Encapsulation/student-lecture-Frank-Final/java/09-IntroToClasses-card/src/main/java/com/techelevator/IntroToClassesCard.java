package com.techelevator;

public class IntroToClassesCard {
        //------------------------------------------------------------------------------------------------------------
        // Application program for the Intro To Classes App
        //
        //  main() tells us it's the application program
        //
        //  Application programs instantiate and use classes to do work for the application
        //------------------------------------------------------------------------------------------------------------
        public static void main(String[] args) {
        /*
        *  This program will demonstrate several concepts presented in the Java cohort
        *  in the topic Introduction to Classes 		
        */
        // Instantiate a PlayingCard object:  data-type name = new datatype();
        //
        //      a class is a user defined datatype (not defined by the Java language)
        //      a class is used like a datatype
        //      the new keyword instantiate an object of the class
        //
        //      new classname() - instantiate an object of the class and run the ctor
        //                   () - indicate which ctor to run

            PlayingCard cardyMcCardCard = new PlayingCard();

            System.out.println("Our Playing Card is: " + cardyMcCardCard); // display our PlayingCard object
	//                                  String         + PlayingCard object
    //                                                 + is String concatenation symbol when used with a String
    //                                                 + needs two Strings to work
    //                                                 + needs to convert PlayingCard object to a String
    //                                                 If a class has a toString() method it will be used
    //                                                 If a class does not have a toString() method
    //                                                      it looks to the parent class for a toString() method
    //                                                      if parent has one, we use it
    //                                                  Since our parent class (Object) has a toString() - it runs
	//                                                  Object class toString() returns: packagename.className@location

            // We want to access the data member cardValue in our PlayingCard
            // We can't because it's private (Encapsulation)
            System.out.println("The value in my card is: " + cardyMcCardCard.getCardValue()); // display the value in my PlayCard
            System.out.println("The suit of  my card is: " + cardyMcCardCard.getCardSuit());  // display the suit in my PlayCard

            cardyMcCardCard.setCardValue(13); // Change the value in my card using the setter provided
            System.out.println("The value in my card is: " + cardyMcCardCard.getCardValue()); // display the value in my PlayCard

            // Right now there is nothing stopping us from setting the value to anything we want
            cardyMcCardCard.setCardValue(46); // Change the value in my card using the setter provided
            System.out.println("The value in my card is: " + cardyMcCardCard.getCardValue()); // display the value in my PlayCard

            // Define a 3 of Black, Clubs PlayingCard
            // I need to use a ctor that takes the value, color and suit of PlayingCard

            PlayingCard myCard = new PlayingCard(3, "Black", "Clubs");
            System.out.print("myCard is: " + myCard);
        }
}
		 

