package com.nikhil.core;

public abstract class InputEvent {
	
	protected int keyCode;
	
	public InputEvent(int keyCode){
		this.keyCode = keyCode;
	}
	
	public abstract void onActivated();
	public abstract void onDeactivated();
}
