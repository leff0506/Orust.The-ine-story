package gui;

import javax.swing.JPanel;

public class MapBuffer {
	private final JPanel gameViewer;
	private final int width;
	private final int height;
	private final ObjectPanel[][] data;
	public MapBuffer(JPanel gameViewer,int width,int height) {
		data = new ObjectPanel[width/24][height/24];
		this.width=width;
		this.height = height;
		this.gameViewer =gameViewer;
		for(int i = 0 ; i < width/24;i++){
			for(int j = 0 ; j< height/24;j++){
				data[i][j]=new ObjectPanel(i*24,j*24,24,24,null);
				gameViewer.add(data[i][j]);
			}
				
		}
		 
			
			
		
		
	}
	
}
