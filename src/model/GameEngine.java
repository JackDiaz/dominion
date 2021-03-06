package model;

import java.util.ArrayList;

import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;

public class GameEngine {

	GameState gs;

	public GameEngine(GameState gs){
		this.gs = gs;
	}

	public void actionPhase(Turn turn, ArrayList<Action> actList, Player currPlayer){
		// action phase
		for(Action a : actList){
			if(turn.getNumActions() > 0 && currPlayer.has(a)){
				currPlayer.play(a);
				turn.decrementActions();
				a.takeAction(gs, turn);
			}else{
				throw new IllegalArgumentException("Is this where I put my message?");
			}
		}
	}

	public void treasurePhase(Turn turn, ArrayList<Treasure> treList, Player currPlayer){
		// play treasure

		for(Treasure t : treList){
			if(currPlayer.has(t)){
				currPlayer.play(t);
				turn.addCash(t.getValue());
			}else{
				throw new IllegalArgumentException("Is this where I put my message?");
			}
		}
	}

	public void buyPhase(Turn turn, ArrayList<Card> buyList, Player currPlayer){
		// buy phase
		int cash = turn.getCash();
		if(buyList.size() <= turn.getNumBuys()){
			for(Card card : buyList){
				int cost = card.getCost() + turn.getCostModifier();
				if(card instanceof Action){
					cost += turn.getActionCostModifier();
				}
				if(gs.getSupply().has(card) && cost <= cash){
					turn.decrementBuys();
					cash -= cost;
					turn.addCash(-cost);
					currPlayer.gain(card);
					gs.getSupply().remove(card);
				}else{
					throw new IllegalArgumentException("Is this where I put my message?");
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
	
	public boolean gameIsOver(){
		return gs.getSupply().endGame();
	}
}