package model.cards;



import model.GameState;
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

	public void takeAction(GameState g, int a, int b, int c) {
		Controller currController = g.getCurrentController();
		for(Controller cont : g.getControllers()){
			if(!cont.equals(currController)){
				cont.discardDownTo(3);
			}
		}
		c += 2;
	}

	public int getCost(){
		return cost;
	}
	
	public int plusActions(){
		return 0;
	}

}
