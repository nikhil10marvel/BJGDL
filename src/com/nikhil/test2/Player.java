package com.nikhil.test2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import com.nikhil.core.DrawUtils;
import com.nikhil.core.Handler;
import com.nikhil.core.Vector2f;
import com.nikhil.entities.CompoundCollider;
import com.nikhil.entities.Entity;
import com.nikhil.particle.Particle;

public class Player extends Entity {

	private Handler handler;
	boolean jumping = false;
	boolean falling = false;
	private CompoundCollider cc;
	float timer = 0;
	float spawn = 5;

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

// Particle Spawning		
		if(spawn >= 5){
			if(timer >= spawn){
				timer = 0;
				for (int x = 0; x < spawn; x++) {
					spawnparticle();
				}
			} else timer += delta;
		}
// Particle Spawning
		if(!jumping || falling) dy = 5;
		else if (jumping && !falling) { dy = -5;}
		
		
		
	}

	protected void spawnparticle(){
		Random random = new Random();
		Particle newParticle = new Particle(x, y, "player-particle", handler, 10);
		float particleDX = random.nextFloat() * (15 - (-15)) + (-15);
		float particleDY = random.nextFloat() * (25 - (-15)) + (-15);
		newParticle.particle_life_before_color = Color.CYAN;
		newParticle.particle_life_after_color = Color.yellow;
		newParticle.setX(x + (width/2));
		newParticle.setY(y - (height/2));
		newParticle.setDX(particleDX);
		newParticle.setDY(particleDY);
		handler.addIterObject(newParticle);
	}
	
	@Override
	public void render(Graphics g) {
		DrawUtils.grph = g;
		DrawUtils.drawColor = Color.BLUE;
		DrawUtils.rect(getPosition(), new Vector2f(width+2, height+2), true);
		
	}

}
