package com.nikhil.core;

public class Vector2f {
	
	public float x;
	public float y;
	
	public static Vector2f X_UNIT = new Vector2f(1, 0);
	public static Vector2f Y_UNIT = new Vector2f(0, 1);
	
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
	
}
