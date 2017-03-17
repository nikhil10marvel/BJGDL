package com.nikhil.test;

import java.awt.Color;
import java.awt.Graphics;

import com.nikhil.entities.Entity;

public class Enemy extends Entity {

	public Enemy(float x, float y, String ident, float speed) {
		super(x, y, ident);
		width = 16;
		height = 16;
		dx = speed;
		dy = speed;
	}

	@Override
	public void tick(float delta) {
		//Enemy Ticks
		x += dx * delta;
		y += dy * delta;
		
		if(x <= 0 || x >= Main.game.getWidth() - 16) dx *= -1;
		if(y <= 0 || y >= Main.game.getHeight() - 16) dy *= -1;
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}

}