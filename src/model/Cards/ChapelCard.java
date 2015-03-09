package model.cards;

import java.util.ArrayList;

import controller.Agent;
import controller.Controller;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class ChapelCard implements Card, Action{

	private int cost = 2;
	
	private int plusActions = 0;
	private int plusCards = 0;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static ChapelCard instance;
	
	public static ChapelCard getInstance(){
		if(instance == null){
			instance = new ChapelCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player currPlayer = g.getCurrentPlayer();
		Agent currController = g.getCurrentAgent();
		ArrayList<Card> toTrash = Controller.trashDecisionLE(currController, 4);
		currPlayer.removeFromHand(toTrash);
		g.getTrashPile().addAll(toTrash);
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
}
