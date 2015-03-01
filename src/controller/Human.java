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
		return null;

	}

	public ArrayList<Card> buyList(int cash){
		ArrayList<Card> a = new ArrayList<Card>();
		a.add(new ChapelCard());
		return a;

	}

	public ArrayList<Treasure> treasure(){
		return null;

	}

	public Card gain(String prop, int value){

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

}
