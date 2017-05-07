package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class ObjectPanel extends JPanel{
	private final int width;
	private final int height;
	private final GameObject obj;
	
	
	public ObjectPanel(int x , int y , int  width , int height , GameObject obj) {
		super();
		this.width = width;
		this.height = height;
		this.obj = obj;
		setLayout(null);
		setBounds(x, y, width, height);
		Random rd = new Random();
		setBackground(new Color(rd.nextInt(255),rd.nextInt(255),rd.nextInt(255)));
	}
//	@Override
//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//	    g.drawImage(obj.getImage(), 0,0,width, height, null);
//	}

}
