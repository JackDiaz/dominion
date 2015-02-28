package model.Cards;

import model.Card;

public class ProvinceCard extends Card{
	
	int cost;
	int vp;
	
	public ProvinceCard(){
		this.cost = 8;
		this.vp = 6;
	}
	
	public int getVP(){
		return vp;
	}
}
