package com.techelevator;

import java.util.ArrayList;

//interface identifies methods (behaviors) a class implements to be this type of class
//
//if you want to be a type of CardHand, you must implement at least this behavior
//

public interface CardHand {
	
	public ArrayList<PlayingCard> getHand();	// return the PlayingCards in the hand as an ArrayList

	public void addCard(PlayingCard aCard);		// add a PlayingCard to a hang
	
	public void emptyHand();					// remove/empty all the cards in a hang

	public void show();							// display all the cards in a hand

}
