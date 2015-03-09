package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.cards.interfaces.Card;
import controller.Agent;
import controller.Dummy;

public class GameState {
	private ArrayList<Player> players;
	//private ArrayList<Player> players;
	
	private ArrayList<Agent> agents;
	
	private HashMap<Agent, Player> agentPlayer;
	private HashMap<Player, Agent> playerAgent;
	
	private int first;
	
	private Supply sup;
	
	private int numPlayers;
	private Player currentPlayer;
	private Agent currentAgent;
	private static ArrayList<Card> trashPile = new ArrayList<Card>();
	private int playerNumber;
	
	public GameState(ArrayList<Card> kingdomCards){
		this.players = new ArrayList<Player>();
		this.players.add(new Player("Justin"));
		this.players.add(new Player("Robbie"));
		this.agents = new ArrayList<Agent>();
		
		this.sup = new Supply(kingdomCards);
		
		this.agents.add(new Dummy(players.get(0), players.get(1), sup));
		this.agents.add(new Dummy(players.get(1), players.get(0), sup));
		
		this.agentPlayer = new HashMap<Agent, Player>();
		this.playerAgent = new HashMap<Player, Agent>();
		
		for(int i = 0; i < numPlayers; i++){
			Player player = players.get(i);
			Agent agent = agents.get(i);
			this.agentPlayer.put(agent, player);
			this.playerAgent.put(player, agent);
		}
		this.numPlayers = players.size();
		
		if(Math.random() < .5){
			this.first = 0;
		}else{
			this.first = 1;
		}
		
		this.currentPlayer = players.get(first);
		this.currentAgent = agents.get(first);
		this.playerNumber = first;
	}

	/*
	public GameState(int numPlayers){
		this.numPlayers = numPlayers;
		players = new ArrayList<Player>();
		for(int i = 0; i < numPlayers; i++){
			players.add(new Player());
		}
		this.sup = new Supply();
	}
	 */
	
	public Player getCurrentPlayer(){
		return currentPlayer;
	}
	
	public Agent getCurrentAgent(){
		return currentAgent;
	}
	
	public static ArrayList<Card> getTrashPile(){
		return trashPile;
	}
	
	public ArrayList<Agent> getAgents(){
		return agents;
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public Supply getSupply(){
		return sup;
	}
	
	public int numPlayers(){
		return numPlayers;
	}
	
	public HashMap<Agent,Player> getAgentPlayer(){
		return agentPlayer;
	}
	
	public HashMap<Player,Agent> getPlayerAgent(){
		return playerAgent;
	}
	
	public void nextPlayer(){
		playerNumber = (playerNumber + 1)%numPlayers;
		currentPlayer = players.get(playerNumber);
		currentAgent = agents.get(playerNumber);
	}
}
