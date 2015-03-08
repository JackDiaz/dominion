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

	private int cost;
	private static ChapelCard instance;
	
	private ChapelCard(){
		this.cost = 2;
	}
	
	public static ChapelCard getInstance(){
		if(instance == null){
			instance = new ChapelCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player currPlayer = g.getCurrentPlayer();
		Agent currController = g.getCurrentController();
		ArrayList<Card> toTrash = currController.trashDecision(4);
		currPlayer.removeCardsFromHand(toTrash);
		g.getTrashPile().addAll(toTrash);
	}
	
	public int getCost(){
		return cost;
	}
	
	public int plusActions(){
		return 0;
	}
}
