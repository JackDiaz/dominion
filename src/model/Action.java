package model;

import controller.GameState;

public interface Action extends Card{

	public void takeAction(GameState g, int a, int b, int c);
}
