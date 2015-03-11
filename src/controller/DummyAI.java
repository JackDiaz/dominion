package controller;

import java.util.ArrayList;

import model.OpponentScope;
import model.PlayerScope;
import model.SupplyScope;
import model.Turn;
import model.TurnScope;
import model.cards.ChapelCard;
import model.cards.CopperCard;
import model.cards.DuchyCard;
import model.cards.EstateCard;
import model.cards.FestivalCard;
import model.cards.GoldCard;
import model.cards.LaboratoryCard;
import model.cards.MarketCard;
import model.cards.ProvinceCard;
import model.cards.SilverCard;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;
import model.cards.interfaces.Victory;

public class DummyAI implements Agent{

	PlayerScope p;
	OpponentScope o;
	SupplyScope sup;
	boolean hasChapel;
	TurnScope turn;

	public DummyAI(PlayerScope p, OpponentScope o, SupplyScope sup, TurnScope turnScope){
		this.p = p;
		this.o = o;
		this.sup = sup;
		this.hasChapel = false;
		this.turn = turnScope;
	}

	public ArrayList<Action> actionList() {
		int numActions = turn.getNumActions();
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
		if(actionList.isEmpty()){
			for(Card c : hand){
				if(c instanceof Action){
					Action a = (Action) c;
					if(totalActions > 0){
						actionList.add(a);
						totalActions--;
					}
				}
			}
		}
		return actionList;
	}

	public ArrayList<Card> buyList() {
		return this.buyList(turn.getNumBuys(), turn.getCash());
	}
	
	public ArrayList<Card> buyList(int numBuys, int cash) {
		ArrayList<Card> buyList = new ArrayList<Card>();

		if(cash >= 16
				&& numBuys >= 2
				&& this.sup.numLeft(ProvinceCard.getInstance()) >= 2){
			buyList.add(ProvinceCard.getInstance());
			buyList.add(ProvinceCard.getInstance());
			System.out.println("===============================================");
		}else if(cash >= 10
				&& numBuys >= 2
				&& this.sup.numLeft(DuchyCard.getInstance()) >= 2){
			buyList.add(DuchyCard.getInstance());
			buyList.add(DuchyCard.getInstance());
			// penultimate province rule
			// if you have $5
		}else if(cash >= 5 && cash < 8
				// and there's one province left
				&& this.sup.numLeft(ProvinceCard.getInstance()) == 1
				// and you are losing
				&& (this.imLosing() || this.tieBlock())
				// and there are duchies left
				&& this.sup.has(DuchyCard.getInstance())){

			// you better buy a duchy
			buyList.add(DuchyCard.getInstance());

		}else if(cash >= 8
				&& sup.has(ProvinceCard.getInstance())){

			if(sup.numLeft(ProvinceCard.getInstance()) == 1
					&& ((p.getScore()+6 < o.getScore()) 
							|| (p.getScore()+6 == o.getScore() 
							&& p.getTotalTurns() >= o.getTotalTurns()))){
				if(sup.has(DuchyCard.getInstance())){
					buyList.add(DuchyCard.getInstance());
				}else if(sup.has(EstateCard.getInstance())){
					buyList.add(EstateCard.getInstance());
				}
			}else{
				buyList.add(ProvinceCard.getInstance());
			}
		}else if(!hasChapel && cash >=2){
			buyList.add(ChapelCard.getInstance());
			this.hasChapel = true;
		}else if(cash >= 6
				&& sup.has(GoldCard.getInstance())){
			buyList.add(GoldCard.getInstance());
		}else if(cash >= 5){
			if(Math.random() < 0.33
					&& sup.has(LaboratoryCard.getInstance())){
				buyList.add(LaboratoryCard.getInstance());
			}else if(Math.random() < 0.66
					&& sup.has(FestivalCard.getInstance())){
				buyList.add(FestivalCard.getInstance());
			}else if(sup.has(MarketCard.getInstance())){
				buyList.add(MarketCard.getInstance());
			}else if(sup.has(LaboratoryCard.getInstance())){
				buyList.add(LaboratoryCard.getInstance());
			}
		}else if(cash >= 3){
			if(sup.has(SilverCard.getInstance())
					&& p.valueOfDeck() < 9){
				buyList.add(SilverCard.getInstance());
			}/*else if(sup.has(VillageCard.getInstance())){
				buyList.add(VillageCard.getInstance());
			}*/
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

	public boolean imLosing(){
		if((p.getScore() < o.getScore()) 
				|| (p.getScore() == o.getScore() 
				&& p.getTotalTurns() >= o.getTotalTurns())){
			return true;
		}
		return false;
	}

	public boolean tieBlock(){
		if((p.getScore() == o.getScore()+3)
				&& p.getTotalTurns() <= o.getTotalTurns()){
			return true;
		}
		return false;
	}


	public ArrayList<Card> trashDecisionLE(int num) {
		ArrayList<Card> ret = new ArrayList<Card>();
		for(Card c : p.viewHand()){
			if(ret.size() < num){
				if(c instanceof CopperCard
						&& p.valueOfDeck()-p.getDeckContents().get(CopperCard.getInstance()) >= 3){
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

	public boolean discardDeck() {
		return true;
	}

	public Card gainLECost(int cost) {
		return this.buyList(1, cost).get(0);
	}

	public boolean addToHand(Card card, Turn turn) {
		if(turn.getNumActions() > 0){
			return true;
		}
		return false;
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
	public Action throneRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action gainActionLECost(int cost) {
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
