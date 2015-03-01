package model.Cards.Interfaces;


public interface Action extends Card{

	public void takeAction(GameState g, int a, int b, int c);
}
