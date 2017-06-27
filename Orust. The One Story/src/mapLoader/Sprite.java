package mapLoader;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameObjects.GameObject;
import gui.GamePlay;

public class Sprite extends GameObject{
    private Image image;
    
    public Sprite(String path){
    	try {
			image =ImageIO.read(new File(path));
			addToRendering();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    private void addToRendering(){
    	GamePlay.data.add(this);
    }
    
    

   
}
