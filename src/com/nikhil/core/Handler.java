package com.nikhil.core;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;

import com.nikhil.entities.Entity;
import com.nikhil.entities.GameObject;
import com.nikhil.images.PositionedImage;

public class Handler{
	
	LinkedList<GameObject> objs = new LinkedList<GameObject>();
	ArrayList<PositionedImage> images = new ArrayList<PositionedImage>();
	ArrayList<Node> nodes = new ArrayList<Node>();
	
	private int ticks;
	private int megticks;
	Graphics g;
	
	protected Vector2f cam;
	protected boolean setCam = false;
	
	
	public void addIterObject(GameObject obj){
		this.objs.listIterator().add(obj);
	}
	
	public void addObject(GameObject OBJ){
		this.objs.add(OBJ);
	}
	
	public void addNode(Node node){
		nodes.add(node);
	}
	
	public void removeIterObject(GameObject obj){
		while (objs.listIterator().hasNext()) {
			GameObject found_obj = (GameObject) objs.listIterator().next();
			if(found_obj.equals(obj)) objs.listIterator().remove();
		}
	}
	
	public void removeObject(GameObject obj){
		objs.remove(obj);
	}
	
	public Vector2f getCam(){
		return cam;
	}
	
	public void setCam(Vector2f cam){
		this.setCam = true;
		this.cam = cam;
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
		try{
			for (PositionedImage positionedImage : images) { 
				g.drawImage(positionedImage.bufferedImage, positionedImage.x, positionedImage.y, positionedImage.observer);
			}
			for (GameObject tempObject : objs) {
				tempObject.render(g);
			}
			for (Node node : nodes) {
				node.render(g);
			}
		} catch (ConcurrentModificationException ex){
			return;
		}
	}
	
	protected void update(float delta){
		try{
			for (GameObject tempObject : objs) {
				tempObject.tick(delta);
			}
			for (Node node : nodes) {
				node.tick(delta);
			}
			ticks++;
			if(ticks >= 1000){
				megticks++;
				ticks = 0;
				System.out.println("MEGATICKS " + megticks);
			}
		} catch (ConcurrentModificationException ex){
			return;
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
	
	public ArrayList<Entity> findEntities(String starts){
		ArrayList<Entity> found_entities = new ArrayList<Entity>();
		for (GameObject tempObject : objs) {
			if (tempObject instanceof Entity) {
				if(tempObject.ident.startsWith(starts)) found_entities.add((Entity) tempObject);
			}
		}
		return found_entities;
	}
	
	public ArrayList<GameObject> findGameObjects(String starts){
		ArrayList<GameObject> found_objs = new ArrayList<GameObject>();
		for (GameObject tempObject : objs) {
			if(tempObject.ident.startsWith(starts)) found_objs.add(tempObject);
		}
		//System.out.println(found_objs.toString());
		return found_objs;
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
	
	public ArrayList<GameObject> findGameObjectsInRange(float x, float y, float range){
		ArrayList<GameObject> objects_found = new ArrayList<GameObject>();
		Rectangle col = new Rectangle((int)x, (int)y, (int)range, (int)range);
		for(GameObject tempObject : objs){
			if(GameObject.rect_intersects(col, tempObject)){
				objects_found.add(tempObject);
			}
		}
		return objects_found;
	}
	
	public ArrayList<Entity> findEntitiesInRange(float x, float y, float range){
		ArrayList<Entity> objects_found = new ArrayList<Entity>();
		Rectangle col = new Rectangle((int)x, (int)y, (int)range, (int)range);
		for(GameObject tempObject : objs){
			if(tempObject instanceof Entity){
				if(GameObject.rect_intersects(col, tempObject)){
					objects_found.add((Entity)tempObject);
				}
			}
		}
		return objects_found;
	}
	
	public ArrayList<Entity> findEntityTypeInRange(float x, float y, float range, String type){
		ArrayList<Entity> entities_in_range = findEntitiesInRange(x, y, range);
		ArrayList<Entity> found = new ArrayList<Entity>();
		for (Entity entity : entities_in_range) {
			if(entity.ident.startsWith(type)){
				found.add(entity);
			}
		}
		return found;
	}
	
	public ArrayList<GameObject> findGameObjectTypeInRange(float x, float y, float range, String type){
		ArrayList<GameObject> found = new ArrayList<GameObject>(); 
		for (GameObject tempObject : findGameObjectsInRange(x, y, range)) {
			if(tempObject.ident.startsWith(type)){
				found.add(tempObject);
			}
		}
		return found;
	}

}