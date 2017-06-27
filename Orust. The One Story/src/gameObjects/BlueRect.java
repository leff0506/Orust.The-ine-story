package gameObjects;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gui.GamePlay;

public class BlueRect extends GameObject{
	public BlueRect(int x,int y,int width,int height,GamePlay gamePlay,Player player) {
		try {
			setImage(ImageIO.read(new File("Media/Game objects/player.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.gamePlay=gamePlay;
		this.player=player;
	}

}
