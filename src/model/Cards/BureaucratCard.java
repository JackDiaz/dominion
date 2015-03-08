package model.cards;

import java.util.HashMap;

import controller.Agent;
import controller.Controller;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Victory;

public class BureaucratCard implements Card, Action{

	private int cost = 4;
	private int plusActions = 0;
	private static BureaucratCard instance;


	public static BureaucratCard getInstance(){
		if(instance == null){
			instance = new BureaucratCard();
		}
		return instance;
	}

	public void takeAction(Controller c, GameState g, Turn t) {
		Player currPlayer = g.getCurrentPlayer();
		Agent currAgent = g.getCurrentAgent();
		HashMap<Agent, Player> agentPlayer = g.getAgentPlayer();
		currPlayer.putOnTopOfDeck(SilverCard.getInstance());
		for(Agent a : g.getAgents()){
			if(!a.equals(currAgent)){
				Victory v = c.victoryCardOnTop(a);
				Player p = agentPlayer.get(a);
				p.removeFromHand(v);
				p.putOnTopOfDeck(v);
			}
		}
	}

	public int getCost(){
		return cost;
	}

	public int plusActions(){
		return plusActions;
	}
}
