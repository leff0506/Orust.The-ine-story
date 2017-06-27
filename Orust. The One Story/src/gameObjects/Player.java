package gameObjects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gui.GamePlay;
import leff0506.Game;
import physics.Contact;

public class Player extends GameObject{
	public  int speed = 5;
	public static final int MAP_STATE_1 = 1 ;
	public static final int MAP_STATE_2 = 2 ;
	public static final int MAP_STATE_3 = 3 ;
	public static final int MAP_STATE_4 = 4 ;
	public static final int MAP_STATE_5 = 5 ;
	public static final int MAP_STATE_6 = 6 ;
	public static final int MAP_STATE_7 = 7 ;
	public static final int MAP_STATE_8 = 8 ;
	
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

	

	public void moveUp(){
		if(this.y-speed<=0){
			this.y=0;
			return;
		}
		if(!Contact.isPlayerContactWithSmth(this,0, -1*speed)){
			this.y+=-1*speed;
		}else{
			this.y=Game.getData().get(Contact.withWhat).getY()+Game.getData().get(Contact.withWhat).getHeight();
		}
		
//		
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


}
