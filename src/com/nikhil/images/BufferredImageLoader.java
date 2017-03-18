package com.nikhil.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class BufferredImageLoader {
	
	public static BufferedImage loadImage(String path){
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public static BufferedImage loadImage(InputStream inputStream){
		BufferedImage img = null;
		try {
			img = ImageIO.read(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public static BufferedImage loadImageURL(String url){
		BufferedImage img = null;
		try {
			img = ImageIO.read(new URL(url));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	
	public static BufferedImage loadImage(File file){
		BufferedImage img = null;
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}

}
