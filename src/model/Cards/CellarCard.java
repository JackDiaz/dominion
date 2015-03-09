package model.cards;

import java.util.ArrayList;

import controller.Agent;
import controller.Controller;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
public class CellarCard implements Card, Action{

	String name = "Cellar";
	
	private int cost = 2;
	
	private int plusActions = 1;
	private int plusCards = 0;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static CellarCard instance;


	public static CellarCard getInstance(){
		if(instance == null){
			instance = new CellarCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		
		t.addActions(plusActions);
		
		Player currPlayer = g.getCurrentPlayer();
		Agent currAgent = g.getCurrentAgent();
		ArrayList<Card> discard = Controller.discardToDraw(currAgent);

		for(Card card : discard){
			currPlayer.discard(card);
		}

		currPlayer.draw(discard.size());
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
