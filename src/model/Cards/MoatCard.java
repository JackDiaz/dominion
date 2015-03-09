package model.cards;

import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Reaction;

public class MoatCard implements Card, Action, Reaction{

	private String name = "Moat";

	private int cost = 2;

	private int plusActions = 0;
	private int plusCards = 2;
	private int plusBuys = 0;
	private int plusCash = 0;

	private static MoatCard instance;


	public static MoatCard getInstance(){
		if(instance == null){
			instance = new MoatCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player currPlayer = g.getCurrentPlayer();
		currPlayer.draw(plusCards);
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

	public void react() {
		//???
	}
}
