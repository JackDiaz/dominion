package model.cards;

import model.GameState;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Attack;
import model.cards.interfaces.Card;

public class WitchCard implements Card, Action, Attack{

	private String name = "Witch";
	
	private int cost = 5;
	
	private int plusCrds = 2;
	private int plusActs = 0;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static WitchCard instance;

	
	public static WitchCard getInstance(){
		if(instance == null){
			instance = new WitchCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		g.getCurrentPlayer().draw(plusCrds);
		this.attack();
	}
	
	public void attack(){
		
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
