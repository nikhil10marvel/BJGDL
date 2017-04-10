package com.nikhil.entities;

import java.awt.Rectangle;

import com.nikhil.core.Handler;

public class CompoundCollider {

	private float width;
	private float height;
	private float x;
	private float y;
	private Handler handler;


	public CompoundCollider(Entity entity, Handler handler) {
		this.width = entity.width;
		this.height = entity.height;
		this.x = entity.x;
		this.y = entity.y;
		this.handler = handler;
	}
	
	public void pin(Entity entity){
		x = entity.getX();
		y = entity.getY();
	}
	
	public void regularCollision(Entity entity, String obj_class){
		entity.genHitbox();
		for (GameObject tempObject : handler.findGameObjects(obj_class)) {
			if(entity.intersects(tempObject)){
				if(down().intersects(tempObject.hitbox)) {entity.y = tempObject.y - height - 2; entity.dy = 0;}
				if(up().intersects(tempObject.hitbox)) {entity.y = tempObject.y + tempObject.height + 2; entity.dy = 0;}
				if(right().intersects(tempObject.hitbox)) {entity.x = tempObject.x - tempObject.width - 2; entity.dx = 0;}
				if(left().intersects(tempObject.hitbox)) {entity.x = tempObject.x + tempObject.width + 2; entity.dx = 0;}
			}
		}
	}
	
	private Rectangle left(){
		return new Rectangle((int)x, (int)y+5, (int)(width/8), (int)(height-10));
	}
	
	private Rectangle right(){
		return new Rectangle((int)(x+(width/4)+(width/1.5)), (int)y+5, (int)(width/8), (int)(height-10));
	}
	
	private Rectangle up(){
		return new Rectangle((int)x, (int)y, (int)(width-(width/8)), (int)(height/2));
	}
	
	private Rectangle down(){
		return new Rectangle((int)x, (int)(y+(height/2)), (int)(width-(width/8)), (int)(height/2));
	}
	
	

}
