package model.cards;

import model.Cards.Interfaces.Card;
import model.Cards.Interfaces.Victory;

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
	
	public int getCost(){
		return cost;
	}
}
