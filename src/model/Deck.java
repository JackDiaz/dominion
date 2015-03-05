package model;

import java.util.ArrayList;

import model.cards.interfaces.Card;
import model.cards.CopperCard;
import model.cards.EstateCard;

public class Deck {
	private ArrayList<Card> deck;
	
	Deck(){
		this.deck = new ArrayList<Card>();
		for(int i = 0; i < 7; i++){
			deck.add(CopperCard.getInstance());
		}
		for(int i = 0; i < 3; i++){
			deck.add(EstateCard.getInstance());
		}
		this.shuffle();
		// adding this comment
	}
	
	void shuffle(){
		ArrayList<Card> shuffled = new ArrayList<Card>();
		for(int i = deck.size(); i > 0; i--){
			double random = Math.random()*deck.size();
			int slot = (int)Math.floor(random);
			shuffled.add(deck.get(slot));
			deck.remove(slot);
		}
		deck = shuffled;
	}
	
	Card draw(){
		Card ret = deck.get(0);
		deck.remove(0);
		return ret;
	}
	
	ArrayList<Card> draw(int x){
		ArrayList<Card> toDraw = new ArrayList<Card>();
		for(int i = 0; i < x; i++){
			toDraw.add(this.draw());
		}
		return toDraw;
	}
	
	void addDiscardPile(Discard dis){
		dis.shuffle();
		deck.addAll(dis.get());
	}
	
	int size(){
		return deck.size();
	}
	
	void putCardOnTop(Card card){
		deck.add(0, card);
	}
	
	Card lookAtCard(int index){
		return deck.get(index);
	}
}
