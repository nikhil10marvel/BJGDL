/**
 * 
 */
package com.nikhil.core;

import java.awt.Canvas;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;

/**
 * @author Nikhil
 *
 */
public class Window extends Canvas {

	protected static final long serialVersionUID = 7601786487109578946L;
	public static float WINDOW_WIDTH;
	public static float WINDOW_HEIGHT;

	public Window(float width, float height, String title, boolean dispose, Game game) {
		WINDOW_WIDTH = width;
		WINDOW_HEIGHT = height;
		
		JFrame frame = new JFrame();
		frame.setSize((int)width, (int)height);
		frame.setTitle(title);
		frame.setResizable(false);
		if(dispose) frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		else frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}

	protected Window(GraphicsConfiguration arg0) {
		super(arg0);
	}

}
