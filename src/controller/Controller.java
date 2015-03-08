package controller;

import java.util.ArrayList;

import model.GameEngine;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.LaboratoryCard;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;

public class Controller {
	GameState gs;
	GameEngine ge;
	Agent currAgent;
	Turn turn;

	public Controller(GameState gs, GameEngine ge){
		this.gs = gs;
		this.ge = ge;
	}

	public void start(){

		boolean gameIsOver = false;
		this.turn();

		// game loop
		while(!gameIsOver){
			if(ge.gameIsOver()){
				gameIsOver = true;
			}else{
				gs.nextPlayer();
				this.turn();
			}
		}
		// game's over, do stuff
	}

	public static void main(String args[]){
		ArrayList<Card> kingdomCards = new ArrayList<Card>();
		kingdomCards.add(LaboratoryCard.getInstance());
		GameState gs = new GameState(kingdomCards);
		GameEngine ge = new GameEngine(gs);
		Controller c = new Controller(gs, ge);
		c.start();
	}

	public void turn(){
		Player currPlayer = gs.getCurrentPlayer();
		this.turn = new Turn();
		ArrayList<Action> actList;
		ArrayList<Treasure> treList;
		ArrayList<Card> buyList;


		actList = this.getActList();
		while(turn.getNumActions() > 0 
				&& actList != null
				&& !actList.isEmpty()){
			
			ge.actionPhase(turn, actList, currPlayer);
			actList = this.getActList();
		}

		
		treList = this.getTreList();
		while(treList != null
				&& !treList.isEmpty()){
			
			ge.treasurePhase(turn, treList, currPlayer);
			treList = this.getTreList();
		}

		
		buyList = this.getBuyList();
		while(turn.getNumBuys() > 0
				&& buyList != null
				&& !buyList.isEmpty()){
			
			ge.buyPhase(turn, buyList, currPlayer);
			buyList = this.getBuyList();
		}

		// clean up and draw phase
		currPlayer.cleanUp();
	}

	private ArrayList<Action> getActList(){
		// when playing with humans this would get the info from the view
		// but right now we're only worried about AI

		currAgent = gs.getCurrentController();
		return currAgent.actionList(turn.getNumActions());
	}

	private ArrayList<Treasure> getTreList(){
		// when playing with humans this would get the info from the view
		// but right now we're only worried about AI

		currAgent = gs.getCurrentController();
		return currAgent.treasureList();
	}

	private ArrayList<Card> getBuyList(){
		// when playing with humans this would get the info from the view
		// but right now we're only worried about AI

		currAgent = gs.getCurrentController();
		return currAgent.buyList(turn.getNumBuys(), turn.getCash());
	}

}
