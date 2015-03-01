package model.cards;

import model.Cards.Interfaces.Card;
import model.Cards.Interfaces.Treasure;

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
	
	public int getCost(){
		return cost;
	}
}
