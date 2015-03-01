package controller;

import java.util.ArrayList;

import model.Action;
import model.Player;
import model.Supply;
import controller.Controller;

public class GameState {
	ArrayList<Controller> controllers;
	int first;
	Supply sup;
	int numPlayers;

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

	public void turn(Controller c){
		int actions = 0;
		int buys = 1;
		int cash = 0;
		ArrayList<Action> actList;
		// action phase
		while(actions > 0){
			if(c.hasActionCard()){
				actList = c.actionList();
				for(Action a : actList){
					if(actions > 0 && c.has(a)){
						a.takeAction(controllers,actions,buys,cash);
						c.play(a);
					}
				}
			}
		}
		// buy phase
		while(buys > 0){
			
		}
		
		
		// clean up phase
		c.cleanUp();
		
		
		/*c.discardHand();
		c.discardCardsInPlay();
		
		// draw phase
		c.drawHand();
		*/
	}
	
	public void start(){
		boolean gameIsOver = false;
		int currentPlayer = first;
		while(!gameIsOver){
			turn(controllers.get(currentPlayer));
			if(sup.endGame()){
				gameIsOver = true;
			}else{
				currentPlayer = (currentPlayer + 1) % numPlayers;
			}
		}
	}

	public static void main(String args[]){
		System.out.println("Welcome to Dominion");
		boolean newGame = true;
		System.out.println("Would you like to start a new game?");
		while(newGame){
			GameState game = new GameState();
			game.start();
			System.out.println("Would you like to start a new game?");
		}
	}
}
