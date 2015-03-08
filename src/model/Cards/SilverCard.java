package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;

public class SilverCard implements Card, Treasure{
	int cost = 3;
	int val = 2;
	private static SilverCard instance;
	
	
	public static SilverCard getInstance(){
		if(instance == null){
			instance = new SilverCard();
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
