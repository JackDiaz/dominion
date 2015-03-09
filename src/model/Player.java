package model;

import java.util.ArrayList;
import java.util.Collection;

import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;


public class Player {
	private Deck deck;
	private Discard dis;
	private ArrayList<Card> hand;
	private ArrayList<Card> inPlay;
	private int totalTurns;

	protected Player(){
		this.deck = new Deck();
		this.hand = new ArrayList<Card>();
		this.inPlay = new ArrayList<Card>();
		this.dis = new Discard();
		this.drawHand();
		this.totalTurns = 0;
	}
	
	public void addTurn(){
		this.totalTurns++;
	}
	
	public ArrayList<Card> getDiscardList(){
		return dis.get();
	}
	
	public int getTotalTurns(){
		return this.totalTurns;
	}

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

	public boolean hasAction(){
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
	
	public void addToDiscard(Collection<? extends Card> c){
		dis.addAll(c);
	}

	public boolean hasTreasure(){
		for(Card c : hand){
			if(c instanceof Treasure){
				return true;
			}
		}
		return false;
	}

	public void cleanUp() {
		this.discardHand();
		this.discardCardsInPlay();
		this.drawHand();
	}

	public void discard(Card c){
		if(this.has(c)){
			hand.remove(c);
			dis.add(c);
		}else{
			throw new IllegalArgumentException("problems");
		}
	}

	public Treasure getNextTreasure(){
		ArrayList<Card> toDiscard = new ArrayList<Card>();
		Card c;
		while(deck.size() > 0 || dis.size() > 0){
			c = deck.draw();
			if(c instanceof Treasure){
				dis.addAll(toDiscard);
				return (Treasure) c;
			}else{
				toDiscard.add(c);
			}
		}
		return null;
	}

	public void addToHand(Card c){
		hand.add(c);
	}
	
	public void putOnTopOfDeck(Card c){
		deck.addCard(0, c);
	}
	
	public void addToDeck(int i, Card c){
		deck.addCard(i, c);
	}
	
	public void discardDeck(){
		Card c;
		while(deck.size() > 0){
			c = deck.draw();
			dis.add(c);
		}
	}
	
	public void removeFromPlay(Card c){
		if(inPlay.contains(c)){
			inPlay.remove(c);
		}
	}

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

	public void removeFromHand(Card c){
		if(this.has(c)){
			this.hand.remove(c);
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	public void removeFromHand(ArrayList<Card> toRemove){
		for(Card c : toRemove){
			this.removeFromHand(c);
		}
	}
	
	public int handSize(){
		return hand.size();
	}
	
	public int deckSize(){
		return deck.size();
	}
	
	public int discardSize(){
		return dis.size();
	}
	
	public Card viewTop(){
		return deck.lookAtCard(0);
	}
	
	public ArrayList<Card> viewTop(int x){
		ArrayList<Card> ret = new ArrayList<Card>();
		for(int i = 0; i < x; i++){
			ret.add(deck.lookAtCard(i));
		}
		return ret;
	}

	public Card removeTop(){
		if(deck.size() == 0){
			deck.addDiscardPile(dis);
			dis.clear();
		}
		return deck.remove(0);
	}

}
