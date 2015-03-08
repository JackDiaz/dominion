package model;

public class Turn {
	
	int numActions;
	int numBuys;
	int cash;
	
	public Turn(){
		this.numActions = 1;
		this.numBuys = 1;
		this.cash = 0;
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
	
	// public methods below because the actions need to use them
	
	public void addActions(int a){
		this.numActions += a;
	}
	
	public void addCash(int c){
		this.cash += c;
	}
	
	public void addBuys(int b){
		this.cash += b;
	}
	
	
	
	
}
