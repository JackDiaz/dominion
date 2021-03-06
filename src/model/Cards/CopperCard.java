package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;

public class CopperCard implements Card, Treasure{
	
	String name = "Copper";
	
	int cost = 0;
	int val = 1;
	private static CopperCard instance;	
	
	public static CopperCard getInstance(){
		if(instance == null){
			instance = new CopperCard();
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
