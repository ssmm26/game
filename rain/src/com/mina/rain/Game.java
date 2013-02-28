package com.mina.rain;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
//for windows 
	public static int width=300;
	public static int height= width/16 *9;
	//how much our game scale up to.  
    //in areas which we need more space 
	public static int scale = 3; 
	private boolean running= false;
	private Thread thread;
	private JFrame frame;
	
	public Game(){
		Dimension size= new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		frame= new JFrame();
	}
	
	public synchronized void start(){
		running= true;
		thread = new Thread(this,"Display");
		thread.start();
		}
	public synchronized void stop(){
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	public void run(){
		while(running){
			System.out.println("running");
			//logcs and will be updated at a specific rate
			update();
			// pictures and stuff. update as fast as possible
			render();
		}
		
	}
	
	public void render() {
		// TODO Auto-generated method stub
		BufferStrategy bs= getBufferStrategy();
		if(bs==null){
			
		}
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		Game game = new Game();
		//it has to be the first thing to do to frame
		game.frame.setResizable(false);
		game.frame.setTitle("Rain");
		//it adds component to window. 
		//We can add the game to frame because it extends Canvas.
		game.frame.add(game);
		//it set the size according to the component
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// to show it in the middle of screen
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();
	}
	

}
