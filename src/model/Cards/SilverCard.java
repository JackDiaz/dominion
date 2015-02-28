package model.Cards;

import model.Card;
import model.Treasure;

public class SilverCard extends Card implements Treasure{
	int cost;
	int val;
	
	public SilverCard(){
		this.cost = 3;
		this.val = 2;
	}
	
	public int getValue(){
		return val;
	}
}
