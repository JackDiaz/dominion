package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Victory;

public class ProvinceCard implements Card, Victory{
	
	int cost;
	int vp;
	private static ProvinceCard instance = null;
	
	private ProvinceCard(){
		this.cost = 8;
		this.vp = 6;
	}
	
	
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
