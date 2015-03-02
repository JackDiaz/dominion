package model;

import java.util.ArrayList;

import model.Player;
import model.Supply;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;
import controller.Controller;

public class GameEngine {
	
	GameState gs;

	public void turn(){
		int actions = 1;
		int buys = 1;
		int cash = 0;
		ArrayList<Action> actList;
		ArrayList<Treasure> treList;
		ArrayList<Card> buyList;
		Controller currPlayer = gs.getCurrentPlayer();
		// action phase
		while(actions > 0){
			if(currPlayer.hasActionCard()){
				actList = gs.getCurrentPlayer().actionList();
				if(actList == null){
					actions = 0;
				}else{
					for(Action a : actList){
						if(actions > 0 && currPlayer.has(a)){
							a.takeAction(gs,actions,buys,cash);
							currPlayer.play(a);
							actions--;
						}
					}
				}
			}
		}
		// buy phase
		while(buys > 0){
			if(currPlayer.hasTreasureCard()){
				treList = currPlayer.treasureList();
				if(treList == null){

				}else{
					for(Treasure t : treList){
						if(currPlayer.has(t)){
							cash += t.getValue();
						}
					}
				}
			}
			buyList = currPlayer.buyList(cash);
			if(buyList.size() <= buys){
				for(Card card : buyList){
					int cost = card.getCost();
					if(gs.sup.has(card) && cost <= cash){
						buys--;
						cash -= cost;
						currPlayer.addToDiscard(card);
					}
				}

			}







		}


		// clean up phase
		currPlayer.cleanUp();


		/*c.discardHand();
		c.discardCardsInPlay();

		// draw phase
		c.drawHand();
		 */
	}

	public void start(){
		boolean gameIsOver = false;
		int cPNumber = gs.first;
		Controller currentPlayer = gs.controllers.get(cPNumber);
		while(!gameIsOver){
			turn();
			if(gs.sup.endGame()){
				gameIsOver = true;
			}else{
				cPNumber = ((cPNumber + 1) % gs.numPlayers);
				currentPlayer = gs.controllers.get(cPNumber);
			}
		}
	}

	public static void main(String args[]){
		System.out.println("Welcome to Dominion");
		boolean newGame = true;
		System.out.println("Would you like to start a new game?");
		while(newGame){
			GameState game = new GameState();
			GameEngine ge = new GameEngine();
			ge.start();
			System.out.println("Would you like to start a new game?");
		}
	}
}
