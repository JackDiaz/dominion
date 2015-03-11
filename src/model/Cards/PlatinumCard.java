package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;

public class PlatinumCard implements Card, Treasure{
	
	String name = "Platinum";
	
	int cost = 9;
	int val = 5;
	private static PlatinumCard instance;

	
	public static PlatinumCard getInstance(){
		if(instance == null){
			instance = new PlatinumCard();
		}
		return instance;
	}
	
	public int getValue(){
		return val;
	}
	
	public int getCost(){
		return cost;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name;
	}
}
