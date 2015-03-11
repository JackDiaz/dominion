package model;

import model.cards.interfaces.Card;

public interface SupplyScope {
	
	public boolean endGame();

	public boolean threeAreEmpty();
	
	public int numberEmpty();

	public boolean noProvinces();
	
	public boolean has(Card c);
	
	public int numLeft(Card c);

}
