package model.cards;


import controller.Controller;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.interfaces.Action;

public class MoneylenderCard implements Action{

	private int cost = 4;
	private static MoneylenderCard instance;

	public static MoneylenderCard getInstance(){
		if(instance == null){
			instance = new MoneylenderCard();
		}
		return instance;
	}

	public void takeAction(Controller c, GameState g, Turn t) {
		Player currPlayer = g.getCurrentPlayer();
		if(currPlayer.has(CopperCard.getInstance())){
			currPlayer.removeFromHand(CopperCard.getInstance());
			g.getTrashPile().add(CopperCard.getInstance());
			t.addCash(3);
		}
	}

	public int getCost(){
		return cost;
	}

	public int plusActions(){
		return 0;
	}
}




