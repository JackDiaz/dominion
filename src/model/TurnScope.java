package model;

import model.cards.interfaces.Card;

public interface TurnScope {
	
	public int getNumActions();
	
	public int getNumBuys();
	
	public int getCash();
	
	public int getActionCostModifier();
	
	public int getCostModifier();

	public int getCostAfterModifiers(Card c);

}
