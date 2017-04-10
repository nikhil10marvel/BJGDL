package com.nikhil.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.nikhil.core.DrawUtils;
import com.nikhil.entities.Entity;
import com.nikhil.particle.Trail;

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
		
		for (int i = 0; i < Main_OLD.enemies.length; i++) {
			Entity enemy = Main_OLD.enemies[i];
			if(intersects(enemy)) System.out.println("Collided!");
		}
		
		//Main_OLD.game.getHandler().addObject(new Trail(x, y, "player-trail", 0.1f, Color.blue, Main_OLD.game.getHandler(), 32, 32) {
			
//			@Override
//			public void trail_render(Graphics2D g2d) {
//				g2d.drawRect((int)x, (int)y, (int)width, (int)height);
//			}
//		});
	}

	@Override
	public void render(Graphics g) {
		DrawUtils.grph = g;
		DrawUtils.drawColor = Color.BLUE;
		DrawUtils.rect(x, y, width, height, true);
	}

}
