package com.nikhil.util;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.nikhil.core.Handler;

public class LevelLoader {
	
	private transient Handler handler;
	private transient Settings settings;

	public LevelLoader(Settings settings) {
		this.handler = settings.handler;
		this.settings = settings;
	}
	
	public void loadLevelFromImage(BufferedImage level){
		System.out.println("LevelLoading");
		for (int xx = 0; xx < level.getWidth(); xx++) {
			for(int yy = 0; yy < level.getHeight(); yy++){
				int pixel = level.getRGB(xx, yy);
				Color pixel_color = new Color(pixel);
				for (int x = 0; x <= settings.schemes.length; x++) {
					LoadScheme scheme = settings.schemes[x];
					scheme.scx = xx;
					scheme.scy = yy;
					if(scheme.perPixel(pixel_color)) {
						handler.addObject(scheme.gameObject);
						System.out.println("Added Entity");
					}
				}
				//System.out.println(pixel_color.toString());	//#Debug
			}
		}
	}
}
