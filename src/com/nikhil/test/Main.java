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
		//In just five lines, you have a simple display, with a cube moving diagonally and a window 800x600
		Game game = new Game(800, 600, "Test Game", false); //Setting dimensions for window and title, false is to weather end the program 
		game.getHandler().addObject(new Player(10, 10, "simple_cube"));	//Player is a class that is programmed to display a cube, the number are x and y co-ordinates and that String is the unique identifier for the GameObject or Entity
		Entity cube = game.getHandler().findEntity("simple_cube"); //Gets the entity called simple_cube. Note:This is donw only to show that it can be done. You can set the player to a variable and then make changes to the entity by using methods of the variable
		cube.setDX(1.3663333f);	 //Diagonal movement is in the ration 600:800, 1: 1.333333, 1.3663333 is approx to that 
		cube.setDY(1); //The numbers are obtaibed through trial and error. Approx is taken because we are starting at x:10,y:10
	}
}
