package com.techelevator;   // Java package to hold the class
                            // A package is a group of related Java component
                            // This class is in the same packages as our application programs
                            //      so we don't have to import it into the application program

// Making the class public means anyone can use
public class PlayingCard {  // This is the start of our class

    // This a class to represent a OUR PlayingCard object - We decide what a PlayingCard is and does
    //
    // A class contains the data (variables) and methods (behaviors) for a class
    //
    // We have identified the following basic characteristics of a PlayingCard:
    //
    //  value
    //  suit
    //  color
    //  shape
    //  symbol
    //  face up / face down
    //
    // The characteristics of an object are sometimes called attributes or properties
    //
    // The attributes of class are defined as member variables in the class
    // A member is simply a variable defined in a class - a variable that is a member of a class
    //
    // To define a member variable in a class:   access - public - anyone can access - violate Encapsulation
    //                                                    private - only members the class can access
    //                                                              (Encapsulation - protecting the data)
    //                                           datatype
    //                                           name
    //
    /****************************************************************************************************
     * Data members for the class - initialization of the data is done by Constructors NOT at definition
     ***************************************************************************************************/
    private int     cardValue;  // Joker=0, Ace=1, Jack=11, Queen=12, King=13
    private String  cardSuit;
    private String  cardColor;
    private String  cardShape;
    private String  cardSymbol;
    private boolean isFaceUp;  // typically boolean variables start with the word "is"

    /****************************************************************************************************
     * methods for the class - member methods - member functions - a method is a function in a class
     ***************************************************************************************************/
    //---------------------------------------------------------------------------------------------------
    // Constructors (ctor) are methods to initialize objects of a class
    // Constructors run AUTOMATICALLY by Java when an object of the class is instantiated/created/defined
    //---------------------------------------------------------------------------------------------------
    // Every class should provide constructors to initialize data members of the class
    // If constructors are not provided for a class, Java runs a default constructor that initializes
    //     numerics=0, Strings="", booleans=false, char='', objects=null
    //
    // ctors are special methods in a class: no return type (not even void),
    //                                       name is the is the same name as the class,
    //                                       unique parameter list (data types) in the class
    //
    // ctors are usually overloaded functions - same name, but different parameter list in class
    //
    // You should always provide at least a default constructor
    // A default ctor is one that takes no parameters and sets the data members to default values
    // Java uses default ctor behinds the scenes in it processing
    //
    // Define a default ctor for a PlayingCard - YOU decide what the defaults are
    //        a default PlayingCard has: value=1, suit="Spades", color="Black",
    //                                   shape="Rectangle", symbol="A", face-up=true
    public PlayingCard() {  // default ctor - same name as class, no parameters, no return type
        cardValue  = 1;
        cardSuit   = "Spades";
        cardColor  = "Black";
        cardShape  = "Rectangle";
        cardSymbol = "A";
        isFaceUp   = true;
    }

    // Define a ctor to allow a user to create a card with a specific value, color, suit
    public PlayingCard(int value, String color, String suit) { // 3-arg ctor
        cardValue  = value;       // Set the cardValue to whatever the user wants
        cardSuit   = suit;        // Set the cardSuit to whatever the user wants
        cardColor  = color;       // Set the cardColor to whatever they want
        cardShape  = "Rectangle"; // Set the cardShape to the default shape
        cardSymbol = null;        // Since they didn't tell us the symbol - set to null (unknown)
        isFaceUp   = true;        // Since they didn't tell us about  FaceUp - set to default
    }


    //---------------------------------------------------------------------------------------------------
    //  Getters / Setters - methods that allow access, under control of the class, to private data
    //                      used so application programs can retrieve values in private data
    //                                                   or  change the values in private
    //  Not all data members are required to have Getters/Setters
    //  YOU decide which private you want to allow applications to retrieve or change
    //
    // Getters / Setters should follow the standard Java naming conventions
    //                   because many frameworks we use use Java expect the standard names
    //
    //   getVariableName        setVariableName          isBooleanVariable (getter)
    //---------------------------------------------------------------------------------------------------

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;   // We learn this. tomorrow!
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


    //---------------------------------------------------------------------------------------------------
    //  Additional methods to the class
    //---------------------------------------------------------------------------------------------------
    //



    // define a toString() to return our PlayingCard object as a String
    // so Java uses our toString() when it needs an String and not our parent (Object class) toString()

    @Override // Optional -  We will learn this tomorrow
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
}  // End of PlayingCard class
