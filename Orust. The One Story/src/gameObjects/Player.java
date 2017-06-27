package gameObjects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gui.GameObject;
import gui.GamePlay;
import leff0506.Game;
import physics.Contact;

public class Player extends GameObject{
	public  int speed = 5;
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
		player=this;
	}

	

	public void moveUp(int up){
		if(this.y-speed<=0){
			this.y=0;
			return;
		}
		if(!Contact.isPlayerContactWithSmth(this,0, up)){
			this.y+=-1*speed;
		}else{
			this.y=Game.getData().get(Contact.withWhat).getY()+Game.getData().get(Contact.withWhat).getHeight();
		}
		
		
	}
	public void moveDown(){
		if(this.y+height+speed>=GamePlay.yMax){
			this.y=GamePlay.yMax-height;
			return;
		}
		if(!Contact.isPlayerContactWithSmth(this,0, 1*speed)){
			this.y+=1*speed;
		}else{
			this.y=Game.getData().get(Contact.withWhat).getY()-player.getHeight();
		}
		
		
	}
	public void moveLeft(){
		if(this.x-speed<=0){
			this.x=0;
			return;
		}
		if(!Contact.isPlayerContactWithSmth(this,-1*speed,0)){
			this.x+=-1*speed;
		}else{
			this.x=Game.getData().get(Contact.withWhat).getX()+Game.getData().get(Contact.withWhat).getWidth();
		}
		
	}
	public void moveRight(){
		if(this.x+width+speed>=GamePlay.xMax){
			this.x=GamePlay.xMax-width;
			return;
		}
		if(!Contact.isPlayerContactWithSmth(this,1*speed,0)){
			this.x+=1*speed;
		}else{
			this.x=Game.getData().get(Contact.withWhat).getX()-player.getWidth();
		}
		
	}
	
	public int getX(){
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
