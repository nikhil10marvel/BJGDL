package com.nikhil.core;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class KeyInput extends KeyAdapter{
	
	InputEvent[] events;
	private boolean setting;
	
	public void setEvent(InputEvent[] events) {
		this.setting = true;
		this.events = events;
	}
	
	public void setEvents(InputEvent... event){
		this.setting = true;
		events = new InputEvent[event.length];
		for(int x = 0; x < events.length; x++){
			events[x] = event[x];
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println(e.getKeyCode());	//Debug
		if(setting == true){
			for (int i = 0; i < events.length; i++) {
				InputEvent evt = events[i];
				int key = evt.keyCode;
				if(e.getKeyCode() == key) evt.onActivated();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(setting == true){
			for (int i = 0; i < events.length; i++) {
				InputEvent evt = events[i];
				int key = evt.keyCode;
				if(e.getKeyCode() == key) evt.onDeactivated();
			}
		}
	}
	
}
