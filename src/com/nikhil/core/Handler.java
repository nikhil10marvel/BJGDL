package com.nikhil.core;

import java.awt.Graphics;
import java.util.LinkedList;

import com.nikhil.entities.Entity;
import com.nikhil.entities.GameObject;

public class Handler{
	
	LinkedList<GameObject> objs = new LinkedList<GameObject>();
	private float delta;
	private Graphics grph;
	private int ticks;
	
	
	public void addObject(GameObject obj){
		this.objs.add(obj);
	}
	
	public void removeObject(GameObject obj){
		this.objs.remove(obj);
	}
	
	public void removeObjectAtIndex(int index){
		this.objs.remove(index);
	}
	
	protected void render(Graphics g){
		for (GameObject tempObject : objs) {
			tempObject.render(g);
		}
	}
	
	protected void update(float delta){
		for (GameObject tempObject : objs) {
			tempObject.tick(delta);
		}
		//System.out.println("Tick [" + ticks + "]");
		ticks++;
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