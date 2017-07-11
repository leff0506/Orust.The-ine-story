package gui;



import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import imageWork.ImagePanel;
import leff0506.Game;

public class GUI extends JFrame{
	private ImagePanel brick;
	public static final int BRICK_SIZE =30;
	public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	public GUI() {
		
		// Create JFrame
		super("Orust. The One Story");System.out.println(WIDTH+" "+HEIGHT);
		setUndecorated(true);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);

		// Create left dragon
		
		brick = new ImagePanel();
		try {
			brick.setImage(ImageIO.read(new File("Media/Interface/brick.jpg")));
			int temp=0;
			
			while(temp<WIDTH){
				ImagePanel tmp = new ImagePanel();
				tmp.setImage(brick.getImage());
				create(tmp,temp,0,BRICK_SIZE);
				temp+=BRICK_SIZE;
			}
			temp =0;
			while(temp<WIDTH){
				ImagePanel tmp = new ImagePanel();
				tmp.setImage(brick.getImage());
				create(tmp,temp,HEIGHT-BRICK_SIZE,BRICK_SIZE);
				temp+=BRICK_SIZE;
			}
			temp=BRICK_SIZE;
			while(temp<HEIGHT-BRICK_SIZE){
				ImagePanel tmp = new ImagePanel();
				tmp.setImage(brick.getImage());
				create(tmp,0,temp,BRICK_SIZE);
				temp+=BRICK_SIZE;
			}
			temp=BRICK_SIZE;
			while(temp<HEIGHT-BRICK_SIZE){
				ImagePanel tmp = new ImagePanel();
				tmp.setImage(brick.getImage());
				create(tmp,WIDTH-BRICK_SIZE,temp,BRICK_SIZE);
				temp+=BRICK_SIZE;
			}
			temp=BRICK_SIZE;
			while(temp<WIDTH-BRICK_SIZE){
				ImagePanel tmp = new ImagePanel();
				tmp.setImage(brick.getImage());
				create(tmp,temp,BRICK_SIZE+GUIMenu.HEIGHT,BRICK_SIZE/2);
				temp+=BRICK_SIZE/2;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		add(Game.gameViewer);
		addKeyListener(new InputHendler());
		super.setVisible(true);
	}
	private void create(ImagePanel c,int x,int y,int size){
		c.setLayout(null);
		c.setBounds(x, y, size, size);
		add(c);
	}
}
