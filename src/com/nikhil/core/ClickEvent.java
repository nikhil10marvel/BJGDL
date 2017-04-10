package com.nikhil.core;

public abstract class ClickEvent {
	
	protected float x;
	protected float y;
	protected Vector2f pos;

	public ClickEvent() {
	}
	
	public abstract void onClick(int button);
	public abstract void onPress(int button);
	public abstract void onRelease(int button);

}
