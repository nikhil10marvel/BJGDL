package com.nikhil.core;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

public class Vector2f {
	
	public float x;
	public float y;
	
	public static Vector2f X_UNIT = new Vector2f(1, 0);
	public static Vector2f Y_UNIT = new Vector2f(0, 1);
	public static Vector2f CENTRE = new Vector2f(Window.WINDOW_WIDTH/2, Window.WINDOW_HEIGHT/2);
	
	public Vector2f(float vx, float vy){
		this.x = vx;
		this.y = vy;
	}
	
	public void add(Vector2f vector){
		x += vector.x;
		y += vector.y;
	}
	
	public void sub(Vector2f vector){
		x -= vector.x;
		y -= vector.y;
	}
	
	public void mult(Vector2f vector){
		x *= vector.x;
		y *= vector.y;
	}
	
	public void div(Vector2f vector){
		x /= vector.x;
		y /= vector.y;
	}
	
	public static float angle(Vector2f origin, Vector2f target){
		float angle = (float) Math.toDegrees(Math.atan2(target.y - origin.y, target.x - origin.x));
	    //if(angle < 0) angle += 360;
	    return angle;
	}
	
	public static boolean isVectorOnScreen(Vector2f location) {
      
		// Check if the location is in the bounds of one of the graphics devices.
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] graphicsDevices = graphicsEnvironment.getScreenDevices();
		Rectangle graphicsConfigurationBounds = new Rectangle();

		// Iterate over the graphics devices.
		for (int j = 0; j < graphicsDevices.length; j++) {

			// Get the bounds of the device.
			GraphicsDevice graphicsDevice = graphicsDevices[j];
			graphicsConfigurationBounds.setRect(graphicsDevice.getDefaultConfiguration().getBounds());

			// Is the location in this bounds?
			graphicsConfigurationBounds.setRect(graphicsConfigurationBounds.x, graphicsConfigurationBounds.y,
					graphicsConfigurationBounds.width, graphicsConfigurationBounds.height);
			if (graphicsConfigurationBounds.contains(location.x, location.y)) {

				// The location is in this screengraphics.
				return true;

			}

		}
	    
	    // We could not find a device that contains the given point.
	    return false;
    
    }
	
}
