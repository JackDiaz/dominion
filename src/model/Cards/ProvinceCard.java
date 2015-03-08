package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Victory;

public class ProvinceCard implements Card, Victory{
	
	int cost = 8;
	int vp = 6;
	private static ProvinceCard instance = null;
	
	
	public static ProvinceCard getInstance(){
		if(instance == null){
			instance = new ProvinceCard();
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
