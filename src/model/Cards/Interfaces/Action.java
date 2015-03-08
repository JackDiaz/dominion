package model.cards.interfaces;

import controller.Controller;
import model.GameState;
import model.Turn;


public interface Action extends Card{

	public void takeAction(Controller c, GameState g, Turn t);
	
	public int plusActions();
}
