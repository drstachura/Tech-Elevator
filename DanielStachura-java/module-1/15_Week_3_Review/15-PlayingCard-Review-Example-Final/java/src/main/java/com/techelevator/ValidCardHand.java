package com.techelevator;

/**************************************************************************************************************
 * An interface idenfies methods that must be defined by class implementing the interface
 *
 * Think it as behaviors a class must exhibit to be a type of the interface
 *
 * An interface only contains method signatures followed by a colon - no body/code in the methods
 *************************************************************************************************************/

public interface ValidCardHand {
	
	public void clearHand();                // Remove all cards from a hand
	public void show();                     // Display all cards in a hand 
	public void dealHand(CardDeck aDeck);   // Fill a hand from a CardDeck object
	public void addCard(PlayingCard aCard); // Add card to a hand
}
