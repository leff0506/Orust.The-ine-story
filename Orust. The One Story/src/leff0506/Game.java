package leff0506;

import java.awt.Graphics;
import java.awt.Toolkit;
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
	public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height - 60-30;
	public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width-30 ;
	public static final int X = 30;
	public static final int Y = 60;
	private Player player;
	private GUIMenu guiMenu;
	public static GamePlay gameViewer;
	public static final int MAP_HEIGHT = HEIGHT-160;
	public static int MAP_X = X;
	public static int MAP_WIDTH = WIDTH-30;
	public static int MAP_Y = Y;
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
					}
					
					render();
					frames++;
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
		BufferStrategy bs = gui.getBufferStrategy();
		if(bs==null){
			gui.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		gameViewer.render(dataObj,g);
	}
	private void initGamePlay(){
		gameViewer = new GamePlay(MAP_X, MAP_Y, MAP_WIDTH,MAP_HEIGHT, dataObj,player);
	}
	private void initGameObjects() {
		dataObj.add(new GLobalMap(0,0,MAP_WIDTH,MAP_HEIGHT,gameViewer));
		Random rd = new Random();
		for(int i = 0 ; i < 50;i++){
			dataObj.add(new BlueRect(rd.nextInt(MAP_WIDTH),rd.nextInt(MAP_HEIGHT),20,20,gameViewer,player));
		}
		

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
