package model.cards;

import model.GameState;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Attack;
import model.cards.interfaces.Card;

public class SpyCard implements Card, Action, Attack{

	private String name = "Spy";
	
	private int cost = 4;
	
	private int plusCards = 1;
	private int plusActions = 1;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static SpyCard instance;

	
	public static SpyCard getInstance(){
		if(instance == null){
			instance = new SpyCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		t.addActions(this.plusActions);
		g.getCurrentPlayer().draw();
		this.attack();
	}
	
	public void attack(){
		// must resolve how to do this
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
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name;
	}
}
