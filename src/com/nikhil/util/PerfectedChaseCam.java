package com.nikhil.util;

import java.awt.Graphics;

import com.nikhil.core.Handler;
import com.nikhil.core.Vector2f;
import com.nikhil.entities.Entity;

public class PerfectedChaseCam extends Entity{
	
	final Entity entity;
	final float speed;
	public Handler handler;
	public Vector2f mult = new Vector2f(1, 1);
	Vector2f offset;
	
	public PerfectedChaseCam(Vector2f position, String ident, Entity follow, float speed, Handler handler) {
		super(position, ident);
		this.entity = follow;
		this.speed = speed;
		this.handler = handler;
		offset = getPosition();
		offset.sub(entity.getPosition());
	}

	@Override
	public void tick(float delta) {
		
		x += (entity.getX() - x) * speed * delta;
		y += (entity.getY() - y) * speed * delta;
		
		handler.setCam(getPosition());
	}

	@Override
	public void render(Graphics g) {
	}
	
	

}
