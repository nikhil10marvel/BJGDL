package com.nikhil.test;

import com.nikhil.core.Game;
import com.nikhil.entities.Entity;

/**
 * @author Nikhil
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game(800, 600, "Test Game", false);
		game.getHandler().addObject(new Player(10, 10, "simple_cube"));
		Entity cube = game.getHandler().findEntity("simple_cube");
		cube.setDX(1.3663333f); //Diagonal movement is in the ration 600:800, 1: 1.333333, 1.3663333 is approx to that 
		cube.setDY(1);	//The numbers are obtaibed through trial and error
	}

}
