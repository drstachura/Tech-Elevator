package com.techelevator;

public class IntroToClassesCard {
        //------------------------------------------------------------------------------------------------------------
        // Application program for the Intro To Classes App
        //
        // main() tells us it's the application program
        //
        // Application programs instantiate and use classes to do work for the application
        //      application program uses the class we create
        //------------------------------------------------------------------------------------------------------------
        public static void main(String[] args) {
        /*
        *  This program will demonstrate several concepts presented in the Java cohort
        *  in the topic Introduction to Classes 		marketing
        */
        // Instantiate a PlayingCard object:  data-type name = new datatype(); **NEW - use it like a datatype
        //      **a class is a user define datatype (not define by the Java language)
        //      a class is used like a datatype
        //      the 'new' keyword instantiate an object of the class
        //
        //      new classname() - instantiate an object of the class and run the ctor
        //                   () - indicate which ctor to run

            PlayingCard cardyMcCardCard = new PlayingCard();



            System.out.println("Our Playing Card is: " + cardyMcCardCard); //display our PlayingCard object
        //                          String             + PlayingCard object
        //                                             + is String concatenation Symbol when used with a String
        //                                             + needs two Strings to work
        //                                             + needs to convert PlayingCard object to a String
        //                                              If a class has a toString() method it will be used
        //                                              If a class does not have a toString() method
        //                                                  it looks to the parent class for a toString() method
        //                                                  if the parent has one, we use it
        //                                              Since our parent class(Object) has a toString() method - it runs
        //                                              Object class toString() (parent) returns: packagename.className@location

            // We want to access the data member cardValue in our PlayingCard
            // We can't because the data is private (Encapsulation)
            System.out.println("The value in my card is: " + cardyMcCardCard.getCardValue()); //display the value in my PlayingCard
            System.out.println("The suit of my card is: " + cardyMcCardCard.getCardSuit()); //display the suit in my PlayingCard

            cardyMcCardCard.setCardValue(13);   //Change the value in my card using the Setter provided
            System.out.println("The value in my card is: " + cardyMcCardCard.getCardValue());

        // Right now there is nothing stopping us from setting the value to anything we want
            cardyMcCardCard.setCardValue(46);   //Change the value in my card using the Setter provided
            System.out.println("The value in my card is: " + cardyMcCardCard.getCardValue()); //display the value in my PlayingCard

            // Define a Black 3 of Clubs PlayingCard
            // I need to use a ctor that takes the value, color and suit of a PlayingCard - only have the ctor for default

            PlayingCard myCard = new PlayingCard(3, "Black", "Clubs");
            System.out.println("myCard is: " + myCard);

        }
}
		 

