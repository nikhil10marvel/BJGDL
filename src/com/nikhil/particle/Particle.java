package com.nikhil.particle;

import java.awt.Color;
import java.awt.Graphics;

import com.nikhil.core.DrawUtils;
import com.nikhil.core.Handler;
import com.nikhil.core.Window;
import com.nikhil.entities.Entity;

public class Particle extends Entity{

	private Handler handler;
	protected float cur_particle_life;
	protected float particle_life;
	public float size = 8;
	protected Color particle_color;
	public Color particle_life_before_color = Color.WHITE;
	public Color particle_life_after_color = Color.BLUE;

	public Particle(float x, float y, String ident, Handler handler, float life) {
		super(x, y, ident);
		this.handler = handler;
		cur_particle_life = particle_life = life;
	}

	@Override
	public void tick(float delta) {
		
		if(x >= Window.WINDOW_WIDTH) destroy();
		if(y >= Window.WINDOW_HEIGHT) destroy();
		if(x <= 0) destroy();
		if(y <= 0) destroy();
		
		x += dx * delta;
		y += dy * delta;
		
		cur_particle_life -= delta;
		
		if(cur_particle_life > (particle_life/2)){	// If particle life is greater than its halfway point then go for initial colour
			particle_color = particle_life_before_color;
		} else if (cur_particle_life <= (particle_life/2)){	// If particle life is lesser than its halfway point then go for next colour;
			particle_color = particle_life_after_color;
		}
	}

	private void destroy() {
		handler.removeObject(this);
	}
	
	@Override
	public void render(Graphics g) {
		DrawUtils.grph = g;
		DrawUtils.box(x, y, size, true);
	}

}
