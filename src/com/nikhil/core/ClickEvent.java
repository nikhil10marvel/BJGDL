package com.nikhil.core;

public abstract class ClickEvent {
	
	protected float x;
	protected float y;
	protected Vector2f pos;

	public ClickEvent() {
	}
	
	public abstract void onClick();
	public abstract void onPress();
	public abstract void onRelease();

}
