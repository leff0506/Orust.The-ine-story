package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import gameObjects.Player;
import leff0506.Game;

public class GamePlay extends JPanel {
	public static int x,y,xMax,yMax;
	
	private Player player;
	public  int imgX;
	private int imgY;
	private int imgWidth;
	private int imgHeight;
	public static ArrayList<GameObject> data = new  ArrayList<GameObject>();
	
	public GamePlay(int x,int y,int xMax,int yMax,ArrayList<GameObject> data) {
		super();
		this.x=x;
		this.y=y;
		this.xMax=xMax;
		this.yMax=yMax;
		this.data=data;
		setLayout(null);
		setBounds(x,y,xMax,yMax);
		
		
		
		player = new Player(0,0,20,20);
//		
		System.out.println(x);
		System.out.println(y);
		System.out.println(xMax);
		System.out.println(yMax);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(int i =0;i<data.size();i++){
			
			g.drawImage(data.get(i).getImage(), data.get(i).getX(), data.get(i).getY(), data.get(i).getWidth(), data.get(i).getHeight(), null);
		}

			g.drawImage(player.getImage(),player.getX(), player.getY(), player.getWidth(), player.getHeight(), null);
			
	}

	public void render(ArrayList<GameObject> data){
		this.data=data;
		this.repaint();

		
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W||e.getKeyCode()==KeyEvent.VK_UP){
			player.moveUp();
		}
		if(e.getKeyCode()==KeyEvent.VK_S||e.getKeyCode()==KeyEvent.VK_DOWN){
			player.moveDown();
		}
		if(e.getKeyCode()==KeyEvent.VK_A||e.getKeyCode()==KeyEvent.VK_LEFT){
			player.moveLeft();
		}
		if(e.getKeyCode()==KeyEvent.VK_D||e.getKeyCode()==KeyEvent.VK_RIGHT){
			player.moveRight();
		}
		if(e.getKeyCode()==KeyEvent.VK_Q){
			player.moveUpLeft();
		}
		if(e.getKeyCode()==KeyEvent.VK_E){
			player.moveUpRight();;
		}
		if(e.getKeyCode()==KeyEvent.VK_Z){
			player.moveDownLeft();
		}
		if(e.getKeyCode()==KeyEvent.VK_C){
			player.moveDownRight();
		}
		
	}
	

	
}
