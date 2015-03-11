package model.cards;

import model.GameState;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Duration;

public class FishingVillageCard implements Card, Action, Duration{

	private String name = "Fishing Village";
	
	private int cost = 3;
	
	private int plusCrds = 0;
	private int plusActs = 2;
	private int plusBuys = 0;
	private int plusCash = 1;
	
	private static FishingVillageCard instance;

	
	public static FishingVillageCard getInstance(){
		if(instance == null){
			instance = new FishingVillageCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		t.addActions(this.plusActs);
		t.addCash(this.plusCash);
	}
	
	public void duration(GameState g, Turn t){
		t.addActions(1);
		t.addCash(1);
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
