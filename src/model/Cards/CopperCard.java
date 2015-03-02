package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;

public class CopperCard implements Card, Treasure{
	
	int cost;
	int val;
	private static CopperCard instance;
	
	private CopperCard(){
		this.cost = 0;
		this.val = 1;
	}
	
	
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
	
}
