package model.cards;

import model.Card;
import model.Victory;

public class DuchyCard implements Card, Victory{
	
	int cost;
	int vp;
	
	public DuchyCard(){
		this.cost = 5;
		this.vp = 3;
	}
	
	public int getVP(){
		return vp;
	}
	
	public int getCost(){
		return cost;
	}
}
