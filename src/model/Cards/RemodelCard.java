package model.cards;

import controller.Agent;
import controller.Controller;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class RemodelCard implements Card, Action{

	private String name = "Remodel";
	
	private int cost = 4;
	
	private int plusActions = 0;
	private int plusCards = 0;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static RemodelCard instance;

	
	public static RemodelCard getInstance(){
		if(instance == null){
			instance = new RemodelCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player p = g.getCurrentPlayer();
		Agent a = g.getCurrentAgent();
		
		Card trash = Controller.trashDecisionE(g.getCurrentAgent(), 1).get(0);
		g.trashFromHand(p, trash);
		
		int cost = trash.getCost()+2;
		Card gain = Controller.gainLECost(a, cost);
		p.gain(gain);
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
