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
		Turn turn = new Turn();
		ArrayList<Action> actList;
		ArrayList<Treasure> treList;
		ArrayList<Card> buyList;
		Controller currController = gs.getCurrentController();
		Player currPlayer = gs.getCurrentPlayer();
		
		
		// action phase
		while(turn.getNumActions() > 0){
			if(currPlayer.hasActionCard()){
				actList = currController.actionList(turn.getNumActions());
				if(actList == null){
					turn.zeroActions();
				}else{
					for(Action a : actList){
						if(turn.getNumActions() > 0 && currPlayer.has(a)){
							a.takeAction(gs, turn);
							currPlayer.play(a);
							turn.decrementActions();
						}
					}
				}
			}else{
				turn.zeroActions();
			}	
		}
		
		
		// play treasure
		if(currPlayer.hasTreasureCard()){
			treList = currController.treasureList();
			if(treList != null){
				for(Treasure t : treList){
					if(currPlayer.has(t)){
						currPlayer.play(t);
						turn.addCash(t.getValue());
					}
				}
			}
		}
		
		
		// buy phase
		while(turn.getNumBuys() > 0){
			int cash = turn.getCash();
			buyList = currController.buyList(cash);
			if(buyList.size() <= turn.getNumBuys()){
				for(Card card : buyList){
					int cost = card.getCost();
					if(gs.getSupply().has(card) && cost <= cash){
						turn.decrementBuys();
						cash -= cost;
						currPlayer.addToDiscard(card);
					}
				}
			}else{
				// they wanted to buy too much
				// maybe just buy the first few things on their list
				// maybe don't let them pick more than they can buy
				// maybe only let them do one buy at a time
				throw new IllegalArgumentException("Is this where I put my message?");
			}
		}
		
		
		// clean up and draw phase
		currPlayer.cleanUp();
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
