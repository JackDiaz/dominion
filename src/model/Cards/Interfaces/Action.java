package model.cards.interfaces;

import model.GameState;
import model.Turn;


public interface Action extends Card{

	public void takeAction(GameState g, Turn t);
	
	public int plusActions();
}
