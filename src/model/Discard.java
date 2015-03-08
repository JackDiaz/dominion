package model;

import java.util.ArrayList;
import java.util.Collection;

import model.cards.interfaces.Card;

public class Discard {
	
	ArrayList<Card> dis;
	
	public Discard(){
		this.dis = new ArrayList<Card>();
	}

	public void shuffle(){
		ArrayList<Card> shuffled = new ArrayList<Card>();
		for(int i = dis.size(); i > 0; i--){
			double random = Math.random()*dis.size();
			int slot = (int)Math.floor(random);
			shuffled.add(dis.get(slot));
			dis.remove(slot);
		}
		dis = shuffled;
	}

	public void add(Card card){
		dis.add(card);
	}

	public ArrayList<Card> get(){
		return dis;
	}

	public void clear(){
		dis = new ArrayList<Card>();
	}
	
	public void addAll(Collection<? extends Card> c){
		dis.addAll(c);
	}
	
	public int size(){
		return dis.size();
	}
}
