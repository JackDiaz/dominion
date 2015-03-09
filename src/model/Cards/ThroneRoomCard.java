package model.cards;

import controller.Agent;
import controller.Controller;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class ThroneRoomCard implements Card, Action{

	private String name = "Throne Room";
	
	private int cost = 4;
	
	private int plusCrds = 0;
	private int plusActs = 0;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static ThroneRoomCard instance;

	
	public static ThroneRoomCard getInstance(){
		if(instance == null){
			instance = new ThroneRoomCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Agent a = g.getCurrentAgent();
		Action toTR = Controller.throneRoom(a);
		Player p = g.getCurrentPlayer();
		p.play(toTR);
		toTR.takeAction(g, t);
		p.play(toTR);
		toTR.takeAction(g, t);
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
