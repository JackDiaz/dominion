package controller;

import java.util.ArrayList;

import model.OpponentScope;
import model.PlayerScope;
import model.SupplyScope;
import model.Turn;
import model.TurnScope;
import model.cards.ChapelCard;
import model.cards.CopperCard;
import model.cards.EstateCard;
import model.cards.GoldCard;
import model.cards.ProvinceCard;
import model.cards.SilverCard;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;
import model.cards.interfaces.Victory;

public class ChapelMoneyAI implements Agent {

	PlayerScope p;
	OpponentScope o;
	SupplyScope sup;
	TurnScope turn;
	boolean hasChapel;

	public ChapelMoneyAI(PlayerScope p, OpponentScope o, SupplyScope sup, TurnScope turnScope){
		this.p = p;
		this.o = o;
		this.sup = sup;
		this.turn = turnScope;
		this.hasChapel = false;
	}

	public ArrayList<Action> actionList() {
		ArrayList<Action> ret = new ArrayList<Action>();
		if(p.has(ChapelCard.getInstance())){
			ret.add(ChapelCard.getInstance());
		}
		return ret;
	}
	public ArrayList<Card> buyList() {
		return this.buyList(turn.getNumBuys(), turn.getCash());
	}
	public ArrayList<Card> buyList(int numBuys, int cash) {
		ArrayList<Card> buyList = new ArrayList<Card>();

		if(!hasChapel && cash >=2){
			buyList.add(ChapelCard.getInstance());
			this.hasChapel = true;
		}else if(cash >= 8 && sup.has(ProvinceCard.getInstance())){
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

	public ArrayList<Card> trashDecisionLE(int num) {
		ArrayList<Card> ret = new ArrayList<Card>();
		for(Card c : p.viewHand()){
			if(ret.size() < num){
				if(c instanceof CopperCard
						&& p.valueOfDeck()-p.getDeckContents().get(CopperCard.getInstance()) >= 3){
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
