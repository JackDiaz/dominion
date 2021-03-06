package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Victory;

public class EstateCard implements Card, Victory{
	
	String name = "Estate";
	
	int cost = 2;
	int vp = 1;
	private static EstateCard instance;
	
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
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name;
	}
}
