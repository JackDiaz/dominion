package model.Cards;

import controller.GameState;
import model.Action;
import model.Card;

public class ChapelCard extends Card implements Action{

	int cost;
	
	public ChapelCard(){
		this.cost = 2;
	}
	
	public boolean takeAction(GameState g){
		return true;
	}

}
