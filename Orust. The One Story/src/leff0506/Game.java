package leff0506;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

import gameObjects.BlueRect;
import gameObjects.GLobalMap;
import gameObjects.Player;
import gui.GUI;
import gui.GUIMenu;
import gui.GameObject;
import gui.GamePlay;
import gui.InputHendler;

public class Game {
	private static ArrayList<GameObject> dataObj = new ArrayList<GameObject>();
	
	public static final int WIDTH = GUIMenu.WIDTH;
	public static final int GV_X=GUI.BRICK_SIZE;
	public static final int GV_Y=GUI.BRICK_SIZE*3/2+GUIMenu.HEIGHT;
	public static final int HEIGHT = GUI.HEIGHT-GV_Y-GUI.BRICK_SIZE;
	private Player player;
	private GUIMenu guiMenu;
	public static GamePlay gameViewer;
	public static boolean running =true;
	public static boolean renderingGlobalMap = true;
	public GUI gui;
	public Game() {
		
		initGameObjects();
		player = new Player(0,0,20,20);
		initGamePlay();
		gui=new GUI();
		gui.add(new GUIMenu());
		
		Thread thread = new Thread(new Runnable(){

			@Override
			public void run() {
				long jvmLastTime = System.nanoTime();
				long timer = System.currentTimeMillis();
				double jvmPartTime =1_000_000_000.0/60.0;
				double delta =0;
				int updates=0;
				int frames=0;
				while(running){
					long jvmNow = System.nanoTime();
					delta += (jvmNow - jvmLastTime);
					jvmLastTime=jvmNow;
					if(delta>= jvmPartTime){
						update();
						delta=0;
						updates++;
						render();
						frames++;
					}
					
					
					if(System.currentTimeMillis()-timer>1000){
						gui.setTitle("Orust.The one story  frames : "+frames + "updates : "+updates);
						timer+=1000;
						updates=0;
						frames = 0;
					}
				}
				
				
			}
		});
				
		thread.start();
		
		
		
	}
	private void update(){
		if(InputHendler.isKeyDown(KeyEvent.VK_W))player.moveUp(-1*player.speed);
		if(InputHendler.isKeyDown(KeyEvent.VK_D))player.moveRight();
		if(InputHendler.isKeyDown(KeyEvent.VK_A))player.moveLeft();
		if(InputHendler.isKeyDown(KeyEvent.VK_S))player.moveDown();
		
	}
	private void render(){
		gameViewer.render(dataObj);
	}
	private void initGamePlay(){
		gameViewer = new GamePlay(GV_X,GV_Y,WIDTH,HEIGHT, dataObj,player);
	}
	private void initGameObjects() {
	}
	public static void addGameObject(GameObject item){
		dataObj.add(item);
	}
	public static void removeGameObject(GameObject item){
		dataObj.remove(item);
	}
	public static ArrayList<GameObject> getData(){
		return dataObj;
	}

}
