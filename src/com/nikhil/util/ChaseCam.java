package com.nikhil.util;

import java.awt.Graphics;

import com.nikhil.core.Handler;
import com.nikhil.core.Vector2f;
import com.nikhil.entities.Entity;
import com.nikhil.entities.GameObject;

public class ChaseCam extends Entity {
	
	private Handler handler;
	private GameObject object;
	private Vector2f offset;

	public ChaseCam(float x, float y, String ident, Handler handler, GameObject gameObject) {
		super(x, y, ident);
		this.handler = handler;
		this.object = gameObject;
		calculateOffset();
	}
	
	private void calculateOffset(){
		offset = getPosition();
		offset.sub(object.getPosition());
	}

	public ChaseCam(Vector2f position, String ident, Handler handler, GameObject gameObject) {
		super(position, ident);
		this.handler = handler;
		this.object = gameObject;
		calculateOffset();
	}

	@Override
	public void tick(float delta) {
		Vector2f vector2f = object.getPosition();
		vector2f.add(offset);
		vector2f.mult(new Vector2f(-1, -1));
		//vector2f.sub(new Vector2f(-16, 0));
		setPosition(vector2f);
		handler.setCam(vector2f);
	}

	@Override
	public void render(Graphics g) {
		// Camera is not rendered
	}

}
