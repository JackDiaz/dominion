package model.cards;

import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class CityCard implements Card, Action{

	private String name = "City";
	
	private int cost = 5;
	
	private int plusCrds = 1;
	private int plusActs = 2;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static CityCard instance;

	
	public static CityCard getInstance(){
		if(instance == null){
			instance = new CityCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player p = g.getCurrentPlayer();
		p.draw();
		t.addActions(this.plusActs);
		
		int numEmpty = g.getSupply().numberEmpty();
		if(numEmpty >= 1){
			p.draw();
		}
		if(numEmpty >= 2){
			t.addCash(1);
			t.addBuys(1);
		}
	}
	
	public int getCost(){
		return cost;
	}
	
	public int plusActions(){
		return plusActs;
	}
	
	public int plusCards(){
		return plusCrds;
	}
	
	public int plusBuys(){
		return plusBuys;
	}
	
	public int plusCash(){
		return plusCash;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name;
	}
}
