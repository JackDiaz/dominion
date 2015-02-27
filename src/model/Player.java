package model;

import java.util.ArrayList;

import model.Card.CardType;

public class Player {
	Deck deck;
	Discard dis;
	public ArrayList<Card> hand;
	ArrayList<Card> inPlay;

	public Player(){
		this.deck = new Deck();
		this.hand = new ArrayList<Card>();
		this.inPlay = new ArrayList<Card>();
		this.dis = new Discard();
		this.drawHand();
	}

	public void shuffle(){
		deck.addDiscardPile(dis);
	}

	public void discardHand(){
		for(int i = 0; i < hand.size(); i++){
			dis.add(hand.get(i));
		}
	}
	
	public void discardCardsInPlay(){
		for(Card c : inPlay){
			dis.add(c);
		}
		inPlay.clear();
	}

	public void drawHand(){
		for(int i = 0; i < 5; i++){
			this.draw();
		}
	}

	public void draw(){
		if(deck.size() == 0){
			deck.addDiscardPile(dis);
			dis.clear();
		}
		hand.add(deck.draw());
	}
	
	public boolean hasActionCard(){
		for(Card c : hand){
			if(c.type.equals(CardType.Action)){
				return true;
			}
		}
		return false;
	}
}
