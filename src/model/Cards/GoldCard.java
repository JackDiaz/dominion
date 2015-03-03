package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;

public class GoldCard implements Card, Treasure{
	int cost;
	int val;
	private static GoldCard instance;
	
	private GoldCard(){
		this.cost = 6;
		this.val = 3;
	}
	
	
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
