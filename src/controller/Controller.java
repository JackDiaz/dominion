package controller;

import java.util.ArrayList;

import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;

public interface Controller {
	
	public ArrayList<Action> actionList(int numActions);
	
	public ArrayList<Card> buyList(int cash);
	
	public ArrayList<Treasure> treasureList();
	
	public Card gainCard(String prop, int value);
	
	public ArrayList<Card> trashDecision(int num);
	
	public void discardDownTo(int x);

}
