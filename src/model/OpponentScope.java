package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.cards.interfaces.Card;
import model.cards.interfaces.Duration;

public interface OpponentScope {

	public int getTotalTurns();

	public int handSize();

	public ArrayList<Duration> getDurations();

	public HashMap<Card, Integer> getDeckContents();
	
	public int getScore();

	public int valueOfDeck();
	
	public int valueOfCard();
	
	public int totalCards();
}
