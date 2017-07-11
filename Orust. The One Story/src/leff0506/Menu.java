package leff0506;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.Developers;
import imageWork.ImagePanel;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Menu extends JFrame {
	private JLabel startGame;
	private JLabel upload;
	private JLabel settings;
	private JLabel developers;
	private JLabel exit;
	private Font font;
	private Color cl;
	private ImagePanel panel;

	private final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height; 
	private final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int X_MENU=WIDTH*7/56;
	private final int Y_MENU=HEIGHT*16/36;
	public Menu()  {
		super("Orust.The One Story");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setExtendedState(MAXIMIZED_BOTH);
		
		//Create font
		
		font =new Font("Monotype Corsiva",Font.BOLD+Font.ITALIC,50);
		
		cl = new Color(0,0,0);
		//Create panel
		panel = new ImagePanel();
		try {
			panel.setImage(ImageIO.read(new File("./Media/Menu/menu.jpg")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel.setLayout(null);
		panel.setBounds(0, 0, WIDTH, HEIGHT);
		panel.setBackground(Color.black);
		
		//Create start Label
		startGame = new JLabel();
		startGame.setLayout(null);
		
		startGame.setFont(font);
		startGame.setSize(280,60);
		startGame.setLocation(X_MENU,Y_MENU);
		startGame.setBorder(null);
		startGame.setForeground(cl);
		startGame.setText("Начать игру");
		startGame.addMouseListener(new MouseListener() {
			
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
				startGame.setForeground(cl);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				startGame.setForeground(Color.BLUE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
//				player.close();
				new Game();
				dispose();
				
			}
		});	
		panel.add(startGame);
		//Create upload Label
		upload = new JLabel();
		upload.setLayout(null);
				
		upload.setFont(font);
		upload.setSize(350,60);
		upload.setLocation(X_MENU-40,Y_MENU+70);
		upload.setBorder(null);
		upload.setForeground(cl);
		upload.setText("Загрузить игру");
		upload.addMouseListener(new MouseListener() {
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
				upload.setForeground(cl);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				upload.setForeground(Color.BLUE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {	
			}
		});		
		panel.add(upload);
		//Create settings Label
		settings = new JLabel();
		settings.setLayout(null);			
		settings.setFont(font);
		settings.setSize(250,60);
		settings.setLocation(X_MENU+7,Y_MENU+170);
		settings.setBorder(null);
		settings.setForeground(cl);
		settings.setText("Настройки");
		settings.addMouseListener(new MouseListener() {
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
				settings.setForeground(cl);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				settings.setForeground(Color.BLUE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {	
			}
		});			
		panel.add(settings);
		//Create developers Label
		developers = new JLabel();
		developers.setLayout(null);			
		developers.setFont(font);
		developers.setSize(250,40);
		developers.setLocation(X_MENU+27,Y_MENU+250);
		developers.setBorder(null);
		developers.setForeground(cl);
		developers.setText("Титры");
		developers.addMouseListener(new MouseListener() {
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
				developers.setForeground(cl);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				developers.setForeground(Color.BLUE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {	
				new Developers();
			}
		});			
		panel.add(developers);	
		//Create exit Label
		exit = new JLabel();
		exit.setLayout(null);			
		exit.setFont(font);
		exit.setSize(250,40);
		exit.setLocation(X_MENU+50,Y_MENU+350);
		exit.setBorder(null);
		exit.setForeground(cl);
		exit.setText("Выход");
		exit.addMouseListener(new MouseListener() {
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
				exit.setForeground(cl);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setForeground(Color.BLUE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});			
		panel.add(exit);		
	   //add components to JFrame 
		add(panel);
		setVisible(true);
		
	}

}
