package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;

public class SilverCard implements Card, Treasure{
	int cost;
	int val;
	private static SilverCard instance;
	
	private SilverCard(){
		this.cost = 3;
		this.val = 2;
	}
	
	
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
