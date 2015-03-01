package model.cards;

import model.Cards.Interfaces.Action;
import model.Cards.Interfaces.Card;
import controller.Controller;
import controller.GameState;

public class LaboratoryCard implements Card, Action{

	int cost;

	public LaboratoryCard(){
		this.cost = 5;
	}

	public void takeAction(GameState g, int a, int b, int c) {
		Controller currentPlayer = g.getCurrentPlayer();
		currentPlayer.draw(2);
		a += 1;
	}

	public int getCost(){
		return cost;
	}

}