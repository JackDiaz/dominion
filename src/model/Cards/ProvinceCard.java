package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Victory;

public class ProvinceCard implements Card, Victory{
	
	int cost;
	int vp;
	
	public ProvinceCard(){
		this.cost = 8;
		this.vp = 6;
	}
	
	public int getVP(){
		return vp;
	}
	
	public int getCost(){
		return cost;
	}
}
