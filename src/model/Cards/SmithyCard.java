package model.cards;

import model.Action;
import model.Card;
import controller.Controller;
import controller.GameState;

public class SmithyCard implements Card, Action{

	int cost;

	public SmithyCard(){
		this.cost = 4;
	}

	public void takeAction(GameState g, int a, int b, int c) {
		Controller currentPlayer = g.getCurrentPlayer();
		currentPlayer.draw(3);
	}

	public int getCost(){
		return cost;
	}
}