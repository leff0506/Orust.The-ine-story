package leff0506;

import java.awt.Toolkit;
import java.util.ArrayList;

import gameObjects.GLobalMap;
import gui.GUI;
import gui.GUIMenu;
import gui.GameObject;
import gui.GamePlay;

public class Game {
	private ArrayList<GameObject> dataObj = new ArrayList<GameObject>();
	public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height - 60-30;
	public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width-30 ;
	public static final int X = 30;
	public static final int Y = 60;
	
	private GUIMenu guiMenu;
	public static GamePlay gameViewer;
	public static final int MAP_HEIGHT = HEIGHT-160;
	public static int MAP_X = X;
	public static int MAP_WIDTH = WIDTH-30;
	public static int MAP_Y = Y;
	public GUI gui;
	public Game() {
		initGameObjects();
		initGamePlay();
		gui=new GUI();
		gui.add(new GUIMenu());
		Thread thread = new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					render();
					try {
						Thread.sleep(1000/60);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
			}
		});
				
		thread.start();
		
		
		
	}
	private void render(){
		gameViewer.render(dataObj);
	}
	private void initGamePlay(){
		gameViewer = new GamePlay(MAP_X, MAP_Y, MAP_WIDTH,MAP_HEIGHT, dataObj);
	}
	private void initGameObjects() {
		dataObj.add(new GLobalMap(0,0,MAP_WIDTH,MAP_HEIGHT,gameViewer));
		

	}

}
