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
	private static ChapelCard instance;
	private int plusActions = 0;
	
	public static ChapelCard getInstance(){
		if(instance == null){
			instance = new ChapelCard();
		}
		return instance;
	}

	public void takeAction(Controller c, GameState g, Turn t) {
		Player currPlayer = g.getCurrentPlayer();
		Agent currController = g.getCurrentAgent();
		ArrayList<Card> toTrash = c.trashDecisionLE(currController, 4);
		currPlayer.removeFromHand(toTrash);
		g.getTrashPile().addAll(toTrash);
	}
	
	public int getCost(){
		return cost;
	}
	
	public int plusActions(){
		return plusActions;
	}
}
