package model;

import java.util.ArrayList;

import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;
import controller.Controller;

public class GameEngine {
	
	GameState gs;
	
	public GameEngine(GameState gs){
		this.gs = gs;
	}

	public void turn(){
		int numActions = 1;
		int numBuys = 1;
		int cash = 0;
		ArrayList<Action> actList;
		ArrayList<Treasure> treList;
		ArrayList<Card> buyList;
		Controller currController = gs.getCurrentController();
		Player currPlayer = gs.getCurrentPlayer();
		// action phase
		while(numActions > 0){
			if(currPlayer.hasActionCard()){
				actList = currController.actionList(numActions);
				if(actList == null){
					numActions = 0;
				}else{
					for(Action a : actList){
						if(numActions > 0 && currPlayer.has(a)){
							a.takeAction(gs,numActions,numBuys,cash);
							currPlayer.play(a);
							numActions--;
						}
					}
				}
			}else{
				numActions = 0;
			}	
		}
		// buy phase
		while(numBuys > 0){
			if(currPlayer.hasTreasureCard()){
				treList = currController.treasureList();
				if(treList == null){

				}else{
					for(Treasure t : treList){
						if(currPlayer.has(t)){
							currPlayer.play(t);
							cash += t.getValue();
						}
					}
				}
			}
			buyList = currController.buyList(cash);
			if(buyList.size() <= numBuys){
				for(Card card : buyList){
					int cost = card.getCost();
					if(gs.getSupply().has(card) && cost <= cash){
						numBuys--;
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
		turn();
		while(!gameIsOver){
			if(gs.getSupply().endGame()){
				gameIsOver = true;
			}else{
				gs.nextPlayer();
				this.turn();
			}
		}
		// game's over, do stuff
	}

	public static void main(String args[]){
		boolean newGame = true;
		System.out.println("Start");
		while(newGame){
			GameState gs = new GameState();
			GameEngine ge = new GameEngine(gs);
			ge.start();
			System.out.println("End");
		}
	}
}
