package model.cards;

import java.util.ArrayList;

import controller.Controller;
import model.GameState;
import model.Player;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class ChapelCard implements Card, Action{

	int cost;
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

	public void takeAction(GameState g, int a, int b, int c) {
		Player currPlayer = g.getCurrentPlayer();
		Controller currController = g.getCurrentController();
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
