package com.nikhil.core;

import java.awt.Font;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SplashScreen extends JFrame{

	private static final long serialVersionUID = 5488723841699475837L;
	private Splash splash = new Splash(null, 0L);

	public SplashScreen(String title) {
		setResizable(true);
		setTitle(title);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		try {
			splash.img = new ImageIcon(new URL("http://orig02.deviantart.net/8fae/f/2013/076/f/e/wormhole_by_makanix-d5yff76.gif"));
			splash.duration = 100000;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			dispose();
		}
	}
	
	public void setSplash(Splash splash){
		this.splash = splash;
	}
	
	public void start(){
		setVisible(true);
		JLabel gif = new JLabel();
		gif.setIcon(splash.img);
		setSize(splash.img.getIconWidth(), splash.img.getIconHeight());
		getContentPane().add(gif);
		JLabel poweredBy = new JLabel("powered by");
		poweredBy.setFont(new Font("Serif", Font.ITALIC, 14));;
		JLabel BJGDL = new JLabel("BJGDL");
		BJGDL.setFont(new Font("Serif", Font.BOLD, 20));
		try {
			if(splash.equals(new Splash(new ImageIcon(new URL("http://orig02.deviantart.net/8fae/f/2013/076/f/e/wormhole_by_makanix-d5yff76.gif")), 100000))){
				getContentPane().add(poweredBy);
				poweredBy.setLocation(800/2, (600/2)-32);
				getContentPane().add(BJGDL);
				BJGDL.setLocation(800/2, 600/2);
				sleep();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispose();
	}
	
	private void sleep(){
		try {
			Thread.sleep(splash.duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
