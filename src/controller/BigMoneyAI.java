package controller;

import java.util.ArrayList;

import model.OpponentScope;
import model.PlayerScope;
import model.SupplyScope;
import model.Turn;
import model.TurnScope;
import model.cards.GoldCard;
import model.cards.ProvinceCard;
import model.cards.SilverCard;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;
import model.cards.interfaces.Victory;

public class BigMoneyAI implements Agent {

	PlayerScope p;
	OpponentScope o;
	SupplyScope sup;
	TurnScope turn;

	public BigMoneyAI(PlayerScope p, OpponentScope o, SupplyScope sup, TurnScope turnScope){
		this.p = p;
		this.o = o;
		this.sup = sup;
		this.turn = turnScope;
	}

	public ArrayList<Action> actionList() {
		return null;
	}
	public ArrayList<Card> buyList() {
		return this.buyList(turn.getNumBuys(), turn.getCash());
	}
	public ArrayList<Card> buyList(int numBuys, int cash) {
		ArrayList<Card> buyList = new ArrayList<Card>();

		if(cash >= 8 && sup.has(ProvinceCard.getInstance())){
			buyList.add(ProvinceCard.getInstance());
		}else if(cash >= 6 && sup.has(GoldCard.getInstance())){
			buyList.add(GoldCard.getInstance());
		}else if(cash >= 3 && sup.has(SilverCard.getInstance())){
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
	public ArrayList<Card> trashDecisionLE(int num) {
		// TODO Auto-generated method stub
		return null;
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
