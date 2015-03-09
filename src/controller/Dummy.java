package controller;

import java.util.ArrayList;

import model.Player;
import model.Supply;
import model.Turn;
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
import model.cards.VillageCard;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;
import model.cards.interfaces.Victory;

public class Dummy implements Agent{

	Player p;
	Player o;
	Supply sup;
	boolean hasChapel;

	public Dummy(Player p, Player o, Supply sup){
		this.p = p;
		this.o = o;
		this.sup = sup;
		this.hasChapel = false;
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
					&& ((p.currentScore+6 < o.currentScore) 
							|| (p.currentScore+6 == o.currentScore 
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
			if(p.cards.containsKey(SilverCard.getInstance())
					&& p.cards.get(SilverCard.getInstance()) >= 3){
				buyList.add(VillageCard.getInstance());
			}else if(sup.has(SilverCard.getInstance())){
				buyList.add(SilverCard.getInstance());
			}else if(sup.has(VillageCard.getInstance())){
				buyList.add(VillageCard.getInstance());
			}
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
		if((p.currentScore < o.currentScore) 
				|| (p.currentScore == o.currentScore 
				&& p.getTotalTurns() >= o.getTotalTurns())){
			return true;
		}
		return false;
	}

	public boolean tieBlock(){
		if((p.currentScore == o.currentScore+3)
				&& p.getTotalTurns() <= o.getTotalTurns()){
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Card> trashDecisionLE(int num) {
		ArrayList<Card> ret = new ArrayList<Card>();
		for(Card c : p.viewHand()){
			if(ret.size() < num){
				if(c instanceof CopperCard
						&& ((p.cards.containsKey(SilverCard.getInstance())
								&& p.cards.get(SilverCard.getInstance()) >= 2)
								|| (p.cards.containsKey(GoldCard.getInstance())
										&& p.cards.get(GoldCard.getInstance()) >= 1))){
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

}
