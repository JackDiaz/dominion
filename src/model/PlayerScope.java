package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.cards.interfaces.Card;
import model.cards.interfaces.Duration;

public interface PlayerScope {
	
	public int getTotalTurns();
	
	public boolean hasAction();
	
	public boolean hasTreasure();
	
	public boolean has(Card c);
	
	public ArrayList<Card> viewHand();
	
	public int handSize();
	
	public ArrayList<Duration> getDurations();
	
	public HashMap<Card, Integer> getDeckContents();
	
	public int getScore();
	
	public int valueOfDeck();
	
	public int valueOfCard();
	
	public int totalCards();
	
	public ArrayList<Card> getNVM();
	
	public int numOf(Card c);

}
