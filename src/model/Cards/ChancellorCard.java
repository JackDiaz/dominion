package model.cards;

import controller.Controller;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class ChancellorCard implements Card, Action{

	private int cost = 3;
	private int plusActions = 0;
	private int plusCash = 2;
	private static ChancellorCard instance;

	
	public static ChancellorCard getInstance(){
		if(instance == null){
			instance = new ChancellorCard();
		}
		return instance;
	}

	public void takeAction(Controller c, GameState g, Turn t) {
		Player currPlayer = g.getCurrentPlayer();
		t.addCash(plusCash);
		boolean discardDeck = c.discardDeck(g.getCurrentAgent());
		if(discardDeck){
			currPlayer.discardDeck();
		}
	}
	
	public int getCost(){
		return cost;
	}
	
	public int plusActions(){
		return plusActions;
	}
}
