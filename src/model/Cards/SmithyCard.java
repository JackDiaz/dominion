package model.cards;

import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class SmithyCard implements Card, Action{

	private String name = "Smithy";
	
	private int cost = 4;
	
	private int plusCards = 3;
	private int plusActions = 0;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static SmithyCard instance;
	
	public static SmithyCard getInstance(){
		if(instance == null){
			instance = new SmithyCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
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