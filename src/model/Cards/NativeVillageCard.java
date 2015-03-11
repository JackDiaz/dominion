package model.cards;

import controller.Controller;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class NativeVillageCard implements Card, Action{

	private String name = "Native Village";
	
	private int cost = 2;
	
	private int plusCrds = 0;
	private int plusActs = 2;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static NativeVillageCard instance;

	
	public static NativeVillageCard getInstance(){
		if(instance == null){
			instance = new NativeVillageCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		t.addActions(this.plusActs);
		Player p = g.getCurrentPlayer();
		if(Controller.nativeVillage(g.getCurrentAgent())){
			Card c = p.removeTop();
			p.addToNVM(c);
		}else{
			for(Card c : p.getNVM()){
				p.addToHand(c);
			}
			p.clearNVM();
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
