package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Victory;

public class DuchyCard implements Card, Victory{
	
	int cost;
	int vp;
	private static DuchyCard instance;
	
	private DuchyCard(){
		this.cost = 5;
		this.vp = 3;
	}
	
	
	public static DuchyCard getInstance(){
		if(instance == null){
			instance = new DuchyCard();
		}
		return instance;
	}
	
	public int getVP(){
		return vp;
	}
	
	public int getCost(){
		return cost;
	}
}
