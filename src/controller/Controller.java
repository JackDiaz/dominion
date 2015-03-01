package controller;

import java.util.ArrayList;

import model.Cards.Interfaces.Action;
import model.Cards.Interfaces.Card;
import model.Cards.Interfaces.Treasure;

public interface Controller {
	
	public ArrayList<Action> actionList();
	
	public ArrayList<Card> buyList(int cash);
	
	public ArrayList<Treasure> treasureList();
	
	public Card gainCard(String prop, int value);
	
	public boolean hasActionCard();
	
	public void discardHand();
	
	public void discardCardsInPlay();
	
	public void drawHand();
	
	public void cleanUp();
	
	public boolean has(Card c);
	
	public void play(Card c);
	
	public void addToDiscard(Card c);
	
	public boolean hasTreasureCard();
	
	public ArrayList<Card> trashDecision(int num);
	
	public void removeCardsFromHand(ArrayList<Card> toRemove);
	
	public void draw(int x);
	
	public void draw();
	
	public void discardDownTo(int x);

}
