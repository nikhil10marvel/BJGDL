package com.nikhil.test2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.nikhil.core.DrawUtils;
import com.nikhil.core.Handler;
import com.nikhil.core.Vector2f;
import com.nikhil.entities.CompoundCollider;
import com.nikhil.entities.Entity;

public class Player extends Entity {

	private Handler handler;
	boolean jumping = false;
	boolean falling = false;
	private CompoundCollider cc;

	public Player(float x, float y, Handler handler) {
		super(x, y, "Player");
		this.handler = handler;
		width = 32;
		height = 64;
	}

	public Player(Vector2f position, Handler handler) {
		super(position, "Player");
		this.handler = handler;
		setSize(new Vector2f(32, 64));
		cc = new CompoundCollider(this, handler);
	}

	@Override
	public void tick(float delta) {
//		Vector2f campos = getPosition();
//		campos.sub(new Vector2f(width+32, height*2));
//		handler.setCam(campos);
		x += dx * delta;
		y += dy * delta;
		
		cc.pin(this);
		cc.regularCollision(this, "block");
		
		if(!jumping || falling) dy = 5;
		else if (jumping && !falling) { dy = -5;}
	}

	@Override
	public void render(Graphics g) {
		DrawUtils.grph = g;
		DrawUtils.drawColor = Color.BLUE;
		DrawUtils.rect(getPosition(), getSize(), true);
		DrawUtils.drawColor = Color.YELLOW;
		DrawUtils.rect(left(), false);
		DrawUtils.rect(right(), false);
	}
	
	private Rectangle left(){
		return new Rectangle((int)x, (int)y+5, (int)(width/8), (int)(height-8));
	}
	
	private Rectangle right(){
		return new Rectangle((int)(x+(width/4)+(width/1.5)), (int)y+5, (int)(width/8), (int)(height-8));
	}

}
