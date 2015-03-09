package model.cards;

import model.GameState;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class FestivalCard implements Card, Action{

	private String name = "Festival";
	
	private int cost = 5;
	
	private int plusActions = 2;
	private int plusCards = 0;
	private int plusBuys = 1;
	private int plusCash = 2;
	
	private static FestivalCard instance;

	
	public static FestivalCard getInstance(){
		if(instance == null){
			instance = new FestivalCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		t.addActions(this.plusActions);
		t.addBuys(this.plusBuys);
		t.addCash(this.plusCash);
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
