package model.cards;

import model.Card;
import model.Treasure;

public class GoldCard implements Card, Treasure{
	int cost;
	int val;
	
	public GoldCard(){
		this.cost = 6;
		this.val = 3;
	}
	
	public int getValue(){
		return val;
	}
}
