package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Victory;

public class DuchyCard implements Card, Victory{
	
	String name = "Duchy";
	
	int cost = 5;
	int vp = 3;
	private static DuchyCard instance;

	
	
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
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name;
	}
}
