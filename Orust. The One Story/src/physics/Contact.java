package physics;

import java.awt.Rectangle;
import java.util.ArrayList;

import gameObjects.Player;
import gui.GameObject;
import leff0506.Game;

public class Contact {
	public static int withWhat;
	public static boolean contact(int x1,int y1,int w1,int h1,int x2,int y2,int w2,int h2){
		 Rectangle r1 = new Rectangle(x1, y1, w1, h1);
		 Rectangle r2 = new Rectangle(x2, y2, w2, h2);
		 return r1.intersects(r2);
	}
	public static  boolean isPlayerContactWithSmth(Player player,int xOffset,int yOffset){
		withWhat=0;
		if(Game.renderingGlobalMap){
			for(int i = 0 ; i < Game.getData().size();i++){
				if(i!=0)
				if(Contact.contact(player.getX()+xOffset,player.getY()+yOffset,player.getWidth()+xOffset,player.getHeight() +yOffset,Game.getData().get(i).getX(),Game.getData().get(i).getY(),Game.getData().get(i).getWidth(),Game.getData().get(i).getHeight())){
					withWhat=i;
					return true;
				
				}
			}
		}else{
			for(int i = 0 ; i < Game.getData().size();i++){
				if(Contact.contact(player.getX()+xOffset,player.getY()+yOffset,player.getWidth()+xOffset,player.getHeight() +yOffset,Game.getData().get(i).getX(),Game.getData().get(i).getY(),Game.getData().get(i).getWidth(),Game.getData().get(i).getHeight())){
					withWhat=i;
					return true;
				}
			}
		}
		
		return false;
	}
}
