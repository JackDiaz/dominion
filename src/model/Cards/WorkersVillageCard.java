package model.cards;

import model.GameState;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class WorkersVillageCard implements Card, Action{

	private String name = "Worker's Village";
	
	private int cost = 4;
	
	private int plusCrds = 1;
	private int plusActs = 2;
	private int plusBuys = 1;
	private int plusCash = 0;
	
	private static WorkersVillageCard instance;

	
	public static WorkersVillageCard getInstance(){
		if(instance == null){
			instance = new WorkersVillageCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		g.getCurrentPlayer().draw();
		t.addActions(this.plusActs);
		t.addBuys(this.plusBuys);
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
