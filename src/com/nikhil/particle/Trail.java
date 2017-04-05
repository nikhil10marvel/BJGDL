package com.nikhil.particle;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.nikhil.core.Handler;
import com.nikhil.core.Vector2f;
import com.nikhil.entities.Entity;

public abstract class Trail extends Entity {

	private Color color;
	private float life;
	private Handler handler;
	float alpha = 1;

	public Trail(float x, float y, String ident, float life, Color color, Handler handler, float width, float height) {
		super(x, y, ident);
		this.handler = handler;
		this.life = life;
		this.color = color;
		this.width = width;
		this.height = height;
	}

	public Trail(Vector2f position, Vector2f size, String ident, Handler handler, Color color, float life) {
		super(position, ident);
		width = size.x;
		height = size.y;
		this.life = life;
		this.color = color;
		this.handler = handler;
	}
	
	protected AlphaComposite makeTRANSPERANT(float alpha){
		int type = AlphaComposite.SRC_OVER;
		return AlphaComposite.getInstance(type, alpha);
	}

	@Override
	public void tick(float delta) {
		if(alpha > life) alpha -= life - 0.001f;
		else handler.removeObject(this);
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTRANSPERANT(alpha));
		
		trail_render(g2d);
		
		g2d.setComposite(makeTRANSPERANT(1));
	}
	
	public abstract void trail_render(Graphics2D g2d);

}
