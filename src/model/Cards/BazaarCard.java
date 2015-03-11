package model.cards;

import model.GameState;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class BazaarCard implements Card, Action{

	private String name = "Bazaar";
	
	private int cost = 5;
	
	private int plusCrds = 1;
	private int plusActs = 2;
	private int plusBuys = 0;
	private int plusCash = 1;
	
	private static BazaarCard instance;

	
	public static BazaarCard getInstance(){
		if(instance == null){
			instance = new BazaarCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		g.getCurrentPlayer().draw();
		t.addActions(this.plusActs);
		t.addCash(this.plusCash);
	}
	
	public int getCost(){
		return cost;
	}
	
	public int plusActions(){
		return plusActs;
	}
	
	public int plusCards(){
		return plusCrds;
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
