package com.nikhil.core;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import com.nikhil.entities.Entity;
import com.nikhil.entities.GameObject;
import com.nikhil.images.PositionedImage;

public class Handler{
	
	LinkedList<GameObject> objs = new LinkedList<GameObject>();
	ArrayList<PositionedImage> images = new ArrayList<PositionedImage>();
	private int ticks;
	private int megticks;
	Graphics g;
	
	
	public void addObject(GameObject obj){
		this.objs.add(obj);
	}
	
	public void removeObject(GameObject obj){
		this.objs.remove(obj);
	}
	
	public void removeObjectAtIndex(int index){
		this.objs.remove(index);
	}
	
	public Graphics getGraphics() throws RuntimeException{
		if(g == null) throw new RuntimeException("Sorry Graphics not yet initalized");
		else return g;
	}
	
	public void addImage(PositionedImage image){
		images.add(image);
	}
	
	protected void render(Graphics g){
		this.g = g;
		for (PositionedImage positionedImage : images) {
			g.drawImage(positionedImage.bufferedImage, positionedImage.x, positionedImage.y, positionedImage.observer);
		}
		for (GameObject tempObject : objs) {
			tempObject.render(g);
		}
	}
	
	protected void update(float delta){
		for (GameObject tempObject : objs) {
			tempObject.tick(delta);
		}
		ticks++;
		if(ticks >= 1000){
			megticks++;
			ticks = 0;
			System.out.println("MEGATICKS " + megticks);
		}
	}
	
	public GameObject findGameObject(String ident){
		GameObject obj = null;
		for (GameObject tempObject : objs) {
			if(tempObject.ident.equals(ident)) obj = tempObject;
		}
		if(obj.equals(null)) System.out.println("Object not found");
		return obj;
	}
	
	public Entity findEntity(String ident){
		Entity ent = null;
		for (GameObject tempObject : objs) {
			if(tempObject instanceof Entity){
				if(tempObject.ident.equals(ident)){
					ent = (Entity) tempObject;
				}
			}
		}
		return ent;
	}

}