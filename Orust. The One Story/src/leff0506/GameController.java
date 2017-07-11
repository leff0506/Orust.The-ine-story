package leff0506;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import imageWork.ImagePanel;
import imageWork.PanelAnim;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class GameController {
	private  Game game;
	public GameController(){
		createCharacter();
//		game = new Game();
		
		
	}
	
	
//	private void uploadMap(File file){
//		try {
//			InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
//			char [] temp = new char[1024*1024];
//			StringBuffer buf = new StringBuffer();
//			while(isr.read(temp)>0){
//				buf.append(new String(temp));
//			}
//			String parsed = buf.toString();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	private void createCharacter(){
		JFrame frame = new JFrame();
		frame.setUndecorated(true);
		frame.setLayout(null);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		ImagePanel i = new ImagePanel();
		try {
			i.setLocation(0, 0);
			i.setLayout(null);
			i.setSize(Toolkit.getDefaultToolkit().getScreenSize());
			i.setImage(ImageIO.read(new File("./GameController/dragon.jpg")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.add(i);	
		
		frame.setVisible(true);
		new Thread(()->{try {
			Player player = new Player(new FileInputStream(new File("./Media/Audio/elf.mp3")));
			player.play();
		} catch (FileNotFoundException | JavaLayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}).start();
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Image> data = new ArrayList<>();
		File[] tmp = (new File("./Media/scroll")).listFiles();
		for(File f : tmp){
			try {
				data.add(ImageIO.read(f));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		PanelAnim panel = new PanelAnim(frame.getWidth()/10, frame.getHeight()/10, 700, 700,data,frame);
		panel.setBackground(null);
		
		
		i.add(panel);
		frame.repaint();
		new Thread(()->{try {
			Player player = new Player(new FileInputStream(new File("./Media/Audio/scroll.mp3")));
			player.play();
		} catch (FileNotFoundException | JavaLayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}).start();
	}
}
