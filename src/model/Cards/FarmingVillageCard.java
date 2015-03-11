package model.cards;

import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class FarmingVillageCard implements Card, Action{

	private String name = "Farming Village";
	
	private int cost = 4;
	
	private int plusCrds = 0;
	private int plusActs = 2;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static FarmingVillageCard instance;

	
	public static FarmingVillageCard getInstance(){
		if(instance == null){
			instance = new FarmingVillageCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player p = g.getCurrentPlayer();
		
		t.addActions(this.plusActs);
		
		Card c = p.getNextTreasureOrAction();
		p.addToHand(c);
		
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
