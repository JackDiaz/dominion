package model.cards;

import controller.Controller;
import model.GameState;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class WorkshopCard implements Card, Action{

	private String name = "Workshop";
	
	private int cost = 3;
	
	private int plusCrds = 0;
	private int plusActs = 0;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static WorkshopCard instance;

	
	public static WorkshopCard getInstance(){
		if(instance == null){
			instance = new WorkshopCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Card gain = Controller.gainLECost(g.getCurrentAgent(), 4);
		g.getCurrentPlayer().gain(gain);
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
