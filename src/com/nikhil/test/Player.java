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
		x += dx * delta;
		y += dy * delta;
	}

	@Override
	public void render(Graphics g) {
		// Player Box
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}

}
