package gameObjects;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gui.GamePlay;
import leff0506.Game;

public class GlobalMap extends GameObject{
	private final int speed=10;
	
	public GlobalMap(int x,int y,int width,int height,GamePlay gamePlay,Player player) {
		try {
			setImage(ImageIO.read(new File ("Media/Game objects/globalMap.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.gamePlay=gamePlay;
		this.player = player;
	}
	public void moveUp(){
		if(this.getY()+speed>0){
			this.setY(0);
		}else{
			this.setY(this.getY()+speed);
			for(int i = 0 ; i < Game.getData().size();i++){
				if(i!=0){
					Game.getData().get(i).setY(Game.getData().get(i).getY()+speed);
					
				}
			}
			player.setY(player.getY()+speed);
		}
		
		
	}
	public void moveDown(){	
		if(this.getY()-speed<GamePlay.yMax-height){
			
			this.setY(GamePlay.yMax-height);
			
		}else{
			this.setY(this.getY()-speed);
			for(int i = 0 ; i < Game.getData().size();i++){
				if(i!=0){
					Game.getData().get(i).setY(Game.getData().get(i).getY()-speed);
					
				}
			}

			player.setY(player.getY()-speed);
			
		}
	}
	

}
