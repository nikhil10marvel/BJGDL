package com.nikhil.test;

import java.awt.Color;
import java.awt.Graphics;

import com.nikhil.entities.Entity;

public class Player extends Entity {

	public Player(float x, float y, String ident) {
		super(x, y, ident);
		width = 32;
		height = 32;
	}

	@Override
	public void tick(float delta) {
		// Player Ticks
		x += dx * delta;	// 'the change in x' or velocity in x
		y += dy * delta;	// 'the change in y' or velocity in y
		
		for (int i = 0; i < Main.enemies.length; i++) {
			Entity enemy = Main.enemies[i];
			if(intersects(enemy)) System.out.println("Collided!");
		}
	}

	@Override
	public void render(Graphics g) {
		// Player Box
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}

}
