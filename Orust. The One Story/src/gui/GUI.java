package gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import imageWork.HeroPanel;
import imageWork.ImagePanel;
import leff0506.Game;

public class GUI extends JFrame{
	private JPanel menu;
	private ImagePanel rollInMenu;
	private ImagePanel hourGlassInMenu;
	private ImagePanel globeInMenu;
	private ImagePanel heroInMenu;
	private ImagePanel leftDragon;
	private ImagePanel rightDragon;
	private ImagePanel upDragon;
	private ImagePanel downDragon;
	private ImagePanel delimiter;
	private HeroPanel imageGero;
	private final int MAX_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height - 60 - 30;
	private final int MAX_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width - 30;
	private final int MIN_WIDTH = 30;
	private final int MIN_Height = 30;
	
	private final int MAP_MAX_HEIGHT = MAX_HEIGHT-160;
	private final int MAP_MIN_WIDTH = MIN_WIDTH;
	private final int MAP_MAX_WIDTH = MAX_WIDTH-30;
	private final int MAP_MIN_HEIGHT = MIN_Height+30;
	public GUI() {

		// Create JFrame
		super("Orust. The One Story");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);

		// Create left dragon
		leftDragon = new ImagePanel();
		try {
			leftDragon.setImage(ImageIO.read(new File("Media/Interface/leftB.png")));
		} catch (IOException e) {
		}
		leftDragon.setLayout(null);
		leftDragon.setBounds(0, MIN_Height, 30, MAX_HEIGHT - 30);
		leftDragon.setBackground(null);

		// Create right dragon
		rightDragon = new ImagePanel();
		try {
			rightDragon.setImage(ImageIO.read(new File("Media/Interface/rightB.png")));
		} catch (IOException e) {
		}
		rightDragon.setLayout(null);
		rightDragon.setBounds(MAX_WIDTH, MIN_Height, 30, MAX_HEIGHT - 30);
		rightDragon.setBackground(null);

		// Create up dragon
		upDragon = new ImagePanel();
		try {
			upDragon.setImage(ImageIO.read(new File("Media/Interface/upB.png")));
		} catch (IOException e) {
		}
		upDragon.setLayout(null);
		upDragon.setBounds(0, 0, MAX_WIDTH + 30, MIN_Height);
		upDragon.setBackground(null);
		// Create down dragon
		downDragon = new ImagePanel();
		try {
			downDragon.setImage(ImageIO.read(new File("Media/Interface/downB.png")));
		} catch (IOException e) {
		}
		downDragon.setLayout(null);
		downDragon.setBounds(0, MAX_HEIGHT, 1366, 30);
		downDragon.setBackground(null);
		// Create delimiter
		delimiter = new ImagePanel();
		try {
			delimiter.setImage(ImageIO.read(new File("Media/Interface/delimiter.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		delimiter.setBounds(30,52,MAP_MAX_WIDTH,8);
		delimiter.setLayout(null);
		delimiter.setBackground(null);
		// add components to JFrame
//		add(menu);
		add(leftDragon);
		add(rightDragon);
		add(upDragon);
		add(downDragon);
		add(delimiter);
		add(Game.gameViewer);
		addKeyListener(new InputHendler());
		super.setVisible(true);
	}

}
