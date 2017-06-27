package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import leff0506.Game;

public class InputHendler implements KeyListener{
	private static boolean[] keys;
	public InputHendler() {
		keys = new boolean[100];
	}
	public static boolean isKeyDown(int key){
		return keys[key];
	}
		
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]=false;
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
