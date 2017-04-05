package com.nikhil.test2;

import java.awt.Color;
import java.awt.Graphics;

import com.nikhil.core.DrawUtils;
import com.nikhil.entities.GameObject;

public class Block extends GameObject{

	public Block(float x, float y, String ident) {
		super(x, y, ident);
		width = 32;
		height = 32;
		genHitbox();
	}

	@Override
	public void tick(float delta) {
	}

	@Override
	public void render(Graphics g) {
		DrawUtils.grph = g;
		DrawUtils.drawColor = Color.white;
		DrawUtils.box(x, y, width, false);
	}

}
