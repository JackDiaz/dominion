package model;

import java.util.ArrayList;

import controller.Controller;
import controller.Human;

public class GameState {
	ArrayList<Controller> controllers;
	int first;
	Supply sup;
	int numPlayers;
	Controller currentPlayer;
	ArrayList<Card> trashPile;
	
	public GameState(){
		this.controllers = new ArrayList<Controller>();
		this.controllers.add(new Human(new Player()));
		this.controllers.add(new Human(new Player()));
		this.sup = new Supply();
		if(Math.random() < .5){
			this.first = 1;
		}else{
			this.first = 2;
		}
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
	
	public Controller getCurrentPlayer(){
		return currentPlayer;
	}
	
	public ArrayList<Card> getTrashPile(){
		return trashPile;
	}
	
	public ArrayList<Controller> getControllers(){
		return controllers;
	}
}
