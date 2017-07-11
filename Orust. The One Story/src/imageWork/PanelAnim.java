package imageWork;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelAnim extends JPanel{
	private int x;
	private int y;
	private int width;
	private int height;
	private int i=0;
	private ArrayList<Image> data;
	private JFrame frame;
	public PanelAnim(int x,int y,int width,int height,ArrayList<Image> data,JFrame frame) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.data=data;
		this.frame=frame;
		setBounds(x,y,width,height);
		setLayout(null);
		
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public ArrayList<Image> getData() {
		return data;
	}
	public void setData(ArrayList<Image> data) {
		this.data = data;
	}
	@Override
	public synchronized void paintComponent(Graphics g){
		
		g.drawImage(data.get(i),0,0,width,height,null);
		update();
		
	}
	private void update(){
		if(i+1<data.size()){
			i++;
		frame.repaint();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
}
