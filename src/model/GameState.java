package model;

import java.util.ArrayList;

import model.cards.LaboratoryCard;
import model.cards.interfaces.Card;
import controller.Agent;
import controller.Controller;
import controller.Dummy;

public class GameState {
	private ArrayList<Agent> controllers;
	private ArrayList<Player> players;
	
	private int first;
	
	private Supply sup;
	
	private int numPlayers;
	private Player currentPlayer;
	private Agent currentController;
	private ArrayList<Card> trashPile;
	private int playerNumber;
	
	public GameState(ArrayList<Card> kingdomCards){
		this.players = new ArrayList<Player>();
		this.players.add(new Player());
		this.players.add(new Player());
		this.controllers = new ArrayList<Agent>();
		this.controllers.add(new Dummy(players.get(0)));
		this.controllers.add(new Dummy(players.get(1)));		
		this.sup = new Supply(kingdomCards);
		this.numPlayers = players.size();
		if(Math.random() < .5){
			this.first = 0;
		}else{
			this.first = 1;
		}
		this.currentPlayer = players.get(first);
		this.currentController = controllers.get(first);
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
	
	public Agent getCurrentController(){
		return currentController;
	}
	
	public ArrayList<Card> getTrashPile(){
		return trashPile;
	}
	
	public ArrayList<Agent> getControllers(){
		return controllers;
	}
	
	public Supply getSupply(){
		return sup;
	}
	
	public int numPlayers(){
		return numPlayers;
	}
	
	public void nextPlayer(){
		playerNumber = (playerNumber + 1)%numPlayers;
		currentPlayer = players.get(playerNumber);
		currentController = controllers.get(playerNumber);
	}
}
