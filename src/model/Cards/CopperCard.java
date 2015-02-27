package model.Cards;

import model.Card;
import model.CardType;

public class CopperCard extends Card{
	
	int cost;
	CardType type;
	int val;
	
	public CopperCard(){
		this.cost = 0;
		this.type = CardType.Treasure;
		this.val = 1;
	}
}
