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

public class MilitiaCard implements Card, Action{

	int cost;

	public MilitiaCard(){
		this.cost = 4;
	}

	public void takeAction(GameState g, int a, int b, int c) {
		Controller currentPlayer = g.getCurrentPlayer();
		for(Controller cont : g.getControllers()){
			if(!cont.equals(currentPlayer)){
				cont.discardDownTo(3);
				// =(
				// not quite sure what to do with that
				// cats cats cats
				// Children: always remember to program sober
			}
		}
		c += 2;
	}

	public int getCost(){
		return cost;
	}

}
