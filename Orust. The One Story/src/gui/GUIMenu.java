package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import leff0506.Game;

public class GUIMenu extends JPanel {
	private int gold = 0;
	private int silver = 0;
	private int bronze = 0;
	private Image delimiter;
	private JLabel upload;
	private JLabel exit;
	private JLabel mainMenu;
	private JLabel save;
	private Image goldCoin;
	private Image silverCoin;
	private Image bronzeCoin;
	private Image delimiter2;
	private JLabel hero;
	private JLabel map;
	private Image crystal;

	// private Gold goldPanel;
	public GUIMenu() {
		super();
		setBounds(Game.MAP_X, Game.MAP_Y - 30, Game.MAP_WIDTH, Game.MAP_Y - 8);
		setBackground(new Color(163, 93, 0));
		Font font = new Font("Arial", Font.ITALIC, 17);
		setLayout(null);
		try {
			delimiter = ImageIO.read(new File("Media/GuiMenu/delimiter.png"));
			delimiter2 = ImageIO.read(new File("Media/GuiMenu/delimiter2.png"));
			goldCoin = ImageIO.read(new File("Media/GuiMenu/gold_coin.png"));
			silverCoin = ImageIO.read(new File("Media/GuiMenu/silver_coin.png"));
			bronzeCoin = ImageIO.read(new File("Media/GuiMenu/bronze_coin.png"));
			crystal =ImageIO.read(new File("Media/GuiMenu/crystal.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// create exitLabel
		exit = new JLabel();
		exit.setBackground(null);
		exit.setLayout(null);
		exit.setFont(font);
		exit.setForeground(new Color(255, 234, 0));
		exit.setBounds(15, 0, 73, 20);
		exit.setText("Выйти");
		exit.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
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
				exit.setForeground(new Color(255, 234, 0));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				exit.setForeground(Color.BLUE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		// create mainMenuLabel
		mainMenu = new JLabel();
		mainMenu.setBackground(null);
		mainMenu.setLayout(null);
		mainMenu.setFont(font);
		mainMenu.setForeground(new Color(255, 234, 0));
		mainMenu.setBounds(108, 0, 117, 20);
		mainMenu.setText("Главное меню");
		mainMenu.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		mainMenu.addMouseListener(new MouseListener() {

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
				mainMenu.setForeground(new Color(255, 234, 0));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				mainMenu.setForeground(Color.BLUE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		// create uploadLabel
		upload = new JLabel();
		upload.setBackground(null);
		upload.setLayout(null);
		upload.setFont(font);
		upload.setForeground(new Color(255, 234, 0));
		upload.setBounds(258, 0, 130, 20);
		upload.setText("Загрузить игру");
		upload.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
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
				upload.setForeground(new Color(255, 234, 0));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				upload.setForeground(Color.BLUE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		// create savePanel
		save = new JLabel();
		save.setBackground(null);
		save.setLayout(null);
		save.setFont(font);
		save.setForeground(new Color(255, 234, 0));
		save.setBounds(410, 0, 133, 20);
		save.setText("Сохранить игру");
		save.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		save.addMouseListener(new MouseListener() {

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
				save.setForeground(new Color(255, 234, 0));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				save.setForeground(Color.BLUE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		//create heroLabel
		hero = new JLabel();
		hero.setBackground(null);
		hero.setLayout(null);
		hero.setFont(font);
		hero.setForeground(new Color(255, 234, 0));
		hero.setBounds(1065, 0, 50, 20);
		hero.setText("Герой");
		hero.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		hero.addMouseListener(new MouseListener() {

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
				hero.setForeground(new Color(255, 234, 0));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				hero.setForeground(Color.BLUE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		//create mapLabel
		map = new JLabel();
		map.setBackground(null);
		map.setLayout(null);
		map.setFont(font);
		map.setForeground(new Color(255, 234, 0));
		map.setBounds(1150, 0, 153, 20);
		map.setText("Глобальная карта");
		map.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		map.addMouseListener(new MouseListener() {

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
				map.setForeground(new Color(255, 234, 0));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				map.setForeground(Color.BLUE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		// add components to panel
		add(exit);
		add(mainMenu);
		add(upload);
		add(save);
		add(hero);
		add(map);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(delimiter, 90, 0, 8, 30, null);
		g.drawImage(delimiter, 243, 0, 8, 30, null);
		g.drawImage(delimiter, 395, 0, 8, 30, null);
		g.drawImage(delimiter, 550, 0, 8, 30, null);
		g.drawImage(goldCoin, 565, 2, 25, 18, null);
		g.drawImage(delimiter2, 670, 0, 8, 30, null);
		g.drawImage(silverCoin, 685, 2, 25, 18, null);
		g.drawImage(delimiter2, 790, 0, 8, 30, null);
		g.drawImage(bronzeCoin, 805, 2, 25, 18, null);
		g.drawImage(delimiter2, 925, 0, 8, 30, null);
		g.drawImage(crystal, 935, 2, 25, 18, null);
		g.drawImage(delimiter, 1045, 0, 8, 30, null);
		g.drawImage(delimiter, 1130, 0, 8, 30, null);
	}

	// Getters and setters
	public int getGold() {
		return gold;
	}

	public void increaseGold(int gold) {
		this.gold += gold;
	}

	public void decreaseGold(int gold) {
		this.gold -= gold;
	}

	public int getSilver() {
		return silver;
	}

	public void increaseSiver(int silver) {
		this.silver += silver;
	}

	public void decreaseSilver(int silver) {
		this.silver -= silver;
	}

	public int getBronze() {
		return bronze;
	}

	public void increaseBronze(int bronze) {
		this.bronze += bronze;
	}

	public void decreaseBronzer(int bronze) {
		this.bronze -= bronze;
	}
}
