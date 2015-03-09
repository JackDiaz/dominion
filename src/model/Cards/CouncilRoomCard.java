package model.cards;

import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;

public class CouncilRoomCard implements Card, Action{

	private String name = "Council Room";
	
	private int cost = 5;
	
	private int plusActions = 0;
	private int plusCards = 4;
	private int plusBuys = 1;
	private int plusCash = 0;
	
	private static CouncilRoomCard instance;

	
	public static CouncilRoomCard getInstance(){
		if(instance == null){
			instance = new CouncilRoomCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Player currPlayer = g.getCurrentPlayer();
		currPlayer.draw(plusCards);
		t.addBuys(plusBuys);
		for(Player p : g.getPlayers()){
			if(!p.equals(currPlayer)){
				p.draw();
			}
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
