package model;

import java.util.ArrayList;

import model.cards.CopperCard;
import model.cards.EstateCard;

public class Deck {
	ArrayList<Card> deck;
	
	public Deck(){
		this.deck = new ArrayList<Card>();
		for(int i = 0; i < 7; i++){
			deck.add(new CopperCard());
		}
		for(int i = 0; i < 3; i++){
			deck.add(new EstateCard());
		}
		this.shuffle();
	}
	
	public void shuffle(){
		ArrayList<Card> shuffled = new ArrayList<Card>();
		for(int i = 0; i < deck.size(); i++){
			double random = Math.random()*deck.size();
			int slot = (int)Math.floor(random);
			shuffled.add(deck.get(slot));
			deck.remove(slot);
		}
		deck = shuffled;
	}
	
	public Card draw(){
		Card ret = deck.get(0);
		deck.remove(0);
		return ret;
	}
	
	public void addDiscardPile(Discard dis){
		dis.shuffle();
		deck.addAll(dis.get());
	}
	
	public int size(){
		return deck.size();
	}
	
	public void putCardOnTop(Card card){
		deck.add(0, card);
	}
	
	public Card lookAtCard(int index){
		return deck.get(index);
	}
}
