package com.nikhil.test2;

import java.awt.event.KeyEvent;

import com.nikhil.core.Game;
import com.nikhil.core.InputEvent;
import com.nikhil.core.Vector2f;
import com.nikhil.util.ChaseCam;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		Game game = new Game(800, 600, "Shoot-em All", false);
		
		float xx2 = 0;
		
		for (float xx = 0; xx < game.getWidth()*2; xx+= 32) {
			game.getHandler().addObject(new Block(xx, 536, "block"));
			xx2 = xx;
		}
		
		for (float yy = 0; yy < game.getHeight(); yy+= 32) {
			game.getHandler().addObject(new Block(xx2, yy, "block"));
		}
		
		for (float xx = 0; xx < game.getWidth()*2; xx+= 32) {
			game.getHandler().addObject(new Block(xx, 0, "block"));
		}
		
		Player player = new Player(new Vector2f(50, 500), game.getHandler());
		ChaseCam player_cam = new ChaseCam(new Vector2f(30, 30), "player-follow", game.getHandler(), player);
		game.getHandler().addObject(player);
		game.getHandler().addObject(player_cam);
		game.getInput().setEvents(new InputEvent(KeyEvent.VK_W) {
			
			int timer = 200;
			
			@Override
			public void onDeactivated() {
				player.jumping = false;
				player.falling = true;
			}
			
			@Override
			public void onActivated() {
				player.jumping = true;
				player.falling = false;
				if(timer <= 0){
					timer = 200;
					onDeactivated();
				}
				System.out.println(timer);
				timer--;
			}
		}, new InputEvent(KeyEvent.VK_S) {
			
			@Override
			public void onDeactivated() {
				player.setDY(0);
			}
			
			@Override
			public void onActivated() {
				player.setDY(5);
			}
		}, new InputEvent(KeyEvent.VK_A) {
			
			@Override
			public void onDeactivated() {
				player.setDX(0);
			}
			
			@Override
			public void onActivated() {
				player.setDX(-5);
			}
		}, new InputEvent(KeyEvent.VK_D) {
			
			@Override
			public void onDeactivated() {
				player.setDX(0);
			}
			
			@Override
			public void onActivated() {
				player.setDX(5);
			}
		});
	}

}
