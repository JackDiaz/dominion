package model.cards;

import java.util.ArrayList;

import controller.Agent;
import controller.Controller;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class LibraryCard implements Card, Action{

	private int cost = 5;

	private int plusActions = 0;
	private int plusCards = 0;
	private int plusBuys = 0;
	private int plusCash = 0;

	private static LibraryCard instance;


	public static LibraryCard getInstance(){
		if(instance == null){
			instance = new LibraryCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player currPlayer = g.getCurrentPlayer();
		Agent currAgent = g.getCurrentAgent();
		Card card;
		ArrayList<Card> discard = new ArrayList<Card>();
		while(currPlayer.handSize() < 7 
				&& (currPlayer.deckSize() > 0 || currPlayer.discardSize() > 0)){
			card = currPlayer.viewTop();
			if(card instanceof Action){
				boolean add = Controller.addToHand(currAgent, card);
				if(add){
					currPlayer.draw();
				}else{
					discard.add(currPlayer.removeTop());
				}
			}else{
				discard.add(card);
			}
		}
		currPlayer.addToDiscard(discard);
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
}
