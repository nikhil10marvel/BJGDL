package com.nikhil.test;

import java.awt.Color;
import java.awt.Graphics2D;

import com.nikhil.core.DrawUtils;
import com.nikhil.core.Handler;
import com.nikhil.core.Vector2f;
import com.nikhil.particle.Projectile;

public class Player_Bullet extends Projectile {

	public Player_Bullet(Vector2f position, float angle, Handler handler) {
		super(position, "player-bullet", angle, handler);
		dx = 5;
		dy = 5;
	}

	@Override
	public void projectile_tick() {
	}

	@Override
	public void projectile_render(Graphics2D G2D) {
		DrawUtils.drawColor = Color.ORANGE;
		DrawUtils.grph = G2D;
		DrawUtils.box(x, y, 8, true);
	}

}
