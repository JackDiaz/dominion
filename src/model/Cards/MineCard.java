package model.cards;

import controller.Agent;
import controller.Controller;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;

public class MineCard implements Card, Action{

	private String name = "Mine";
	
	private int cost = 5;
	
	private int plusActions = 0;
	private int plusCards = 0;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static MineCard instance;

	
	public static MineCard getInstance(){
		if(instance == null){
			instance = new MineCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		
		Agent currAgent = g.getCurrentAgent();
		Player currPlayer = g.getCurrentPlayer();
		
		Treasure trash = Controller.trashTreasureFromHand(currAgent);
		int gainCost = trash.getCost()+3;
		Treasure gain = Controller.gainTreasureLECost(currAgent, gainCost);
		
		g.trashFromHand(currPlayer, trash);
		currPlayer.gainIntoHand(gain);
		
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
