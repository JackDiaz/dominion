package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.cards.interfaces.Card;

public class Supply {

	HashMap<String,Integer> sup;

	public Supply(){ // list of strings for kingdom cards
		this.sup = new HashMap<String,Integer>();
		// for two player games
		// values should change for more players
		sup.put("Estate",8);
		sup.put("Duchy",8);
		sup.put("Province",8);
		sup.put("Copper",46);
		sup.put("Silver",40);
		sup.put("Gold",30);
		sup.put("Curse",10);
	}

	public Supply(ArrayList<String> cards){ // list of strings for kingdom cards
		this.sup = new HashMap<String,Integer>();
		// for two player games
		// values should change for more players
		sup.put("Estate",8);
		sup.put("Duchy",8);
		sup.put("Province",8);
		sup.put("Copper",46);
		sup.put("Silver",40);
		sup.put("Gold",30);
		sup.put("Curse",10);
		for(int i = 0; i < cards.size(); i++){
			sup.put(cards.get(i), 10);
			// number added will have to change when non-action cards are added
		}
	}

	public boolean endGame(){
		if(this.noProvinces() || this.threeAreEmpty()){
			return true;
		}
		return false;
	}

	public boolean threeAreEmpty(){
		int numEmpty = 0;

		for(Integer i : sup.values()){
			if(i == 0){
				numEmpty++;
			}
		}

		if(numEmpty < 3){
			return false;
		}
		return true;
	}

	public boolean noProvinces(){
		if(this.sup.get("Province") == 0){
			return true;
		}
		return false;
	}
	
	public boolean has(Card c){
		if(sup.get(c) > 0){
			return true;
		}
		return false;
	}
}
