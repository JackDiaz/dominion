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

public class SmithyCard implements Card, Action{

	int cost;

	public SmithyCard(){
		this.cost = 4;
	}

	public void takeAction(GameState g, int a, int b, int c) {
		Controller currentPlayer = g.getCurrentPlayer();
		currentPlayer.draw(3);
	}

	public int getCost(){
		return cost;
	}
}