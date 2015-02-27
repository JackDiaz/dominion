package model;

import java.util.ArrayList;

public class Card {
	
	public enum CardType {
		Treasure, Victory, Action, Curse
	}
	
	String name;
	CardType type;
	//ArrayList<Effect> effects();
	int cost;
	int value;
	int victoryPoints;
	
	public Card(String name){
		this.name = name;
		if(name.equals("Copper")){
			this.cost = 0;
			this.value = 1;
			this.type = CardType.Treasure;
		}else if(name.equals("Estate")){
			this.cost = 2;
			this.type = CardType.Victory;
			this.victoryPoints = 1;
		}
	}

	
	
}
