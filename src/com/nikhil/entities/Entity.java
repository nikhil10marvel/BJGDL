package com.nikhil.entities;

import java.awt.Rectangle;

import com.nikhil.core.Vector2f;

public abstract class Entity extends GameObject {
	
	protected float dx;
	protected float dy;
	

	public Entity(float x, float y, String ident) {
		super(x, y, ident);
	}


	public Entity(Vector2f position, String ident) {
		super(position, ident);
	}


	public float getDX() {
		return dx;
	}

	public void setDX(float DX) {
		this.dx = DX;
	}

	public void genHitbox(){
		if(width == 0 || height == 0) throw new RuntimeException("Width and Height of Entity must be set before generating bounds");
		else hitbox = new Rectangle((int)x, (int)y, (int)width, (int)height); 
	}
	
	public Rectangle getHitbox() {
		hitbox.setLocation((int)x, (int)y);
		return hitbox;
	}
	
	public float getDY() {
		return dy;
	}


	public void setDY(float DY) {
		this.dy = DY;
	}
	
	public boolean intersects(Entity other){
		if(other.getHitbox() == null) {
			throw new RuntimeException("No Hit box for Entity:" + other.ident);
		} else if(hitbox == null){
			throw new RuntimeException("Hit box not detected");
		}else {
			return hitbox.intersects(other.getHitbox());
		}
	}

}
