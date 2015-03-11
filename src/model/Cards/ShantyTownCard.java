package model.cards;

import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class ShantyTownCard implements Card, Action{

	private String name = "Shanty Town";
	
	private int cost = 3;
	
	private int plusCrds = 0;
	private int plusActs = 2;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static ShantyTownCard instance;

	
	public static ShantyTownCard getInstance(){
		if(instance == null){
			instance = new ShantyTownCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player p = g.getCurrentPlayer();
		t.addActions(this.plusActs);

		if(!p.hasAction()){
			p.draw(2);
		}
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
