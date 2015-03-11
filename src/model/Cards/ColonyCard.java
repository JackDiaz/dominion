package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Victory;

public class ColonyCard implements Card, Victory{
	
	String name = "Colony";
	
	int cost = 11;
	int vp = 10;
	private static ColonyCard instance = null;
	
	
	public static ColonyCard getInstance(){
		if(instance == null){
			instance = new ColonyCard();
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
