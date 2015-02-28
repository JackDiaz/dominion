package controller;

import java.util.ArrayList;

import model.Player;
import model.Supply;

public class GameState {
	ArrayList<Player> players;
	ArrayList<Controller> controllers;
	int first;
	Supply sup;
	int numPlayers;

	public GameState(){
		this.players = new ArrayList<Player>();
		this.players.add(new Player());
		this.players.add(new Player());
		this.sup = new Supply();
		if(Math.random() < .5){
			this.first = 1;
		}else{
			this.first = 2;
		}
	}

	public GameState(int numPlayers){
		this.numPlayers = numPlayers;
		players = new ArrayList<Player>();
		for(int i = 0; i < numPlayers; i++){
			players.add(new Player());
		}
		this.sup = new Supply();
	}

	public void turn(Player p){
		int actions = 0;
		int buys = 1;
		int cash = 0;
		// action phase
		while(actions > 0){
			if(p.hasActionCard()){
				
			}
		}
		// buy phase
		while(buys > 0){
			
		}
		
		// clean up phase
		p.discardHand();
		p.discardCardsInPlay();
		
		// draw phase
		p.drawHand();
	}
	
	public void start(){
		boolean gameIsOver = false;
		int currentPlayer = first;
		while(!gameIsOver){
			turn(players.get(currentPlayer));
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
