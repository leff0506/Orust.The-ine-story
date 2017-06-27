package leff0506;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import gameObjects.GameObject;
import gameObjects.GlobalMap;
import gameObjects.Player;
import gui.GUI;
import gui.GUIMenu;
import gui.GamePlay;
import gui.InputHendler;

public class Game {
	private static ArrayList<GameObject> dataObj = new ArrayList<GameObject>();
	public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height - 60-30;
	public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width-30 ;
	public static final int X = 30;
	public static final int Y = 60;
	private Player player;
	private GUIMenu guiMenu;
	private GlobalMap globalMap;
	public static GamePlay gameViewer;
	public static final int MAP_HEIGHT = HEIGHT-160;
	public static int MAP_X = X;
	public static int MAP_WIDTH = WIDTH-30;
	public static int MAP_Y = Y;
	public static boolean running =true;
	public static boolean renderingGlobalMap = true;
	public GUI gui;
	public Game(JFrame frame) {
		
		player = new Player(700,300,20,20);
		initGamePlay();
		initGameObjects();
		gui=new GUI();
		gui.add(new GUIMenu(frame,gui));
		
		Thread thread = new Thread(()->{

			
			
				long jvmLastTimeUpdate = System.nanoTime();
				long jvmLastTimeRender = System.nanoTime();
				long timer = System.currentTimeMillis();
				double jvmPartTimeUpdate =1_000_000_000.0/60.0;
				double jvmPartTimeRender =1_000_000_000.0/120.0;
				double deltaUpdate =0;
				double deltaRender =0;
				int updates=0;
				int frames=0;
				while(running){
					long jvmNow = System.nanoTime();
					deltaUpdate += (jvmNow - jvmLastTimeUpdate);
					jvmLastTimeUpdate=jvmNow;
					deltaRender +=(jvmNow - jvmLastTimeRender);
					jvmLastTimeRender=jvmNow;
					if(deltaUpdate>= jvmPartTimeUpdate){
						update();
						deltaUpdate=0;
						updates++;
						
					}
					if(deltaRender>= jvmPartTimeRender){	
						deltaRender=0;
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
		});
				
		thread.start();
		
		
		
	}
	private void update(){
		if(InputHendler.isKeyDown(KeyEvent.VK_W))player.moveUp();
		if(InputHendler.isKeyDown(KeyEvent.VK_D))player.moveRight();
		if(InputHendler.isKeyDown(KeyEvent.VK_A))player.moveLeft();
		if(InputHendler.isKeyDown(KeyEvent.VK_S))player.moveDown();
		if(InputHendler.isKeyDown(KeyEvent.VK_UP)&&renderingGlobalMap)globalMap.moveUp();
		if(InputHendler.isKeyDown(KeyEvent.VK_DOWN)&&renderingGlobalMap)globalMap.moveDown();
	}
	private void render(){
		gameViewer.render(dataObj);
	}
	private void initGamePlay(){
		gameViewer = new GamePlay(MAP_X, MAP_Y, MAP_WIDTH,MAP_HEIGHT, dataObj,player);
	}
	private void initGameObjects() {
		globalMap = new GlobalMap(0,0,MAP_WIDTH,MAP_HEIGHT+300,gameViewer,player);
		dataObj.add(globalMap);
//		Random rd = new Random();
//		for(int i = 0 ; i < 50;i++){
//			dataObj.add(new BlueRect(rd.nextInt(MAP_WIDTH),rd.nextInt(MAP_HEIGHT),20,20,gameViewer,player));
//		}
		

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
