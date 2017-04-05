package com.nikhil.particle;

import java.awt.Graphics;
import java.util.Random;

import com.nikhil.core.Handler;
import com.nikhil.core.Vector2f;
import com.nikhil.entities.Entity;

public class ParticleEmitter extends Entity{
	
	protected final Particle particle;
	private Handler handler;
	private Random random = new Random();
	public float spawnrate = 5000;
	private float time = 0;
	private float maxx;
	private float minx;
	private float maxy;
	private float miny;
	
	public ParticleEmitter(float x, float y, float maxx, float maxy, float minx, float miny, String ident,Particle particle, Handler handler){
		super(x, y, ident);
		this.particle = particle;
		this.handler = handler;
		this.maxx = maxx;
		this.minx = minx;
		this.maxy = maxy;
		this.miny = miny;
	}
	
	public ParticleEmitter(Vector2f position, Vector2f max, Vector2f min,String ident, Particle particle, Handler handler){
		super(position, ident);
		this.particle = particle;
		this.handler = handler;
		this.maxx = max.x;
		this.minx = min.x;
		this.maxy = max.y;
		this.miny = min.y;
	}

	@Override
	public void tick(float delta) {
		x += dx * delta;
		y += dy * delta;
		
		//Particle Spawning
		if(time == spawnrate){
			spawnparticle();
			time = 0;
		} else {
			time++;
			System.out.println(time);
		}
	}

	@Override
	public void render(Graphics g) {
		// Emitter is not shown
	}
	
	protected void spawnparticle(){
		Particle newParticle = particle;
		float particleDX = random.nextFloat() * (maxx - minx) + minx;
		float particleDY = random.nextFloat() * (maxy - miny) + miny;
		newParticle.setX(x);
		newParticle.setY(y);
		newParticle.setDX(particleDX);
		newParticle.setDY(particleDY);
		handler.addObject(newParticle);
	}
	
	
}
