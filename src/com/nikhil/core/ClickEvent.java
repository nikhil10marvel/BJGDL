package com.nikhil.core;

import java.awt.event.MouseEvent;

public abstract class ClickEvent {
	
	protected float x;
	protected float y;
	protected Vector2f pos;
	
	protected static int left = MouseEvent.BUTTON1;
	protected static int middle = MouseEvent.BUTTON2;
	protected static int right = MouseEvent.BUTTON3;

	public ClickEvent() {
	}
	
	public abstract void onClick(int button);
	public abstract void onPress(int button);
	public abstract void onRelease(int button);

}
