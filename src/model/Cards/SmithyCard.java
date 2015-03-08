package model.cards;

import controller.Controller;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class SmithyCard implements Card, Action{

	int cost = 4;
	int plusCards = 3;
	int plusActions = 0;
	
	
	private static SmithyCard instance;
	
	public static SmithyCard getInstance(){
		if(instance == null){
			instance = new SmithyCard();
		}
		return instance;
	}

	public void takeAction(Controller c, GameState g, Turn t) {
		Player currentPlayer = g.getCurrentPlayer();
		currentPlayer.draw(plusCards);
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
}