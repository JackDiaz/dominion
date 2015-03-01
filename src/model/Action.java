package model;

import java.util.ArrayList;

import controller.Controller;

public interface Action extends Card{

	public void takeAction(ArrayList<Controller> cont, int a, int b, int c);
}
