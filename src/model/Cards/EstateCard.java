package model.Cards;

import model.Card;
import model.CardType;

public class EstateCard extends Card{
	
	int cost;
	int vp;
	CardType type;
	
	public EstateCard(){
		this.cost = 2;
		this.vp = 1;
		this.type = CardType.Victory;
	}
}
