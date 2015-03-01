package model.cards;

<<<<<<< HEAD
import model.Action;
import model.Card;
import model.GameState;
=======
import model.Cards.Interfaces.Action;
import model.Cards.Interfaces.Card;
>>>>>>> 7df14e1a459ef7bdaf362361edf8fc2349d83ee2
import controller.Controller;

public class LaboratoryCard implements Card, Action{

	int cost;

	public LaboratoryCard(){
		this.cost = 5;
	}

	public void takeAction(GameState g, int a, int b, int c) {
		Controller currentPlayer = g.getCurrentPlayer();
		currentPlayer.draw(2);
		a += 1;
	}

	public int getCost(){
		return cost;
	}

}