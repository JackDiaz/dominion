package model.cards;

import java.util.ArrayList;

import controller.Controller;
import model.GameState;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class ChapelCard implements Card, Action{

	int cost;
	
	public ChapelCard(){
		this.cost = 2;
	}

	public void takeAction(GameState g, int a, int b, int c) {
		Controller currentPlayer = g.getCurrentPlayer();
		ArrayList<Card> toTrash = currentPlayer.trashDecision(4);
		currentPlayer.removeCardsFromHand(toTrash);
		g.getTrashPile().addAll(toTrash);
	}
	
	public int getCost(){
		return cost;
	}
}
