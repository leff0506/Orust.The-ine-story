package maps;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class MapMaker extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Panel panel;
	private JMenuBar mb;
	private JMenuItem New;
	private JMenu file;
	private File file3;
	private JMenuItem write; 
	private JMenuItem read;
	private JMenu project;
	private JMenuItem delete;
	private OutputStreamWriter osw;
	public static Dimension curDim;
	private ArrayList<String> parsed = new ArrayList<String>();
	private char[] delim = new char[]{'(',':',',',')',' ','\n','\t','\r','_'};
	private Image [] textures2D;
	public MapMaker(){
		super("Map Maker");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		mb = new JMenuBar();
		file = new JMenu("File");
		New = new JMenuItem("New");
		New.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewProject();
				
			}
		});
		write = new JMenuItem("Write");
		write.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				write();
				
			}
		});
		read = new JMenuItem("Read");
		read.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				read();
				
			}
		});
		file.add(New);
		file.addSeparator();
		file.add(read);
		file.add(write);
		
		project = new JMenu("Project");
		
		delete = new JMenuItem("Delete last");
		delete.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MapMaker.panel.removeLast();
				MapMaker.panel.update();
				
			}
		});
		project.add(delete);
		mb.add(file);
		mb.add(project);
		
		panel = new Panel();
		panel.setBackground(Color.BLACK);
		
		add(panel);
		setJMenuBar(mb);
		setVisible(true);
		addKeyListener(new InputHendler(panel));
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MapMaker mm = new MapMaker();
	}
	private void createNewProject(){
		System.out.println("create new project");
		File file2 = new File("./Maps");
		int i = file2.listFiles().length;
		file3 = new File("Maps/map"+i+".otos");
		try {
			file3.createNewFile();
			
			
			ask();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		
	}
	private void read(){
		System.out.println("read");
		JFileChooser fc = new JFileChooser();
		
		fc.showOpenDialog(panel);
		file3 = fc.getSelectedFile();
		System.out.println(file.getName());
		try {
			@SuppressWarnings("resource")
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file3)));
			String getter = bf.readLine();
			fill(getter.toCharArray());
			for(int i = 0;i<parsed.size();i++){
				System.out.println(parsed.get(i));
			}
			curDim=new Dimension((int)Double.parseDouble(parsed.get(0)),(int)
					Double.parseDouble(parsed.get(1)));
			textures();
			createTable();
			
//			for(int i = 2;i<parsed.size();i++){
//				ImagePanel p = new ImagePanel(i-2);
//				p.setImage(textures2D[Integer.parseInt(parsed.get(i))]);
//				
//				if(Texture.posX+p.getWidth()<=curDim.width){
//					MapMaker.panel.add(new Texture(p.getImage(), Texture.posX,Texture.posY, p.getWidth(),p.getHeight(),p.getId()));
//					Texture.posX+=p.getWidth();
//				}else if((Texture.posY+p.getHeight()*2<=curDim.height)){
//					Texture.posX=0;
//					Texture.posY+=p.getHeight();
//					MapMaker.panel.add(new Texture(p.getImage(), Texture.posX,Texture.posY, p.getWidth(),p.getHeight(),p.getId()));
//					Texture.posX+=p.getWidth();
//				}
//				
//			}
			for(int i = 2 ;i < parsed.size();i++){
				int temp = Integer.parseInt(parsed.get(i));
				if(Texture.posX+textures2D[temp].getWidth(panel)<=curDim.width){
					MapMaker.panel.add(new Texture(textures2D[temp],Texture.posX,Texture.posY,textures2D[temp].getWidth(panel),textures2D[temp].getWidth(panel),temp));
					Texture.posX+=textures2D[temp].getWidth(panel);
				}else if((Texture.posY+textures2D[temp].getHeight(panel)*2<=curDim.height)){
					Texture.posX=0;
					Texture.posY+=textures2D[temp].getHeight(panel);
					MapMaker.panel.add(new Texture(textures2D[temp],Texture.posX,Texture.posY,textures2D[temp].getWidth(panel),textures2D[temp].getWidth(panel),temp));
					Texture.posX+=textures2D[temp].getWidth(panel);
				}
			}
			
			MapMaker.panel.update();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void fill(char[] array){
		int i =0;
		int start=0;
		while(i< array.length){
			if(isDelim(array[i])){
				String temp = subStr( array,start,i-start);
				if(!temp.isEmpty()){
					parsed.add(temp);
				}
				start=i+1;
			}
			i++;
		}
	}
	private boolean isDelim(char el){
		for(int i = 0 ; i < delim.length;i++){
			if(delim[i] == el){
				return true;
			}
		}
		return false;
	}
	private String subStr(char[] str,int start,int end){
		return new String(str,start,end);
	}
	private void write(){
		try {
			osw = new OutputStreamWriter(new FileOutputStream(file3));
			StringBuffer str = new StringBuffer();
			List<Texture> temp = panel.getData();
			str.append("(("+curDim.getWidth()+"_"+curDim.getHeight()+")");
			for(int i = 0 ;i<temp.size();i++){
				if(i==temp.size()-1){
					str.append(temp.get(i).getId());
				}else{
					str.append(temp.get(i).getId()+",");
				}
			}
			str.append(')');
			osw.write(str.toString());
			osw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Dimension ask(){
		JFrame frame = new JFrame("New file");
		frame.setSize(200,200);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(20,20,20));
		panel.setLayout(null);
		JTextField widthF = new JTextField();
		widthF.setBounds(0, 0, 50, 20);
		
		JTextField heightF = new JTextField();
		heightF.setBounds(0, 40, 50, 20);
		
		JButton submit = new JButton("Submit");
		submit.setBounds(0, 70, 100, 40);
		panel.add(widthF);
		panel.add(heightF);
		panel.add(submit);
		
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				curDim=null;
				int width= Integer.parseInt(widthF.getText());
				int height= Integer.parseInt(heightF.getText());
				curDim= new Dimension(width,height);
				System.out.println(curDim.toString());
				createTable();
				textures();
				frame.dispose();
				
			}
		});
		
		frame.add(panel);
		frame.setVisible(true);
	
		return curDim;
	}
	private void createTable(){
		setLayout(null);
		panel.setSize(curDim);
		panel.setBackground(Color.RED);
	}
	private void  textures(){
		JFrame textures = new JFrame();
		textures.setBounds(0,0,500,500);
		textures.setUndecorated(true);
		textures.setAlwaysOnTop(true);
		textures.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.showOpenDialog(panel);
		File file = fc.getSelectedFile();
		File[] textures2Dfiles = file.listFiles(); 
		textures2D = new Image[ textures2Dfiles.length];
		for(int i = 0 ; i < textures2Dfiles.length;i++){
			try {
				textures2D[i]=ImageIO.read(textures2Dfiles[i]);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int posX=0;
		for(int i = 0 ; i < textures2Dfiles.length;i++){
			ImagePanel p = new ImagePanel(i);
			p.setImage(textures2D[i]);
			if(posX+textures2D[i].getWidth(p)>panel.getWidth()){
				panel.setSize(panel.getWidth()+500,panel.getHeight());
			}
			if(textures2D[i].getHeight(p)>panel.getHeight()){
				panel.setSize(panel.getWidth(),panel.getHeight()+200);
			}
			p.setBounds(posX, 0,textures2D[i].getWidth(p),textures2D[i].getHeight(p));
			posX+=textures2D[i].getWidth(p);
			p.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(Texture.posX+p.getWidth()<=curDim.width){
						MapMaker.panel.add(new Texture(p.getImage(), Texture.posX,Texture.posY, p.getWidth(),p.getHeight(),p.getId()));
						Texture.posX+=p.getWidth();
					}else if((Texture.posY+p.getHeight()*2<=curDim.height)){
						Texture.posX=0;
						Texture.posY+=p.getHeight();
						MapMaker.panel.add(new Texture(p.getImage(), Texture.posX,Texture.posY, p.getWidth(),p.getHeight(),p.getId()));
						Texture.posX+=p.getWidth();
					}
					
					MapMaker.panel.update();
					
				}
			});
			panel.add(p);
		}
		textures.add(panel);
		textures.setVisible(true);
		textures.addKeyListener(new InputHendler2(panel));
	}
}
class Panel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Texture> data;
	private int rot=0;
	public List<Texture> getData() {
		return data;
	}
	public void add(Texture tx){
		data.add(tx);
	}
	public void removeLast(){
		if(data.size()>1){
			data.remove(data.size()-1);
			if(Texture.posX==0){
				Texture.posY-=data.get(data.size()-1).getHeight();
				Texture.posX=MapMaker.curDim.width-data.get(data.size()-1).getWidth();
			}else{
				Texture.posX-=data.get(data.size()-1).getWidth();
			}
		}else{
			data.clear();
			
			Texture.posY=0;
			Texture.posX=0;
			
		}
		
			
	}
	public Panel(){
		data = new ArrayList<>();
	}
	public void update(){
		repaint();
		rot++;
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		if(rot!=0){
			for(Texture t : data){
				g.drawImage(t.getImage(), t.getX(), t.getY(), t.getWidth(),t.getHeight(),null);
			}
		}
		
	}
	
}
class InputHendler implements KeyListener{
	private Panel panel;
	private int speed = 40;
	public InputHendler(Panel panel){
		this.panel = panel;
	}
	@SuppressWarnings("static-access")
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==e.VK_LEFT)panel.setLocation(panel.getLocation().x+speed,panel.getLocation().y); 
		if(e.getKeyCode()==e.VK_RIGHT)panel.setLocation(panel.getLocation().x-speed,panel.getLocation().y); 
		if(e.getKeyCode()==e.VK_UP)panel.setLocation(panel.getLocation().x,panel.getLocation().y+speed); 
		if(e.getKeyCode()==e.VK_DOWN)panel.setLocation(panel.getLocation().x,panel.getLocation().y-speed); 
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
class InputHendler2 implements KeyListener{
	private JPanel panel;
	private int speed = 40;
	public InputHendler2(JPanel panel){
		this.panel = panel;
	}
	@SuppressWarnings("static-access")
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==e.VK_A)panel.setLocation(panel.getLocation().x+speed,panel.getLocation().y); 
		if(e.getKeyCode()==e.VK_D)panel.setLocation(panel.getLocation().x-speed,panel.getLocation().y); 
		if(e.getKeyCode()==e.VK_W)panel.setLocation(panel.getLocation().x,panel.getLocation().y+speed); 
		if(e.getKeyCode()==e.VK_S)panel.setLocation(panel.getLocation().x,panel.getLocation().y-speed); 
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
 class ImagePanel extends JPanel{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
	 private int id;
	 public int getId() {
		return id;
	}
	 public ImagePanel(int id){
		 this.id = id;
	 }
	public Image getImage() {
	     return image;
	 }
	
	 public void setImage(Image image) {
	     this.image = image;
	 }
	 
	 public void paintComponent(Graphics g) {
	     super.paintComponent(g);
	     if(image != null){
	         g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	     }
	 }
}
 class Texture {
	 public static int posX=0;
	 public static int posY=0;
	 private Image image;
	 private int x;
	 private int y;
	 private int width;
	 private int id;
	 
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
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
	public Texture(Image image,int x,int y,int width,int height,int id){
		this.image=image;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.id =id;
	}
	private int height;
	 
 }
