package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import imageWork.ImagePanel;

public class Developers extends JFrame{
	private ImagePanel panel;
	public Developers() {
		super("Титры");
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Toolkit kit =Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(screenSize);
		setExtendedState(MAXIMIZED_BOTH);
		panel = new ImagePanel();
		panel.setLayout(null);
		try {
			panel.setImage(ImageIO.read(new File("MenuIcon/developers.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.setSize(screenSize);
		add(panel);
		setVisible(true);
	}

}
