package com.nikhil.particle;

import java.awt.Graphics;
import java.awt.Graphics2D;

import com.nikhil.core.Handler;
import com.nikhil.core.Vector2f;
import com.nikhil.entities.Entity;

public abstract class Projectile extends Entity{
	
	protected float angle;
	protected Handler handler;
	
	public Projectile(Vector2f position, String ident, float angle, Handler handler) {
		super(position, ident);
		this.angle = angle;
		this.handler = handler;
	}
	
	@Override
	public void tick(float delta){
		
		x += dx * Math.sin(angle) * delta;
		y += dy * Math.cos(angle) * delta;
		
		projectile_tick();
		
	}
	
	public abstract void projectile_tick();
	
	@Override
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		projectile_render(g2d);
	}
	
	public void destroy(){
		handler.removeObject(this);
	}

	public abstract void projectile_render(Graphics2D G2D);

}
