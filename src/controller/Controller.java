package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.GameEngine;
import model.GameState;
import model.Player;
import model.Turn;
import model.cards.ChapelCard;
import model.cards.FestivalCard;
import model.cards.GardensCard;
import model.cards.LaboratoryCard;
import model.cards.MarketCard;
import model.cards.VillageCard;
import model.cards.WalledVillageCard;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Curse;
import model.cards.interfaces.Duration;
import model.cards.interfaces.Treasure;
import model.cards.interfaces.Victory;

public class Controller {
	GameState gs;
	GameEngine ge;
	Agent currAgent;
	//Turn turn;

	private Controller(GameState gs, GameEngine ge){
		this.gs = gs;
		this.ge = ge;
	}

	public HashMap<String, ArrayList<Agent>> start(){

		boolean gameIsOver = false;
		this.executeTurn();

		// game loop
		while(!gameIsOver){
			if(ge.gameIsOver()){
				gameIsOver = true;
			}else{

				gs.nextPlayer();

				System.out.println();
				for(Player p : gs.getPlayers()){
					System.out.println(p.getName() 
							+ " Score: " + p.getScore() 
							+ " Num Turns: " + p.getTotalTurns() + " " 
							+ p.getDeckContents());
				}
				System.out.println();

				this.executeTurn();
			}
		}

		// game's over
		ArrayList<Player> players = this.gs.getPlayers();
		int highScore = -500;
		int winTurns = Integer.MAX_VALUE;
		ArrayList<Agent> winners = new ArrayList<Agent>();
		HashMap<Player, Agent> playerAgent = gs.getPlayerAgent();
		HashMap<String, ArrayList<Agent>> ret = new HashMap<String, ArrayList<Agent>>();
		ArrayList<Agent> losers = new ArrayList<Agent>();

		System.out.println();

		for(Player p : players){
			int score = this.calculateScore(p);
			int turns = p.getTotalTurns();

			System.out.println(p.getName() 
					+ " Score: " + score 
					+ " Num Turns: " + turns + " " 
					+ p.getDeckContents());

			if(score > highScore){

				highScore = score;

				winTurns = turns;

				winners = new ArrayList<Agent>();
				winners.add(playerAgent.get(p));

			}else if(score == highScore
					&& turns == winTurns){

				winners.add(playerAgent.get(p));

			}else if(score == highScore
					&& turns <= winTurns){

				winTurns = turns;

				winners = new ArrayList<Agent>();
				winners.add(playerAgent.get(p));

			}
		}

		ret.put("winners", winners);

		for(Agent a : gs.getAgents()){
			if(!winners.contains(a)){
				losers.add(a);
			}
		}

		ret.put("losers", losers);
		return ret;
	}

	private int calculateScore(Player p){
		p.discardDeck();
		p.discardCardsInPlay();
		p.discardHand();
		ArrayList<Card> cards = p.getDiscardList();
		int gardens = 0;
		int curses = 0;
		int vp = 0;
		int totalScore = 0;

		for(Card c : cards){
			if(c instanceof Victory){
				if(c instanceof GardensCard){
					gardens++;
				}else{
					vp += ((Victory) c).getVP();
				}
			}else if(c instanceof Curse){
				curses++;
			}
		}

		totalScore += vp;
		totalScore += gardens*((int)Math.floor(cards.size()/10));
		totalScore -= curses;
		return totalScore;

	}

	public static void main(String args[]){
		ArrayList<Card> kingdomCards = new ArrayList<Card>();

		kingdomCards.add(LaboratoryCard.getInstance());
		kingdomCards.add(MarketCard.getInstance());
		kingdomCards.add(VillageCard.getInstance());
		kingdomCards.add(ChapelCard.getInstance());
		kingdomCards.add(FestivalCard.getInstance());

		Turn turn = new Turn();
		GameState gs = new GameState(kingdomCards, turn);
		GameEngine ge = new GameEngine(gs);
		Controller c = new Controller(gs, ge);
		c.start();
	}

	public void executeTurn(){
		Player currPlayer = gs.getCurrentPlayer();
		gs.getTurn().newTurn();
		ArrayList<Action> actList;
		ArrayList<Treasure> treList;
		ArrayList<Card> buyList;

		currPlayer.addTurn();

		ArrayList<Duration> durations = currPlayer.getDurations();
		if(!durations.isEmpty()){
			for(Duration d : durations){
				d.duration(gs, gs.getTurn());
			}
		}
		currPlayer.clearDurations();


		actList = this.getActList();
		while(gs.getTurn().getNumActions() > 0 
				&& actList != null
				&& !actList.isEmpty()){

			ge.actionPhase(gs.getTurn(), actList, currPlayer);
			actList = this.getActList();
		}


		treList = this.getTreList();
		while(treList != null
				&& !treList.isEmpty()){

			ge.treasurePhase(gs.getTurn(), treList, currPlayer);
			treList = this.getTreList();
		}


		buyList = this.getBuyList();
		while(gs.getTurn().getNumBuys() > 0
				&& buyList != null
				&& !buyList.isEmpty()){

			ge.buyPhase(gs.getTurn(), buyList, currPlayer);
			buyList = this.getBuyList();
		}

		// clean up and draw phase
		if(currPlayer.hasInPlay(WalledVillageCard.getInstance()) 
				&& currPlayer.numActionsInPlay() <= 2){
			if(Controller.walledVillage(gs.getCurrentAgent())){
				currPlayer.removeFromPlay(WalledVillageCard.getInstance());
				currPlayer.putOnTopOfDeck(WalledVillageCard.getInstance());
			}
		}
		currPlayer.cleanUp();
	}

	private ArrayList<Action> getActList(){
		// when playing with humans this would get the info from the view
		// but right now we're only worried about AI

		currAgent = gs.getCurrentAgent();
		return currAgent.actionList();
	}

	private ArrayList<Treasure> getTreList(){
		// when playing with humans this would get the info from the view
		// but right now we're only worried about AI

		currAgent = gs.getCurrentAgent();
		return currAgent.treasureList();
	}

	private ArrayList<Card> getBuyList(){
		// when playing with humans this would get the info from the view
		// but right now we're only worried about AI

		currAgent = gs.getCurrentAgent();
		return currAgent.buyList(gs.getTurn().getNumBuys(), gs.getTurn().getCash());
	}


	// === S T A T I C   M E T H O D S ===

	// used by cards

	public static ArrayList<Card> trashDecisionLE(Agent a, int num){
		return a.trashDecisionLE(num);
	}

	public static ArrayList<Card> trashDecisionE(Agent a, int num){
		return a.trashDecisionE(num);
	}

	public static ArrayList<Card> discardDownTo(Agent a, int num){
		return a.discardDownTo(num);
	}

	public static Victory victoryCardOnTop(Agent a){

		return a.victoryCardOnTop();

	}

	public static ArrayList<Card> discardToDraw(Agent a){
		return a.discardToDraw();
	}
	
	public static Card discardForAction(Agent a){
		return a.discardForAction();
	}
	
	public static Card discardForBuy(Agent a){
		return a.discardForBuy();
	}

	public static boolean discardDeck(Agent a){
		return a.discardDeck();
	}

	public static Card gainLECost(Agent a, int cost){
		return a.gainLECost(cost);
	}


	public static boolean addToHand(Agent a, Card card, Turn turn) {
		return a.addToHand(card, turn);
	}

	public static Treasure trashTreasureFromHand(Agent a){
		return a.trashTreasureFromHand();
	}

	public static Treasure gainTreasureLECost(Agent a, int cost){
		return a.gainTreasureLECost(cost);
	}
	
	public static Action gainActionLECost(Agent a, int cost){
		return a.gainActionLECost(cost);
	}

	public static Action throneRoom(Agent a){
		return a.throneRoom();
	}
	
	public static boolean trashMiningVillage(Agent a){
		return a.trashMiningVillage();
	}
	
	public static boolean nativeVillage(Agent a){
		return a.nativeVillage();
	}
	
	public static boolean walledVillage(Agent a){
		return a.walledVillage();
	}

}
