package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AmericanPlayingCard extends PlayingCard{
	//static means there are only one shared by all
	//final means cannot be changed once it has been assigned a value
	//static final means only one occurrence, shared by all, that can't be changed
	private static final int    DEFAULTCARDVALUE = 0;
	private static final String DEFAULTCOLOR     = "BLACK";
	private static final String DEFAULTSUIT      = "Joker";
	private static final int    MAXVALUE         = 13;
	private static final int    MINVALUE         = 0;
	private static Map<String,  String> suitMap  = new HashMap<String , String>();  //Associate a suit and a co;pr
 	private static Map<Integer, String> valueMap = new TreeMap<Integer, String>();  //Associate a value and a word describing it
														//     ~ means equals whats listed on the left of =

	// since the suitMap and valueMap are static - only static methods may change them
	// static data may exist without any objects of the class being instantiated
	// if the initializeMaps() method was in constructors, it may not run - our Maps would not get initialized
	// we need to tell Java to run initializeMaps() when the application starts which is when static data is created
	// by putting the call to initializeMaps() outside any function/method - Java knows to run it at the
	//			start of the app

	// static is required because it is calling the static method initializeMaps()
	static {	// NOTE: no function/method definition **anonymous function**
		initializeMaps();	// call the function to initialize the suitMap and valueMap
	}
	
	public AmericanPlayingCard() 
	{
		super(DEFAULTCARDVALUE, DEFAULTSUIT, DEFAULTCOLOR);
	} 

	public AmericanPlayingCard(int value, String suit) {
		// using the conditional operator (?) to provide conditional parameters to a method
		// the way the conditional operator works	condition ? value-if-true : value-if-false

		// suitMap.containsKey(suit) ? suit : DEFAULTSUIT
		//if the suitMap contains a key that equals the suit we were passed, us it, otherwise, use the DEFAULTSUIT

		// containsKey returns true or false if the key is in the Map

		//			color	!= null ?	color			: DEFAULTCOLOR
		//suitMap.get(suit) != null ? suitMap.get(suit) : DEFAULTCOLOR
		//if the value returned from the get for suitMap using the suit passed is not null. use the color from the suitMap
		//					otherwise use the DEFAULTCOLOR

		//if no color is return from the suitMap, use the DEFAULTCOLOR

		// call the super class constructor with the value passed and the suit and color we determined
		//	conditional parameter
		super(value,                                                        // Call super ctor with value passed
			  suitMap.containsKey(suit) ? suit : DEFAULTSUIT,               // If valid suit passed, use it otherwise use DEFAULTSUIT
		      suitMap.get(suit) != null ? suitMap.get(suit) : DEFAULTCOLOR);// If valid suit passed, use color for suit otherwise use DEFAULTCOLOR  
		
		if (value > MAXVALUE) {
			setValue(MAXVALUE);
		}
		if (value < MINVALUE) {
			setValue(MINVALUE);
		}
	}
//	this must be static method because it is changing static data (suitMap and valueMap)
	static private void initializeMaps() {	//initialize the suitMap and valueMaps
		//			 key	   ,  value
		suitMap.put("SPADES"   , "BLACK");
		suitMap.put("CLUBS"    , "BLACK");
		suitMap.put("DIAMONDS" , "RED");
		suitMap.put("HEARTS"   , "RED");
		suitMap.put(DEFAULTSUIT, DEFAULTCOLOR);	// the DEFAULTSUIT is associated with DEFAULTCOLOR

		//         key, value
		valueMap.put(0,"Joker");
		valueMap.put(1,"Ace");
		valueMap.put(2,"Two");
		valueMap.put(3,"Three");
		valueMap.put(4,"Four");
		valueMap.put(5,"Five");
		valueMap.put(6,"Six");
		valueMap.put(7,"Seven");
		valueMap.put(8,"Eight");
		valueMap.put(9,"Nine");
		valueMap.put(10,"Ten");
		valueMap.put(11,"Jack");
		valueMap.put(12,"Queen");
		valueMap.put(13,"King");
	}

	// It is common for a subclass to call a super class method it overrides - in this case toString()
	// because the sub class doesn't know how to handle the super class data
	// the sub class is only responsible for any data it adds to the super class
	// so all the subclass has to do is decide how to handle its new data and use the super class method
	// to handle the super class data
	//
	@Override
	public String toString() {
		return "AmericanPlayingCard: " 
	          +"Value: "  + valueMap.get(getValue()) //use the valueMap to get the VALUE name
	          +" - Color: " + suitMap.get(getSuit()) //use the suitMap to get the COLOR for the suit
			  +" - Suit: "  + getSuit()				 //us the super class method to get the SUIT
													 //super. is optional because the subclass does not have a method
													 //  called getSuit()
			  +" - super.toString()=" + super.toString() + "\n"; // calling the super class toString()
																 // super. IS required because we have a method with the
																 //		same name
																 //	if ommited super. we would be calling ourselves

	}

	public void showCard() {
		System.out.println(this.toString());
	}

}
