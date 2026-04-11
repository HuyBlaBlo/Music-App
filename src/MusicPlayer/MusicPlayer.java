package MusicPlayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;

public class MusicPlayer extends JFrame{
	// color configuration
	public static final Color FRAME_COLOR = Color.BLACK;
	public static final Color TEXT_COLOR = Color.WHITE;
	
	
	public MusicPlayer() {
		setTitle("Music Player");
		setSize(400,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		// change the frame color
		getContentPane().setBackground(FRAME_COLOR);
		addGUIComponents();
	}

	
	private void addGUIComponents() {
		// add tool bar
		addToolBar();
		
		// load record image
		JLabel songImage = new JLabel(loadImage("src/asset/record.png"));
		// set positon
		songImage.setBounds(0, 50, getWidth()-10, 250);
		add(songImage);
		
		// song title
		JLabel songTitle = new JLabel("Song Title", JLabel.CENTER);
		//position
		songTitle.setBounds(0,300,getWidth()-10, 30);
		songTitle.setFont(new Font("Dialog", Font.BOLD, 24));
		songTitle.setForeground(TEXT_COLOR);
		add(songTitle);

		// artist name;
		JLabel artistName = new JLabel("Artist Name", JLabel.CENTER);
		//position
		artistName.setBounds(0,330,getWidth()-10, 30);
		artistName.setFont(new Font("Dialog", Font.BOLD, 18));
		artistName.setForeground(TEXT_COLOR);
		add(artistName);
		
		// add Slider
		JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		slider.setBounds(getWidth()/2 - 150, 386, 300, 40);
		slider.setBackground(FRAME_COLOR);
		add(slider);
	
		//add buttons
		addBtns();
	}

	private void addToolBar() {
		JToolBar toolBar = new JToolBar();
		
		toolBar.setBounds(0, 0, getWidth(), 20);
		toolBar.setFloatable(false);
		
		JMenuBar menuBar = new JMenuBar();
		toolBar.add(menuBar);
		
		// menu song: add a song where we will place the loading song option 
		JMenu songMenu = new JMenu("Song");
		menuBar.add(songMenu);
		
		//add the load song item in the songMenu
		JMenuItem loadSong = new JMenuItem("Load Song");
		songMenu.add(loadSong);
		
		JMenu playlistMenu = new JMenu("Play list");
		menuBar.add(playlistMenu);
		
		JMenuItem createPlaylist = new JMenuItem("Create Playlist");
		playlistMenu.add(createPlaylist);
		JMenuItem loadPlaylist = new JMenuItem("Load Playlist");
		playlistMenu.add(loadPlaylist); 
		
		
		add(toolBar);
	}
	
	private ImageIcon loadImage (String imagePath) {
		try {
			BufferedImage image = ImageIO.read(new File(imagePath));
			
			return new ImageIcon(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void addBtns() {
		JPanel btnsPanel = new JPanel();
		btnsPanel.setBounds(0, 440, getWidth(), 80);
		btnsPanel.setBackground(null);
		
		//previous button
		JButton prevButton = new JButton(loadImage("src/asset/previous.png"));
		prevButton.setBorderPainted(false);
		prevButton.setContentAreaFilled(false);
		prevButton.setFocusPainted(false);
		prevButton.setBackground(null);
		btnsPanel.add(prevButton);
		
		//play button
		JButton playButton = new JButton(loadImage("src/asset/play.png"));
		playButton.setBorderPainted(false);
		playButton.setContentAreaFilled(false);
		playButton.setFocusPainted(false);
		playButton.setBackground(null);
		btnsPanel.add(playButton);
		
		//pause button
		JButton pauseButton = new JButton(loadImage("src/asset/pause.png"));
		pauseButton.setBorderPainted(false);
		pauseButton.setContentAreaFilled(false);
		pauseButton.setFocusPainted(false);
		pauseButton.setBackground(null);
		btnsPanel.add(pauseButton);
		
		
		JButton nextButton = new JButton(loadImage("src/asset/next.png"));
		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setFocusPainted(false);
		nextButton.setBackground(null);
		btnsPanel.add(nextButton);
		
		add(btnsPanel);
	}

}
