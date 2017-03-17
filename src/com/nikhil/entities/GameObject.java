package com.nikhil.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	//Positional co-ordinates of GameObject
	protected float x;
	protected float y;
	protected float width, height;
	Rectangle hitbox;
    public String ident;

	public GameObject(float x, float y, String ident) {
		this.x = x;
		this.y = y;
		this.ident = ident;
	}
	
	public abstract void tick(float delta);
	public abstract void render(Graphics g);

	public float getX() {
		return x;
	}

	public void genHitbox(){
		if(width == 0 || height == 0) throw new RuntimeException("Width and Height of Object must be set before generating bounds");
		else hitbox = new Rectangle((int)x, (int)y, (int)width, (int)height); 
	}

	public void setX(float x) {
		this.x = x;
	}


	public float getY() {
		return y;
	}


	public void setY(float y) {
		this.y = y;
	}


	public float getWidth() {
		return width;
	}


	public void setWidth(float width) {
		this.width = width;
	}


	public float getHeight() {
		return height;
	}


	public void setHeight(float height) {
		this.height = height;
	}
	
	public boolean intersects(GameObject other){
		boolean inter = hitbox.intersects(other.getX(), other.getY(), other.getWidth(), other.getHeight());
		return inter;
	}

}
