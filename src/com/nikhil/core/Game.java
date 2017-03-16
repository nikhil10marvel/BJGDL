package com.nikhil.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	protected static final long serialVersionUID = 4996998232858992902L;
	public Window window;
	protected Thread thread;
	private boolean started = false;
	private BufferStrategy strategy;
	private Handler handler;
	
	public Game(float width, float height, String title, boolean dispose) {
		window = new Window(width, height, title, dispose, this);
		handler = new Handler();
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		started = true;
	}
	
	public synchronized void stop(){
		try {
			thread.join();
			started = false;
			System.gc();
			System.out.println("Deployed Garbage Collector");
			System.exit(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void run() {
		loop();	//Start the loop
		stop();	//End the thread after Finishing
	}
	
	public void loop() {
		long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        
        while(started) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            
            while(delta >= 1) {
                tick((float) delta);
                delta--;
            }
            
            if(started) {
                render();
            }
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
	}

	private void render() {
		strategy = this.getBufferStrategy();	//Getting Buffer
		if(strategy == null) {this.createBufferStrategy(3); return;}	
		// If there is no buffer (there is none usually at the start) create a new one and return
		
		//Getting graphics
		Graphics graphics = strategy.getDrawGraphics();
		
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, (int)window.WINDOW_WIDTH, (int)window.WINDOW_HEIGHT);
		//Adding black background
		
		handler.render(graphics);
		
		//Disposing graphics and showing buffer
		graphics.dispose();
		strategy.show();
	}

	private void tick(float delta) {
		handler.update(delta);
	}


}
