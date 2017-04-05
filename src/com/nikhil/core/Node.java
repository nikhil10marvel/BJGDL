package com.nikhil.core;

import java.awt.Graphics;
import java.util.LinkedList;

import com.nikhil.entities.GameObject;

public class Node{
	
	float x;
    float y;
	float oldx;
	float oldy;
	
	LinkedList<GameObject> children = new LinkedList<GameObject>();
	
	public boolean render = true;
	public boolean tick = true;
	
	public float getX() {
		return x;
	}
	
	public void setLocation(float x, float y) {
		oldx = x;
		oldy = y;
		this.x = x;
		this.y = y;
		for (GameObject tempObject : children) {
			tempObject.setX(tempObject.getX()+(x - oldx));
			tempObject.setY(tempObject.getY()+(y - oldy));
		}
	}
	
	public void render(Graphics g){
		if(render) {
			for (GameObject tempObject : children) {
				tempObject.render(g);
			}
		} else return;
	}
	
	public void tick(float delta){
		if(tick){
			for (GameObject tempObject : children) {
				tempObject.tick(delta);
			}
		} else return;
	}
	
	public void addChildren(GameObject... gameObjects){
		for (int i = 0; i < gameObjects.length; i++) {
			children.add(gameObjects[i]);
		}
	}
	
	public float getY() {
		return y;
	}
    
	public float[] getLocation(){
		return new float[]{x,y};
	}
	
}
