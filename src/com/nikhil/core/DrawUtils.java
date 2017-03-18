package com.nikhil.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class DrawUtils {

	public static Graphics grph;
	public static Color drawColor;

	public DrawUtils(Graphics g) {
		this.grph = g;
	}
	
	public static void box(float x, float y, float length, boolean fill){
		grph.setColor(drawColor);
		if(fill) grph.fillRect((int)x, (int)y, (int)length, (int)length);
		else grph.drawRect((int)x, (int)y, (int)length, (int)length);
	}
	
	public static void rect(float x, float y, float length, float breadth, boolean fill){
		grph.setColor(drawColor);
		if(fill) grph.fillRect((int)x, (int)y, (int)length, (int)breadth);
		else grph.drawRect((int)x, (int)y, (int)length, (int)breadth);
	}
	
	public static void circle(float x, float y, float radius, boolean fill){
		grph.setColor(drawColor);
		if(fill) grph.fillOval((int)x, (int)y, (int)radius, (int)radius);
		else grph.drawRect((int)x, (int)y, (int)radius, (int)radius);
	}
	
	public static void oval(float x, float y, float width, float height, boolean fill){
		grph.setColor(drawColor);
		if(fill) grph.fillOval((int)x, (int)y, (int)width, (int)height);
		else grph.drawRect((int)x, (int)y, (int)width, (int)height);
	}
	
	public static void image(float x, float y, BufferedImage image, ImageObserver io){
		grph.setColor(drawColor);
		grph.drawImage(image, (int)x, (int)y, io);
	}

}
