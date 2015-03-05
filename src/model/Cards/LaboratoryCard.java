package model.cards;


import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class LaboratoryCard implements Card, Action{

	int cost;
	private static LaboratoryCard instance;
	int plusActions;

	private LaboratoryCard(){
		this.cost = 5;
		this.plusActions = 1;
	}
	
	
	public static LaboratoryCard getInstance(){
		if(instance == null){
			instance = new LaboratoryCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player currentPlayer = g.getCurrentPlayer();
		currentPlayer.draw(2);
		t.addActions(1);
	}

	public int getCost(){
		return cost;
	}
	
	public int plusActions(){
		return plusActions;
	}

}