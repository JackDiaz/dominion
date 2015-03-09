package model.cards;

import model.cards.interfaces.Card;
import model.cards.interfaces.Victory;

/*
 * not fully implemented, not sure how to do it
 */

public class GardensCard implements Card, Victory{

	String name = "Gardens";
	
	private int cost = 4;
	private int vp = 0;

	
	private static GardensCard instance;

	
	public static GardensCard getInstance(){
		if(instance == null){
			instance = new GardensCard();
		}
		return instance;
	}
	
	public int getCost(){
		return cost;
	}

	public int getVP(){
		return vp;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name;
	}
}
