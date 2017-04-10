package com.nikhil.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.nikhil.core.Vector2f;

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
	
	public GameObject(Vector2f position, String ident){
		this.x = position.x;
		this.y = position.y;
		this.ident = ident;
	}
	
	public abstract void tick(float delta);
	public abstract void render(Graphics g);

	public float getX() {
		return x;
	}
	
	public Vector2f getPosition(){
		return new Vector2f(x, y);
	}
	
	public void setPosition(Vector2f position){
		x = position.x;
		y = position.y;
	}
	
	public Vector2f getSize(){
		return new Vector2f(width, height);
	}
	
	public void setSize(Vector2f size){
		width = size.x;
		height = size.y;
		genHitbox();
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
	
	public static boolean rect_intersects(Rectangle rectangle, GameObject object){
		return rectangle.intersects(object.x, object.y, object.width, object.height);
	}

}
