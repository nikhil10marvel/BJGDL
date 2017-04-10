package com.nikhil.test;

import java.awt.event.KeyEvent;

import com.nikhil.core.ClickEvent;
import com.nikhil.core.Game;
import com.nikhil.core.InputEvent;
import com.nikhil.core.Node;
import com.nikhil.core.Vector2f;
import com.nikhil.entities.Entity;
import com.nikhil.images.BufferredImageLoader;
import com.nikhil.images.PositionedImage;
import com.nikhil.util.Settings;

/**
 * @author Nikhil
 */
public class Main_OLD {

	/**
	 * @param args
	 */
	
	static Game game;
	static Entity cube;
	final static float Player_speed = 5f; // The speed of player
	//Array of Enemies
	static Enemy[] enemies = {new Enemy(50, 50, "simple_cube_enemy", 5),new Enemy(30, 23, "simple_cube_enemy", 3), new Enemy(98, 98, "simple_cube_enemy", 10)};
	private static Node node;
	
	public static void main(String[] args) {
		//Initializing the settings
		Settings settings = new Settings();
		settings.loadSettings(Main_OLD.class.getClassLoader().getResourceAsStream("Game.settings"));
		
		//Starting game
		game = new Game(settings);
		
		//Generating Hitboxes for enemies
		enemies[0].genHitbox();
		enemies[1].genHitbox();
		enemies[2].genHitbox();
		
		
		//Adding cube
		game.getHandler().addObject(new Player(10, 10, "simple_cube"));
		//BJGDL can get Entities or GameObjects with the String ident provided to a GameObject. The GameObject must be in the game, else findGameObject will return null
	    cube = game.getHandler().findEntity("simple_cube");	//The GameObject you are referring to must be an entity! In this case it is
	    cube.genHitbox();
		
		//Adding Simple Enemies
		node = new Node();
		node.addChildren(enemies);
		game.getHandler().addNode(node);
	    
	    //Image tEST
		game.getHandler().addImage(new PositionedImage(BufferredImageLoader.loadImageURL("https://lh5.ggpht.com/tq3WqEUxtRyBn-d_0t3j6WKNHuJDrmLq-FE3GAYrsAMQFIaS7FIgRLfzzql2SvfvLqto=w300"), 0, 0, null));
		
		//cube.setDX(1.3663333f); //Diagonal movement is in the ration 600:800, 1: 1.333333, 1.3663333 is approx to that 
		//cube.setDY(1);	//The numbers are obtained through trial and error
	    
	    //Setting Keyboard controls
	    setUpKeys();
	}
	
	public static void setUpKeys(){
		InputEvent playerUp = new InputEvent(KeyEvent.VK_W) {
			
			@Override
			public void onDeactivated() {
				// What should happen when key is released
				cube.setDY(0);
			}
			
			@Override
			public void onActivated() {
				// What should happen when key is pressed
				cube.setDY(-1*Player_speed);	// Reverse direction of motion
			}
		};
		
		InputEvent playerDown = new InputEvent(KeyEvent.VK_S) {
			
			@Override
			public void onDeactivated() {
				// What should happen when key is released
				cube.setDY(0);
			}
			
			@Override
			public void onActivated() {
				// What should happen when key is pressed
				cube.setDY(Player_speed);
			}
		};
		
		InputEvent playerRight = new InputEvent(KeyEvent.VK_D) {
			
			@Override
			public void onDeactivated() {
				cube.setDX(0);	//Set it back to zero
			}
			
			@Override
			public void onActivated() {
				// TODO Auto-generated method stub
				cube.setDX(Player_speed); // Set DX to Player's speed
			}
		};
		
		InputEvent playerLeft = new InputEvent(KeyEvent.VK_A) {
			
			@Override
			public void onDeactivated() { 
				cube.setDX(0); // Make every thing as usual
			}
			
			@Override
			public void onActivated() {
				cube.setDX(-1*Player_speed); // multiply by -1 to reverse direction and keep speed positive( because there is really no -500 speed)
			}
		};
		game.mouse().setEvent(new ClickEvent() {
			
			@Override
			public void onRelease(int button) {
				// Debug
				System.out.println("Release");
			}
			
			@Override
			public void onPress(int button) {
				// Debug
				System.out.println("press");
			}
			
			@Override
			public void onClick(int button) {
				// Debug
				System.out.println("Click");
				System.out.println(Vector2f.angle(cube.getPosition(), pos));
				Vector2f bullet_pos = cube.getPosition();
				Player_Bullet pb = new Player_Bullet(bullet_pos, Vector2f.angle(pos, bullet_pos), game.getHandler());
				game.getHandler().addObject(pb);
			}
		});
		game.getInput().setEvents(playerLeft, playerRight, playerUp, playerDown);	//Adding all events to inputManager.
	}
}
