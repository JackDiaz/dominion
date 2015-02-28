package model.Cards;

import model.Card;
import model.Treasure;

public class GoldCard extends Card implements Treasure{
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
