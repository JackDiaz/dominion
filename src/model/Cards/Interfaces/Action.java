package model.cards.interfaces;

import model.GameState;


public interface Action extends Card{

	public void takeAction(GameState g, int a, int b, int c);
	
	public int plusActions();
}
