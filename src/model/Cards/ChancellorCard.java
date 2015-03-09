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
	private int plusCards = 0;
	private int plusBuys = 0;
	private int plusCash = 2;
	
	private static ChancellorCard instance;

	
	public static ChancellorCard getInstance(){
		if(instance == null){
			instance = new ChancellorCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player currPlayer = g.getCurrentPlayer();
		t.addCash(plusCash);
		boolean discardDeck = Controller.discardDeck(g.getCurrentAgent());
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
	
	public int plusCards(){
		return plusCards;
	}
	
	public int plusBuys(){
		return plusBuys;
	}
	
	public int plusCash(){
		return plusCash;
	}
}
