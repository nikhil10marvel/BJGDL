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
		cube.setDX(1);
		cube.setDY(1);
	}

}
