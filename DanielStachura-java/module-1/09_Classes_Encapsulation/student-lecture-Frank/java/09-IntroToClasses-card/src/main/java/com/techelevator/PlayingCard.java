package com.techelevator;   // Java package to hold the class
                            // A package is a group of related Java component
                            // This class is in the same package as our application program
                            //      so we don't have to import it in to the application program



public class PlayingCard {  // This is the start of our class

    // This is a class to represent OUR PlayingCard object - **We decide what a PlayingCard is and does**
    //
    // A class contains the data (variable) and methods (behaviors) for a class
    //
    // We have identified the following basic characteristics of a PlayingCard
    //
    //  value
    //  suit
    //  color
    //  shape
    //  symbol
    //  face-up/face-down
    //
    // The characteristics of an object are sometimes called 'attributes' or 'properties' - (pieces of data)
    //
    // The attributes of a class are defined as member variables in the class
    //      A member is simple a variable defined in a class - a variable that is a member of a class
    //
    //  To define a member variable in a class:     access - public - anyone can access - violating Encapsulation
    //                                                     - private - only members of the class can access
    //                                                                 (Encapsulation - protecting the data)
    //                                              datatype
    //                                              name
    /****************************************************************************************************************
     *  Data members for the class - initialization of the data is done by Constructors NOT at definition
     ****************************************************************************************************************/

    private int cardValue;      // Ace=1, Jack=11, Queen=12, King=13
    private String cardSuit;
    private String cardColor;
    private String cardShape;
    private String cardSymbol;
    private boolean isFaceUp;   // typically boolean variables start with the word 'is' - easier to understand it's
                                //    a boolean 'is' yes, or 'is' no

    /****************************************************************************************************************
     *  Methods for the class - member methods - member functions - a method is a function in a class
     ****************************************************************************************************************/

    //---------------------------------------------------------------------------------------------------------------
    // Constructors (ctor) are methods to initialize objects of a class
    // Constructors run AUTOMATICALLY by Java when an object of the class is instantiated/created/defined
    //---------------------------------------------------------------------------------------------------------------
    // Every class should provide constructors to initialize data members of the class
    // If constructors are not provided for a class, Java runs a default constructor that initializes
    //      numerics=0, Strings="", booleans=false, char='', objects=null
    //
    //ctors are special methods in a class: no return type (not even void),
    //                                      name is the same name as the class
    //                                      unique parameter list (datatypes) in the class
    //
    // ctors are usually overloaded functions - same name, but different parameter lists in the class
    //
    // You should always provide at least a default constructor
    // A default ctor is one that takes no parameters and sets the data members to default values
    // Java uses default ctors behind the scenes in its processing
    //
    // Define a default ctor for a PlayingCard - YOU decide what the defaults are - see below for default ctor code
    //        a default PlayingCard - value=1, suit="Spades", color="Black"
    //                                shape="Rectangle", symbol="A", face-fup=true
    public PlayingCard() { //default ctor - same name as class, no parameters, no return type
        cardValue = 1;
        cardSuit = "Spades";
        cardColor = "Black";
        cardShape = "Rectangle";
        cardSymbol = "A";
        isFaceUp = true;
    }

    // Define a ctor to allow a user to create a card with a specific value, color, suit
    public PlayingCard(int value, String color, String suit) {  // 3-arg ctor
        cardValue = value;  //set the carValue to whatever the user wants
        cardSuit = suit;    //set the cardSuit to whatever the user wants
        cardColor = color;  //set the cardColor to whatever the user wants
        cardShape = "Rectangle";    //set the cardShape to the default value
        cardSymbol = null;  //since they didn't tell us the symbol - set to null(unknown)
        isFaceUp = true;    //since they didn't tell us about isFaceUp - set to default value

        //**MUST SET ALL DATATYPES
    }

    //--------------------------------------------------------------------------------------------------------------
    // Getters / Setters - methods that allow access, under control of the class, to private data
    //                      used so application programs can retrieve the values in the private data
    //                      or change the values in the private data
    // Not all data members are required to have Getters/Setters
    //  YOU decide which private data you want to allow applications to retrieve or change
    //
    // Getter /Setter should follow the standard Java naming conventions
    //                  because many frameworks we use in Java expect the standard names
    //
    //  getVariableName     setVariableName     isBooleanVariable (getter)
    //--------------------------------------------------------------------------------------------------------------

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;             // We learn about this. tomorrow
    }

    public String getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(String cardSuit) {
        this.cardSuit = cardSuit;
    }

    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    public String getCardShape() {
        return cardShape;
    }

    public void setCardShape(String cardShape) {
        this.cardShape = cardShape;
    }

    public String getCardSymbol() {
        return cardSymbol;
    }

    public void setCardSymbol(String cardSymbol) {
        this.cardSymbol = cardSymbol;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }


    //--------------------------------------------------------------------------------------------------------------
    // Additional methods to the class
    //--------------------------------------------------------------------------------------------------------------


    // define a toString() to return our PlayingCard object as a String
    // so Java uses our toString() when it needs a String and not our parent toString() (Object class)

    @Override // Optional - we will learn this tomorrow
    public String toString() {
        return "PlayingCard{" +
                "cardValue=" + cardValue +
                ", cardSuit='" + cardSuit + '\'' +
                ", cardColor='" + cardColor + '\'' +
                ", cardShape='" + cardShape + '\'' +
                ", cardSymbol='" + cardSymbol + '\'' +
                ", isFaceUp=" + isFaceUp +
                '}';
    }



}   // End of PlayingCard class
