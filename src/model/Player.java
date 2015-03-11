package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import model.cards.CopperCard;
import model.cards.EstateCard;
import model.cards.FeastCard;
import model.cards.GardensCard;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Duration;
import model.cards.interfaces.Treasure;
import model.cards.interfaces.Victory;


public class Player implements PlayerScope, OpponentScope{
	private String name;
	private Deck deck;
	private Discard dis;
	private ArrayList<Card> hand;
	private ArrayList<Card> inPlay;
	private int totalTurns;
	private HashMap<Card, Integer> cards;
	private ArrayList<Duration> durations;
	private ArrayList<Card> nativeVillageMat;

	protected Player(String name){
		this.name = name;
		this.deck = new Deck();
		this.hand = new ArrayList<Card>();
		this.inPlay = new ArrayList<Card>();
		this.dis = new Discard();
		this.drawHand();
		this.totalTurns = 0;
		this.cards = new HashMap<Card, Integer>();
		this.cards.put(CopperCard.getInstance(), 7);
		this.cards.put(EstateCard.getInstance(), 3);
		this.durations = new ArrayList<Duration>();
		this.nativeVillageMat = new ArrayList<Card>();
	}

	public void play(Card c){
		if(this.has(c)){
			hand.remove(c);
			inPlay.add(c);
		}
		System.out.println(this.name + "   -> " + c.getName());
	}

	public void gain(Card c){
		if(cards.containsKey(c)){
			cards.put(c, cards.get(c)+1);
		}else{
			cards.put(c, 1);
		}
		this.addToDiscard(c);
		System.out.println(this.name + " <-   " + c.getName());
	}

	public void gainOnTop(Card c){
		if(cards.containsKey(c)){
			cards.put(c, cards.get(c)+1);
		}else{
			cards.put(c, 1);
		}
		this.putOnTopOfDeck(c);
		System.out.println(this.name + " <-   " + c.getName());
	}

	public void gainIntoHand(Card c){
		if(cards.containsKey(c)){
			cards.put(c, cards.get(c)+1);
		}else{
			cards.put(c, 1);
		}
		this.addToHand(c);
		System.out.println(this.name + " <-   " + c.getName());
	}

	protected void trashFromHand(Card toTrash){
		cards.put(toTrash, cards.get(toTrash)-1);
		this.removeFromHand(toTrash);
		System.out.println(this.name + "   XX " + toTrash.getName());
	}

	protected void trashFromHand(ArrayList<Card> toTrash){
		for(Card c : toTrash){
			cards.put(c, cards.get(c)-1);
			System.out.println(this.name + "   XX " + c.getName());
		}
		this.removeFromHand(toTrash);
	}

	protected void trashFromPlay(Card c){
		cards.put(c, cards.get(c)-1);
		this.removeFromPlay(FeastCard.getInstance());
		System.out.println(this.name + "   XX " + c.getName());

	}

	public void addTurn(){
		this.totalTurns++;
	}

	public ArrayList<Card> getDiscardList(){
		return dis.get();
	}

	public int getTotalTurns(){
		return this.totalTurns;
	}

	public void shuffle(){
		deck.addDiscardPile(dis);
	}

	public void discardHand(){
		for(int i = 0; i < hand.size(); i++){
			dis.add(hand.get(i));
		}
		hand.clear();
	}

	public void discardCardsInPlay(){
		for(Card c : inPlay){
			dis.add(c);
		}
		inPlay.clear();
	}

	public void drawHand(){
		for(int i = 0; i < 5; i++){
			this.draw();
		}
	}

	public void draw(){
		if(deck.size() == 0){
			deck.addDiscardPile(dis);
			dis.clear();
		}
		Card c = deck.draw();
		if(c != null){
			hand.add(c);
		}
	}

	public void draw(int x){
		for(int i = 0; i < x; i++){
			this.draw();
		}
	}

	public boolean hasAction(){
		for(Card c : hand){
			if(c instanceof Action){
				return true;
			}
		}
		return false;
	}

	public void addToDiscard(Card c){
		dis.add(c);
	}

	public void addToDiscard(Collection<? extends Card> c){
		dis.addAll(c);
	}

	public boolean hasTreasure(){
		for(Card c : hand){
			if(c instanceof Treasure){
				return true;
			}
		}
		return false;
	}

	public void cleanUp() {
		this.discardHand();
		this.discardCardsInPlay();
		this.drawHand();
	}

	public void discard(Card c){
		if(this.has(c)){
			hand.remove(c);
			dis.add(c);
		}else{
			throw new IllegalArgumentException("problems");
		}
	}

	public Treasure getNextTreasure(){
		ArrayList<Card> toDiscard = new ArrayList<Card>();
		Card c;
		while(deck.size() > 0 || dis.size() > 0){
			c = deck.draw();
			if(deck.size() == 0 && dis.size() > 0){
				deck.addDiscardPile(dis);
				dis.clear();
			}
			if(c instanceof Treasure){
				dis.addAll(toDiscard);
				return (Treasure) c;
			}else{
				toDiscard.add(c);
			}
		}
		dis.addAll(toDiscard);
		return null;
	}

	public Card getNextTreasureOrAction(){
		ArrayList<Card> toDiscard = new ArrayList<Card>();
		Card c;
		while(deck.size() > 0 || dis.size() > 0){
			c = deck.draw();
			if(deck.size() == 0 && dis.size() > 0){
				deck.addDiscardPile(dis);
				dis.clear();
			}
			if(c instanceof Treasure || c instanceof Action){
				dis.addAll(toDiscard);
				return c;
			}else{
				toDiscard.add(c);
			}
		}
		dis.addAll(toDiscard);
		return null;
	}

	public void addToHand(Card c){
		hand.add(c);
	}

	public void putOnTopOfDeck(Card c){
		deck.addCard(0, c);
	}

	public void addToDeck(int i, Card c){
		deck.addCard(i, c);
	}

	public void discardDeck(){
		Card c;
		while(deck.size() > 0){
			c = deck.draw();
			dis.add(c);
		}
	}

	public void removeFromPlay(Card c){
		if(inPlay.contains(c)){
			inPlay.remove(c);
		}
	}

	public boolean has(Card c){
		for(Card h : hand){
			if(h.equals(c)){
				return true;
			}
		}
		return false;
	}

	public void removeFromHand(Card c){
		if(this.has(c)){
			this.hand.remove(c);
		}else{
			throw new IllegalArgumentException();
		}
	}

	public void removeFromHand(ArrayList<Card> toRemove){
		for(Card c : toRemove){
			this.removeFromHand(c);
		}
	}

	public int handSize(){
		return hand.size();
	}

	public int deckSize(){
		return deck.size();
	}

	public int discardSize(){
		return dis.size();
	}

	public Card viewTop(){
		return deck.lookAtCard(0);
	}

	public ArrayList<Card> viewTop(int x){
		ArrayList<Card> ret = new ArrayList<Card>();
		for(int i = 0; i < x; i++){
			ret.add(deck.lookAtCard(i));
		}
		return ret;
	}

	public Card removeTop(){
		if(deck.size() == 0){
			deck.addDiscardPile(dis);
			dis.clear();
		}
		return deck.remove(0);
	}

	public void clearDurations(){
		this.durations = new ArrayList<Duration>();
	}

	public void clearNVM(){
		this.nativeVillageMat = new ArrayList<Card>();
	}

	public void addToNVM(Card c){
		this.nativeVillageMat.add(c);
	}

	// below are some of the scope methods

	public ArrayList<Duration> getDurations(){
		ArrayList<Duration> ret = new ArrayList<Duration>();
		for(Duration d : this.durations){
			ret.add(d);
		}
		return ret;
	}

	public String getName(){
		return this.name;
	}

	public HashMap<Card, Integer> getDeckContents(){
		HashMap<Card, Integer> ret = new HashMap<Card, Integer>();
		for(Card c: this.cards.keySet()){
			ret.put(c, this.cards.get(c));
		}
		return ret;
	}

	public int getScore(){
		int retVal = 0;
		for(Card c : this.cards.keySet()){
			if(c instanceof Victory){
				Victory v = (Victory) c;
				if(v instanceof GardensCard){
					retVal += this.cards.get(c) 
							* (int) Math.floor(this.totalCards()/10);
				}else{
					retVal += v.getVP()*this.cards.get(c);
				}
			}
		}
		return retVal;
	}

	public ArrayList<Card> viewHand(){
		ArrayList<Card> handCopy = new ArrayList<Card>();
		for(Card c : hand){
			handCopy.add(c);
		}
		return handCopy;
	}

	public int valueOfDeck() {
		int retVal = 0;
		for(Card c : this.cards.keySet()){
			if(c instanceof Treasure){
				Treasure t = (Treasure) c;
				retVal += t.getValue()*this.cards.get(c);
			}
		}
		return retVal;
	}

	public int valueOfCard() {
		return (int) Math.floor(this.valueOfDeck() / this.totalCards());
	}

	public int totalCards(){
		int total = 0;
		for(int i : this.cards.values()){
			total += i;
		}
		return total;
	}

	public ArrayList<Card> getNVM(){
		ArrayList<Card> NVMCopy = new ArrayList<Card>();
		for(Card c : this.nativeVillageMat){
			NVMCopy.add(c);
		}
		return NVMCopy;
	}

	public boolean hasInPlay(Card c){
		return this.inPlay.contains(c);
	}

	public int numActionsInPlay(){
		int num = 0;
		for(Card c : inPlay){
			if(c instanceof Action){
				num++;
			}
		}
		return num;
	}

	public int numOf(Card c){
		return cards.get(c);
	}
}
