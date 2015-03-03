package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Victory;

public class EstateCard implements Card, Victory{
	
	int cost;
	int vp;
	private static EstateCard instance;
	
	private EstateCard(){
		this.cost = 2;
		this.vp = 1;
	}
	
	public static EstateCard getInstance(){
		if(instance == null){
			instance = new EstateCard();
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
