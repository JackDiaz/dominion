package model.cards;

import model.Card;
import model.Victory;

public class EstateCard implements Card, Victory{
	
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
