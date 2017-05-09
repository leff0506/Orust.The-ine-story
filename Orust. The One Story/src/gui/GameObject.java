package gui;

import java.awt.Image;

import gameObjects.Player;

public abstract class GameObject {
	protected Image image;
	protected int x;
	protected int y ;
	protected int height;
	protected int width;
	protected GamePlay gamePlay;
	protected Player player;
	public void setImage(Image img){
		this.image=img;
	}
	public  Image getImage(){
		return image;
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
