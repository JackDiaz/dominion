package model.cards;



import model.GameState;
import model.Turn;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import controller.Controller;

public class MilitiaCard implements Card, Action{

	int cost;
	private static MilitiaCard instance;

	private MilitiaCard(){
		this.cost = 4;
	}
	
	
	public static MilitiaCard getInstance(){
		if(instance == null){
			instance = new MilitiaCard();
		}
		return instance;
	}

	public void takeAction(GameState g, Turn t) {
		Controller currController = g.getCurrentController();
		for(Controller cont : g.getControllers()){
			if(!cont.equals(currController)){
				cont.discardDownTo(3);
			}
		}
		t.addCash(2);
	}

	public int getCost(){
		return cost;
	}
	
	public int plusActions(){
		return 0;
	}

}
