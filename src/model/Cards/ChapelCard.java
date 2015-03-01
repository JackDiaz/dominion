package model.cards;

import java.util.ArrayList;

import controller.Controller;
import controller.GameState;
import model.Action;
import model.Card;

public class ChapelCard implements Card, Action{

	int cost;
	
	public ChapelCard(){
		this.cost = 2;
	}
	
	public boolean takeAction(GameState g){
		return true;
	}

	public void takeAction(ArrayList<Controller> cont, int a, int b, int c) {
		a++;
	}
	


}
