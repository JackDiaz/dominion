package model.cards;

import model.GameState;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class MiningVillageCard implements Card, Action{

	private String name = "Mining Village";

	private int cost = 4;

	private int plusCrds = 1;
	private int plusActs = 2;
	private int plusBuys = 0;
	private int plusCash = 0;

	private static MiningVillageCard instance;


	public static MiningVillageCard getInstance(){
		if(instance == null){
			instance = new MiningVillageCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		g.getCurrentPlayer().draw();
		t.addActions(this.plusActs);
		if(g.getCurrentAgent().trashMiningVillage()){
			t.addCash(2);
			g.trashFromPlay(g.getCurrentPlayer(), MiningVillageCard.getInstance());
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
