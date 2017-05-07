package gameObjects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gui.GameObject;
import gui.GamePlay;

public class Player extends GameObject{
	private static int speed = 4;
	public int x;
	public int y ;
	public int height;
	public int width;
	public Player(int x,int y,int width,int height) {
		try {
			setImage(ImageIO.read(new File ("Media/Game objects/player.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
	}

	
	public  void move(int x,int y){
	
		
		
		this.x+=x*speed;
		this.y+=y*speed;
	}
	public void moveUp(){
		if(this.y-speed<=0){
			this.y=0;
			return;
		}
		move(0,-1);
	}
	public void moveDown(){
		if(this.y+height+speed>=GamePlay.yMax){
			this.y=GamePlay.yMax-height;
			return;
		}
		move(0,1);
	}
	public void moveLeft(){
		if(this.x-speed<=0){
			this.x=0;
			return;
		}
		move(-1,0);
	}
	public void moveRight(){
		if(this.x+width+speed>=GamePlay.xMax){
			this.x=GamePlay.xMax-width;
			return;
		}
		move(1,0);
	}
	public void moveUpLeft(){
		moveLeft();
		moveUp();
	}
	public void moveUpRight(){
		moveUp();
		moveRight();
	}
	public void moveDownLeft(){
		moveLeft();
		moveDown();
	}
	public void moveDownRight(){
		moveRight();
		moveDown();
	}	
	public  int getX(){
		return x;
	}
	public  int getY(){
		return y;
	}
	public  int getWidth(){
		return width;
	}
	public  int getHeight(){
		return height;
	}
	public void setX(int x1){
		x=x1;
	}
	public void setY(int y1){
		y=y1;
	}

}
