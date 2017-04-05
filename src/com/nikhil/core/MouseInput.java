package com.nikhil.core;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{

	private ClickEvent event;
	private boolean set;

	public MouseInput() {
	}
	
	public void setEvent(ClickEvent click){
		this.event = click;
		this.set = true;
	}
	
	public void enable(){
		this.set = true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(set) { event.onClick(); event.x = e.getX(); event.y = e.getY(); event.pos = new Vector2f(e.getX(), e.getY());}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(set) {event.onPress(); event.x = e.getX(); event.y = e.getY(); event.pos = new Vector2f(e.getX(), e.getY());}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(set) {event.onRelease(); event.x = e.getX(); event.y = e.getY(); event.pos = new Vector2f(e.getX(), e.getY());}
	}
	
	public void disable(){
		this.set = false;
	}

}
