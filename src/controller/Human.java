package controller;

import java.util.ArrayList;

import model.Player;
import model.cards.interfaces.Action;
import model.cards.interfaces.Card;
import model.cards.interfaces.Treasure;
import model.cards.ChapelCard;

public class Human implements Controller{

	Player p;

	public Human(Player p){
		this.p = p;
	}

	public ArrayList<Action> actionList(){

		return null;

	}

	public ArrayList<Card> buyList(int cash){
		// always trying to buy chapel
		ArrayList<Card> a = new ArrayList<Card>();
		a.add(ChapelCard.getInstance());
		return a;

	}

	public ArrayList<Treasure> treasureList(){
		return null;

	}

	public Card gainCard(String prop, int value){

		return null;
	}



	public ArrayList<Card> trashDecision(int num){
		return null;
	}



	public void discardDownTo(int x){

	}

	@Override
	public ArrayList<Action> actionList(int numActions) {
		// TODO Auto-generated method stub
		return null;
	}
	



}
