package controller;

import java.util.ArrayList;

import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;
import model.cards.interfaces.Victory;

public interface Agent {
	
	public ArrayList<Action> actionList(int numActions);

	public ArrayList<Card> buyList(int numBuys, int cash);

	public ArrayList<Treasure> treasureList();

	public ArrayList<Card> trashDecisionLE(int num);
	
	public ArrayList<Card> trashDecisionE(int num);

	public ArrayList<Card> discardDownTo(int x);
	
	public Victory victoryCardOnTop();
	
	public ArrayList<Card> discardToDraw();
	
	public boolean discardDeck();
	
	public Card gainLECost(int cost);

	public boolean addToHand(Card card, Turn turn);
}
