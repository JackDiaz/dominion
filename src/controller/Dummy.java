package controller;

import java.util.ArrayList;

import model.Player;
import model.cards.LaboratoryCard;
import model.cards.ProvinceCard;
import model.cards.SilverCard;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;

public class Dummy implements Agent{

	Player p;

	public Dummy(Player p){
		this.p = p;
	}

	public ArrayList<Action> actionList(int numActions) {
		ArrayList<Card> hand = p.viewHand();
		ArrayList<Action> actionList = new ArrayList<Action>();
		int totalActions = numActions;
		for(Card c : hand){
			if(c instanceof Action){
				Action a = (Action) c;
				int plusActions = a.plusActions();
				if(plusActions > 0){
					actionList.add(a);
					totalActions += plusActions -1;
				}
			}
		}

		hand.removeAll(actionList);

		for(Card c : hand){
			if(c instanceof Action){
				Action a = (Action) c;
				if(totalActions > 0){
					actionList.add(a);
					totalActions--;
				}
			}
		}
		return actionList;
	}

	public ArrayList<Card> buyList(int numBuys, int cash) {
		ArrayList<Card> buyList = new ArrayList<Card>();
		if(cash >= 8){
			buyList.add(ProvinceCard.getInstance());
		}else if(cash >= 5){
			buyList.add(LaboratoryCard.getInstance());
		}else if(cash >= 3){
			buyList.add(SilverCard.getInstance());
		}
		return buyList;
	}

	public ArrayList<Treasure> treasureList() {
		ArrayList<Treasure> treasureList = new ArrayList<Treasure>();
		ArrayList<Card> hand = p.viewHand();
		for(Card c : hand){
			if(c instanceof Treasure){
				Treasure t = (Treasure) c;
				treasureList.add(t);
			}
		}
		return treasureList;
	}

	@Override
	public Card gainCard(String prop, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Card> trashDecision(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void discardDownTo(int x) {
		// TODO Auto-generated method stub

	}

}
