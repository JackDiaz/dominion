package model.cards;


import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class LaboratoryCard implements Card, Action{

	String name = "Laboratory";
	
	int cost = 5;
	
	private int plusActions = 1;
	private int plusCards = 2;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static LaboratoryCard instance;
	
	
	public static LaboratoryCard getInstance(){
		if(instance == null){
			instance = new LaboratoryCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player currentPlayer = g.getCurrentPlayer();
		currentPlayer.draw(plusCards);
		t.addActions(plusActions);
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
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name;
	}

}