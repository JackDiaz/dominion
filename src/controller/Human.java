package controller;

import java.util.ArrayList;

import model.Action;
import model.Card;
import model.Player;
import model.Treasure;
import model.cards.ChapelCard;

public class Human implements Controller{

	Player p;

	public Human(Player p){
		this.p = p;
	}

	public ArrayList<Action> actionList(){

		System.out.println(p.hand.toString());
		System.out.println("What would you like to play?");
		
		return null;

	}

	public ArrayList<Card> buyList(int cash){
		// always trying to buy chapel
		ArrayList<Card> a = new ArrayList<Card>();
		a.add(new ChapelCard());
		return a;

	}

	public ArrayList<Treasure> treasureList(){
		return null;

	}

	public Card gainCard(String prop, int value){

		return null;
	}

	public boolean hasActionCard() {
		return p.hasActionCard();
	}

	public void discardHand() {
		p.discardHand();
	}

	public void discardCardsInPlay() {
		p.discardCardsInPlay();
	}

	public void drawHand() {
		p.drawHand();
	}
	public void cleanUp() {
		p.discardHand();
		p.discardCardsInPlay();
		p.drawHand();
	}

	public boolean has(Card c) {
		return p.has(c);
	}

	public void play(Card c) {
		p.play(c);
	}

	public void addToDiscard(Card c){
		p.addToDiscard(c);
	}
	
	public boolean hasTreasureCard(){
		return p.hasTreasureCard();
	}
	
	public ArrayList<Card> trashDecision(int num){
		return null;
	}
	
	public void removeCardsFromHand(ArrayList<Card> toRemove){
		p.removeCardsFromHand(toRemove);
	}
	
	public void draw(){
		p.draw();
	}
	
	public void draw(int x){
		p.draw(x);
	}
	
	public void discardDownTo(int x){
		
	}
}
