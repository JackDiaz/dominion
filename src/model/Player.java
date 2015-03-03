package model;

import java.util.ArrayList;

import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;


public class Player {
	private Deck deck;
	private Discard dis;
	private ArrayList<Card> hand;
	private ArrayList<Card> inPlay;

	protected Player(){
		this.deck = new Deck();
		this.hand = new ArrayList<Card>();
		this.inPlay = new ArrayList<Card>();
		this.dis = new Discard();
		this.drawHand();
	}
	
	// protected doesn't work for subpackages =(

	public void shuffle(){
		deck.addDiscardPile(dis);
	}

	public void discardHand(){
		for(int i = 0; i < hand.size(); i++){
			dis.add(hand.get(i));
		}
		hand.clear();
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
	
	public void draw(int x){
		for(int i = 0; i < x; i++){
			this.draw();
		}
	}

	public boolean hasActionCard(){
		for(Card c : hand){
			if(c instanceof Action){
				return true;
			}
		}
		return false;
	}

	public void play(Card c){
		if(this.has(c)){
			hand.remove(c);
			inPlay.add(c);
		}
	}

	public void addToDiscard(Card c){
		dis.add(c);
	}

	public boolean hasTreasureCard(){
		for(Card c : hand){
			if(c instanceof Treasure){
				return true;
			}
		}
		return false;
	}

	public void removeCardsFromHand(ArrayList<Card> toRemove){
		for(Card c : toRemove){
			if(this.has(c)){
				hand.remove(c);
			}
		}
	}
	
	public void cleanUp() {
		this.discardHand();
		this.discardCardsInPlay();
		this.drawHand();
	}
	
	
	
	
	// public methods for use by controllers
	
	public boolean has(Card c){
		for(Card h : hand){
			if(h.equals(c)){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Card> viewHand(){
		ArrayList<Card> handCopy = new ArrayList<Card>();
		for(Card c : hand){
			handCopy.add(c);
		}
		return handCopy;
	}
	
	
}
