package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;

public class GoldCard implements Card, Treasure{
	int cost = 6;
	int val = 3;
	private static GoldCard instance;

	
	public static GoldCard getInstance(){
		if(instance == null){
			instance = new GoldCard();
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
