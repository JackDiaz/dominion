package model.cards;

import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class SmithyCard implements Card, Action{

	int cost;
	private static SmithyCard instance;

	private SmithyCard(){
		this.cost = 4;
	}
	
	
	public static SmithyCard getInstance(){
		if(instance == null){
			instance = new SmithyCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player currentPlayer = g.getCurrentPlayer();
		currentPlayer.draw(3);
	}

	public int getCost(){
		return cost;
	}
	
	public int plusActions(){
		return 0;
	}
}