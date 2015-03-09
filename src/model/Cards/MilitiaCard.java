package model.cards;



import java.util.ArrayList;
import java.util.HashMap;

import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Attack;
import model.cards.interfaces.Card;
import controller.Agent;
import controller.Controller;

public class MilitiaCard implements Card, Action, Attack{

	private String name = "Militia";
	
	private int cost = 4;
	
	private int plusActions = 0;
	private int plusCards = 0;
	private int plusBuys = 0;
	private int plusCash = 2;
	
	
	
	private static MilitiaCard instance;

	
	
	public static MilitiaCard getInstance(){
		if(instance == null){
			instance = new MilitiaCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Agent currAgent = g.getCurrentAgent();
		HashMap<Agent, Player> agentPlayer = g.getAgentPlayer();
		for(Agent agent : g.getAgents()){
			if(!agent.equals(currAgent)){
				ArrayList<Card> dis = Controller.discardDownTo(agent, 3);
				Player p = agentPlayer.get(agent);
				for(Card card : dis){
					p.discard(card);
				}
			}
		}
		t.addCash(2);
	}

	public int getCost(){
		return cost;
	}
	
	public int plusActions(){
		return plusActions;
	}
	
	public int plusCards(){
		return plusCards;
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
