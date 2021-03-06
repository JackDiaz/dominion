package model.cards;

import controller.Controller;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class FeastCard implements Card, Action{

	private String name = "Feast";
	
	private int cost = 4;
	
	private int plusActions = 0;
	private int plusCards = 0;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static FeastCard instance;

	
	public static FeastCard getInstance(){
		if(instance == null){
			instance = new FeastCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player currPlayer = g.getCurrentPlayer();
		
		g.trashFromPlay(currPlayer, FeastCard.getInstance());
		
		Card card = Controller.gainLECost(g.getCurrentAgent(), 5);
		currPlayer.gain(card);
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
