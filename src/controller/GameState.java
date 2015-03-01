package controller;

import java.util.ArrayList;

import model.Player;
import model.Supply;
import model.Cards.Interfaces.Action;
import model.Cards.Interfaces.Card;
import model.Cards.Interfaces.Treasure;
import controller.Controller;

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

	public void turn(){
		int actions = 1;
		int buys = 1;
		int cash = 0;
		ArrayList<Action> actList;
		ArrayList<Treasure> treList;
		ArrayList<Card> buyList;
		// action phase
		while(actions > 0){
			if(currentPlayer.hasActionCard()){
				actList = currentPlayer.actionList();
				if(actList == null){
					actions = 0;
				}else{
					for(Action a : actList){
						if(actions > 0 && currentPlayer.has(a)){
							a.takeAction(this,actions,buys,cash);
							currentPlayer.play(a);
							actions--;
						}
					}
				}
			}
		}
		// buy phase
		while(buys > 0){
			if(currentPlayer.hasTreasureCard()){
				treList = currentPlayer.treasureList();
				if(treList == null){
					
				}else{
					for(Treasure t : treList){
						if(currentPlayer.has(t)){
							cash += t.getValue();
						}
					}
				}
			}
			buyList = currentPlayer.buyList(cash);
			if(buyList.size() <= buys){
				for(Card card : buyList){
					int cost = card.getCost();
					if(sup.has(card) && cost <= cash){
						buys--;
						cash -= cost;
						currentPlayer.addToDiscard(card);
					}
				}
			
			}
			
			
			
			
			
			

		}


		// clean up phase
		currentPlayer.cleanUp();


		/*c.discardHand();
		c.discardCardsInPlay();

		// draw phase
		c.drawHand();
		 */
	}

	public void start(){
		boolean gameIsOver = false;
		int cPNumber = first;
		currentPlayer = controllers.get(cPNumber);
		while(!gameIsOver){
			turn();
			if(sup.endGame()){
				gameIsOver = true;
			}else{
				cPNumber = ((cPNumber + 1) % numPlayers);
				currentPlayer = controllers.get(cPNumber);
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
