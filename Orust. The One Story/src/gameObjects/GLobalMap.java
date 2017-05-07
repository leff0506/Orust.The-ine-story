package gameObjects;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gui.GameObject;
import gui.GamePlay;

public class GLobalMap extends GameObject{
	
	public GLobalMap(int x,int y,int width,int height,GamePlay gamePlay) {
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
	}

	

}
