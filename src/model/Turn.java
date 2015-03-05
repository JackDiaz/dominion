package model;

public class Turn {
	
	int numActions;
	int numBuys;
	int cash;
	
	void turn(){
		this.numActions = 1;
		this.numBuys = 1;
		this.cash = 0;
	}
	
	int getNumActions(){
		return this.numActions;
	}
	
	int getNumBuys(){
		return this.numBuys;
	}
	
	int getCash(){
		return this.cash;
	}
	
	void decrementActions(){
		this.numActions--;
	}
	
	void decrementBuys(){
		this.numBuys--;
	}
	
	void zeroActions(){
		this.numActions = 0;
	}
	
	// public methods below because the actions need to use them
	
	public void addActions(int a){
		this.numActions += a;
	}
	
	public void addCash(int c){
		this.cash += c;
	}
	
	
	
	
}
