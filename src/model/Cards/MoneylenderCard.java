package model.cards;


import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;

public class MoneylenderCard implements Action{

	private String name = "MoneyLender";
	
	private int cost = 4;
	
	private int plusActions = 0;
	private int plusCards = 0;
	private int plusBuys = 0;
	private int plusCash = 0;
	
	private static MoneylenderCard instance;

	public static MoneylenderCard getInstance(){
		if(instance == null){
			instance = new MoneylenderCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player currPlayer = g.getCurrentPlayer();
		if(currPlayer.has(CopperCard.getInstance())){
			currPlayer.trashFromHand(CopperCard.getInstance());
			t.addCash(3);
		}
	}

	public int getCost(){
		return cost;
	}

	public int plusActions(){
		return plusActions;
	}
	
	public int plusCards(){
		return plusCards;
	}
	
	public int plusBuys(){
		return plusBuys;
	}
	
	public int plusCash(){
		return plusCash;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name;
	}
}




