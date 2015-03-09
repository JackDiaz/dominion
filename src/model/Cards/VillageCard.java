package model.cards;

import model.GameState;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class VillageCard implements Card, Action{

	private int cost = 3;
	
	String name = "Village";
	
	private int plusCards = 1;
	private int plusActions = 2;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static VillageCard instance;

	
	public static VillageCard getInstance(){
		if(instance == null){
			instance = new VillageCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		g.getCurrentPlayer().draw();
		t.addActions(plusActions);
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
