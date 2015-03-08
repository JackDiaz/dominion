package model.cards;

import controller.Controller;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;

public class AdventurerCard implements Card, Action{

	private int cost = 6;
	private int plusActions = 0;
	private static AdventurerCard instance;

	
	public static AdventurerCard getInstance(){
		if(instance == null){
			instance = new AdventurerCard();
		}
		return instance;
	}

	public void takeAction(Controller c, GameState g, Turn t) {
		Player currPlayer = g.getCurrentPlayer();
		Treasure treasure = currPlayer.getNextTreasure();
		
		if(treasure != null){
			currPlayer.addToHand(treasure);
		}
		
		treasure = currPlayer.getNextTreasure();
		
		if(treasure != null){
			currPlayer.addToHand(treasure);
		}
	}
	
	public int getCost(){
		return cost;
	}
	
	public int plusActions(){
		return plusActions;
	}
}
