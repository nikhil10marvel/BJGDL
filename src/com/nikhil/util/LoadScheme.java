package com.nikhil.util;

import java.awt.Color;

import com.nikhil.entities.GameObject;

public abstract class LoadScheme extends Object{

	public GameObject gameObject;
	
	public float scx, scy = 0;
	
	public boolean compare(Color clr1, Color clr2){
		if((clr1.getRed() == clr2.getRed()) && (clr1.getBlue() == clr2.getBlue()) && (clr1.getGreen() == clr2.getGreen())){
			return true;
		} else return false;
	}

	public LoadScheme(GameObject obj, Settings settings) {
		this.gameObject = obj;
		settings.pallet = Settings.default_pallet;
	}
	
	public LoadScheme(GameObject obj, Settings settings ,int pallet_size){
		this.gameObject = obj;
		settings.pallet = new Color[pallet_size];
	}
	
	public LoadScheme(GameObject obj, Settings settings, Color[] pallet){
		this.gameObject = obj;
		settings.pallet = pallet;
	}
	
	public abstract boolean perPixel(Color pixel);

}
