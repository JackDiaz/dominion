package model;

import controller.GameState;

public interface Action {

	public boolean takeAction(GameState g);
}
