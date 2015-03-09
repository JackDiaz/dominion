package model.cards;

import model.GameState;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class MarketCard implements Card, Action{

	private int cost = 5;
	
	private int plusActions = 1;
	private int plusCards = 1;
	private int plusBuys = 1;
	private int plusCash = 1;
	
	private static MarketCard instance;

	
	public static MarketCard getInstance(){
		if(instance == null){
			instance = new MarketCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		g.getCurrentPlayer().draw();
		t.addActions(plusActions);
		t.addBuys(plusBuys);
		t.addCash(plusCash);
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
