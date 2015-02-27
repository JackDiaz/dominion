package model.Cards;

import model.Card;
import model.CardType;

public class ChapelCard extends Card{

	int cost;
	CardType type;
	
	public ChapelCard(){
		this.cost = 2;
		this.type = CardType.Action;
	}

}
