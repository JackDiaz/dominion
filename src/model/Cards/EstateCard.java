package model.Cards;

import model.Card;

public class EstateCard extends Card{
	
	int cost;
	int vp;
	
	public EstateCard(){
		this.cost = 2;
		this.vp = 1;
	}
	
	public int getVP(){
		return vp;
	}
}
