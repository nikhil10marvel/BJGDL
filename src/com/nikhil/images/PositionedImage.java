package com.nikhil.images;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class PositionedImage{
	
	public BufferedImage bufferedImage;
	public int x;
	public int y;
	public ImageObserver observer;

	public PositionedImage(BufferedImage image, float x, float y, ImageObserver observer){
		this.bufferedImage = image;
		this.observer = observer;
		this.x = (int)x;
		this.y = (int)y;
	}

}
