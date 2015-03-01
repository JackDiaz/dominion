package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;

public class SilverCard implements Card, Treasure{
	int cost;
	int val;
	
	public SilverCard(){
		this.cost = 3;
		this.val = 2;
	}
	
	public int getValue(){
		return val;
	}
	public int getCost(){
		return cost;
	}
}
