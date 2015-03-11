package model;

import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class Turn implements TurnScope {
	
	private int numActions;
	private int numBuys;
	private int cash;
	private int actionCostModifier;
	private int costModifier;
	
	public Turn(){
		this.numActions = 1;
		this.numBuys = 1;
		this.cash = 0;
		this.actionCostModifier = 0;
		this.costModifier = 0;
	}
	
	public void newTurn(){
		this.numActions = 1;
		this.numBuys = 1;
		this.cash = 0;
		this.actionCostModifier = 0;
		this.costModifier = 0;
	}
	
	public int getNumActions(){
		return this.numActions;
	}
	
	public int getNumBuys(){
		return this.numBuys;
	}
	
	public int getCash(){
		return this.cash;
	}
	
	public void decrementActions(){
		this.numActions--;
	}
	
	public void decrementBuys(){
		this.numBuys--;
	}
	
	public void zeroActions(){
		this.numActions = 0;
	}
	
	public void addActions(int a){
		this.numActions += a;
	}
	
	public void addCash(int c){
		this.cash += c;
	}
	
	public void addBuys(int b){
		this.numBuys += b;
	}
	
	public int getActionCostModifier(){
		return actionCostModifier;
	}
	
	public int getCostModifier(){
		return costModifier;
	}
	
	public int getCostAfterModifiers(Card c){
		if(c instanceof Action){
			return c.getCost()+costModifier+actionCostModifier;
		}else{
			return c.getCost()+costModifier;
		}
	}
	
	
}
