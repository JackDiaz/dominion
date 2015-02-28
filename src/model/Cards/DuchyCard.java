package model.Cards;

import model.Card;

public class DuchyCard extends Card{
	
	int cost;
	int vp;
	
	public DuchyCard(){
		this.cost = 5;
		this.vp = 3;
	}
	
	public int getVP(){
		return vp;
	}
}
