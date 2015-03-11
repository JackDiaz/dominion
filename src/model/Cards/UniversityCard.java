package model.cards;

import model.GameState;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Cost;

public class UniversityCard implements Card, Action{

	private String name = "University";
	
	//private Cost cost = new Cost(2, true);
	private int cost = 2; // and a potion
	private int plusCrds = 0;
	private int plusActs = 2;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static UniversityCard instance;

	
	public static UniversityCard getInstance(){
		if(instance == null){
			instance = new UniversityCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		t.addActions(this.plusActs);
		
		
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
