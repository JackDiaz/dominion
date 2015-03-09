package model.cards;

import model.GameState;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Attack;
import model.cards.interfaces.Card;

public class ThiefCard implements Card, Action, Attack{

	private String name = "Thief";
	
	private int cost = 4;
	
	private int plusCards = 0;
	private int plusActions = 0;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static ThiefCard instance;

	
	public static ThiefCard getInstance(){
		if(instance == null){
			instance = new ThiefCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {

	}
	
	public void attack(){
		
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
