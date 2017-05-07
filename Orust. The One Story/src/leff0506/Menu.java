package leff0506;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.Developers;
import imageWork.GifPanel;
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
	private GifPanel panel;
	private Player player;
	private final int MAX_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height-60; 
	private final int MAX_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public Menu()  {
		super("Orust.The One Story");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		
		//Create font
		
		font =new Font("Monotype Corsiva",Font.BOLD+Font.ITALIC,30);
		
		cl = new Color(209,242,25);
		//Create panel
		panel = new GifPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, MAX_WIDTH, MAX_HEIGHT);
		panel.setBackground(Color.black);
		
		//Create start Label
		startGame = new JLabel();
		startGame.setLayout(null);
		
		startGame.setFont(font);
		startGame.setSize(250,40);
		startGame.setLocation(600,250);
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
		upload.setSize(250,40);
		upload.setLocation(580,300);
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
		settings.setSize(250,40);
		settings.setLocation(607,350);
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
		developers.setLocation(627,400);
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
		exit.setLocation(635,450);
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
		
			Thread sound = new Thread(new Runnable(){
				@Override
				public void run(){
					try {
						FileInputStream f= new FileInputStream("Media/Audio/tempAudio.mp3");
						player = new Player(f);
						player.play();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (JavaLayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
			});
//			sound.start();
			
			
		
		
	}

}
