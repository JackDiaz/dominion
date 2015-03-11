package model.cards;

import controller.Agent;
import controller.Controller;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class HamletCard implements Card, Action{

	private String name = "Hamlet";

	private int cost = 2;

	private int plusCrds = 1;
	private int plusActs = 1;
	private int plusBuys = 0;
	private int plusCash = 0;

	private static HamletCard instance;


	public static HamletCard getInstance(){
		if(instance == null){
			instance = new HamletCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player p = g.getCurrentPlayer();
		Agent a = g.getCurrentAgent();

		p.draw();

		t.addActions(this.plusActs);

		Card discard = Controller.discardForAction(a);
		if(discard != null){
			p.discard(discard);
			t.addActions(1);
		}

		discard = Controller.discardForBuy(a);
		if(discard != null){
			p.discard(discard);
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
