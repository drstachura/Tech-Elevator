package com.techelevator;

public class PlayingCard {
	
	private int value;    
	private String color;    
	private String suit;     
	
	
	public PlayingCard(int value, String suit, String color) {
		this.value = value;
		this.suit  = suit;
		this.color = color;
	}
	
	public int getValue() { return value; }
	public String getColor() {
		return color;
	}
	public String getSuit() {
		return suit;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}

	// If the behavior of the super class methods is not what you want - you override them
	//
	// Right now, we don't like what the Object class toString() and equals() methods do, so we override them

	@Override // Optional - ask compiler to verify this is proper override of the super class method
	          // 				a proper override has the same return-type, name, parameters
	          // we are overriding the Object c;ass tpString()m method which:
		      //				return a String, is called
	public String toString() {
		return "PlayingCard [value=" + value + ", color=" + color + ", suit=" + suit + ", getValue()=" + getValue()
				+ ", getColor()=" + getColor() + ", getSuit()=" + getSuit() + "]";
	}
	
	@Override 	// Optional - ask compiler to verify this is proper override of the super class method
				// 				a proper override has the same return-type, name, parameters
				// we are overriding the Object c;ass tpString()m method which:
				//				return a String, is called
				// NOTE: Using an Object class object usually requires casting to another class to use
				//			an Object class object is a generic object and Java needs to know the specific class

	public boolean equals(Object obj) {	//return a boolean and receive an Object class object i am calling obj
	//					  data   name
	//					  type
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PlayingCard other = (PlayingCard) obj;	// We need to create a PlayingCard object from the generic
												//	object so we can use it
												// by casting to a PlayingCard and assign to a new object so we can use it
		if (color != other.color) {
			return false;
		}
		if (suit != other.suit) {
			return false;
		}
		if (value != other.value) {
			return false;
		}
		return true;
	}

	// super class is required to have any method where Polymorphism might be used - even if it doesn't need it
	public void showCard() {}	//required for Polymorphism to work - even though it does nothing

}	// End of PlayingCard class
