package imageWork;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GifPanel extends JPanel{
	private ArrayList<Image> data= new ArrayList<Image>();
	private int currentImage=0;
	private final int amountOfImages=4;
	private Thread thread;
	public GifPanel() {
		super();
		for(int i = 0 ; i < amountOfImages;i++){
			try {
				data.add(ImageIO.read(new File("Media/Menu Gif/"+(i+1)+".jpg")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	Thread thread = new Thread(new Runnable(){

		@Override
		public void run() {
			while(true){
				changeImage();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	});
	thread.start();
		
	}
	private void changeImage(){
		if(currentImage<amountOfImages){
			currentImage++;
		}else{
			currentImage=1;
		}
		
		this.repaint();
	}
	@Override
	public void paintComponent(Graphics g) {
	     super.paintComponent(g);
	     g.drawImage(data.get(currentImage-1), 0, 0, getWidth(), getHeight(), null);
	     
	 }
	

}
