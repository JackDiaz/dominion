package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.OpponentScope;
import model.PlayerScope;
import model.SupplyScope;
import model.Turn;
import model.TurnScope;
import model.cards.CopperCard;
import model.cards.EstateCard;
import model.cards.SilverCard;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;
import model.cards.interfaces.Victory;

public class GeneticAI implements Agent{

	ArrayList<Card> buyList;
	HashMap<Card, Integer> buyAmounts;
	ArrayList<Action> actionList;
	PlayerScope p;
	OpponentScope o;
	SupplyScope sup;
	TurnScope turn;


	public GeneticAI(PlayerScope p, OpponentScope o, SupplyScope sup, 
			TurnScope turnScope, ArrayList<Card> buyList, 
			HashMap<Card, Integer> buyAmounts, ArrayList<Action> actionList){
		this.p = p;
		this.o = o;
		this.sup = sup;
		this.turn = turnScope;
		this.actionList = actionList;
		this.buyList = buyList;
		this.buyAmounts = buyAmounts;
	}

	public ArrayList<Action> actionList() {
		ArrayList<Action> ret = new ArrayList<Action>();

		for(Action c : actionList){
			if(p.has(c)){
				ret.add(c);
				return ret;
			}
		}
		return ret;
	}

	public ArrayList<Card> buyList() {
		ArrayList<Card> ret = new ArrayList<Card>();

		for(Card c : this.buyList){
			if(sup.has(c) && buyAmounts.get(c) > 0
					&& turn.getCostAfterModifiers(c) <= turn.getCash()){
				buyAmounts.put(c, buyAmounts.get(c)-1);
				ret.add(c);
				return ret;
			}
		}

		return ret;
	}

	public ArrayList<Card> buyList(int numBuys, int cash) {
		ArrayList<Card> ret = new ArrayList<Card>();

		for(Card c : this.buyList){
			if(sup.has(c) && buyAmounts.get(c) > 0
					&& turn.getCostAfterModifiers(c) <= cash){
				buyAmounts.put(c, buyAmounts.get(c)-1);
				ret.add(c);
				return ret;
			}
		}

		return ret;
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

	public ArrayList<Card> trashDecisionLE(int num) {
		ArrayList<Card> ret = new ArrayList<Card>();
		for(Card c : p.viewHand()){
			if(ret.size() < num){
				if(c instanceof CopperCard
						&& p.valueOfDeck()-p.getDeckContents().get(CopperCard.getInstance()) > 3){
					ret.add(c);
				}else if(c instanceof SilverCard
						&& p.valueOfDeck()
						-p.numOf(CopperCard.getInstance())
						-(2*p.numOf(SilverCard.getInstance())) 
						>= 9){
					ret.add(c);
				}else if(c instanceof EstateCard){
					ret.add(c);
				}
			}
		}
		return ret;
	}
	@Override
	public ArrayList<Card> trashDecisionE(int num) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Card> discardDownTo(int x) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Victory victoryCardOnTop() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Card> discardToDraw() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Card discardForAction() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Card discardForBuy() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Card> discardForCash() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean discardDeck() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Card gainLECost(int cost) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean addToHand(Card card, Turn turn) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Treasure trashTreasureFromHand() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Treasure gainTreasureLECost(int cost) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Action gainActionLECost(int cost) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Action throneRoom() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean trashMiningVillage() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean nativeVillage() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean walledVillage() {
		// TODO Auto-generated method stub
		return false;
	}



}
