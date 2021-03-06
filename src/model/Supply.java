package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.cards.CopperCard;
import model.cards.DuchyCard;
import model.cards.EstateCard;
import model.cards.GoldCard;
import model.cards.ProvinceCard;
import model.cards.SilverCard;
import model.cards.interfaces.Card;

public class Supply implements SupplyScope{

	HashMap<Card,Integer> sup;

	public Supply(){ 
		this.sup = new HashMap<Card,Integer>();
		// for two player games
		// values should change for more players
		sup.put(EstateCard.getInstance(),8);
		sup.put(DuchyCard.getInstance(),8);
		sup.put(ProvinceCard.getInstance(),8);
		sup.put(CopperCard.getInstance(),46);
		sup.put(SilverCard.getInstance(),40);
		sup.put(GoldCard.getInstance(),30);
		//sup.put(CurseCard.getInstance(),10);
	}

	public Supply(ArrayList<Card> cards){ // list of kingdom cards
		this.sup = new HashMap<Card,Integer>();
		// for two player games
		// values should change for more players
		sup.put(EstateCard.getInstance(),8);
		sup.put(DuchyCard.getInstance(),8);
		sup.put(ProvinceCard.getInstance(),8);
		sup.put(CopperCard.getInstance(),46);
		sup.put(SilverCard.getInstance(),40);
		sup.put(GoldCard.getInstance(),30);
		//sup.put(CurseCard.getInstance(),10);

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
		int numEmpty = this.numberEmpty();

		if(numEmpty < 3){
			return false;
		}
		return true;
	}
	
	public int numberEmpty(){
		int numEmpty = 0;

		for(Integer i : sup.values()){
			if(i == 0){
				numEmpty++;
			}
		}
		return numEmpty;
	}

	public boolean noProvinces(){
		if(this.sup.get(ProvinceCard.getInstance()) == 0){
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
	
	public void remove(Card c){
		if(this.has(c)){
			this.sup.put(c, this.sup.get(c)-1);
		}else{
			throw new IllegalArgumentException("gain in supply");
		}
	}
	
	public int numLeft(Card c){
		return sup.get(c);
	}
}
