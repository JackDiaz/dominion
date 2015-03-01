package model.cards;

import model.Cards.Interfaces.Card;
import model.Cards.Interfaces.Treasure;

public class CopperCard implements Card, Treasure{
	
	int cost;
	int val;
	
	public CopperCard(){
		this.cost = 0;
		this.val = 1;
	}
	
	public int getValue(){
		return val;
	}
	
	public int getCost(){
		return cost;
	}
	
}
