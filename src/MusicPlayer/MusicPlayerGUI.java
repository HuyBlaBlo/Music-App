package MusicPlayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;

public class MusicPlayerGUI extends JFrame{
	// color configuration
	public static final Color FRAME_COLOR = Color.BLACK;
	public static final Color TEXT_COLOR = Color.WHITE;
	
	// actioncommand for all buttons
	public static final String LOAD_SONG_COMMAND = "LOAD_SONG";
	public static final String LOAD_PLAYLIST_COMMAND = "LOAD_PLAYLIST";
	public static final String CREATE_PLAYLIST_COMMAND = "CREATE_PLAYLIST";
    public static final String PLAY_COMMAND = "PLAY";
    public static final String PAUSE_COMMAND = "PAUSE";
    public static final String NEXT_COMMAND = "NEXT";
    public static final String PREV_COMMAND = "PREV";
    
	private MusicPlayer musicPlayer;

	// alow to us file explorer in app
	private JFileChooser jFileChooser;
	private JMenuItem loadSong;
	private JMenuItem createPlaylist;
	private JMenuItem loadPlaylist;
	private JButton prevButton;
	private JButton playButton;
	private JButton pauseButton;
	private JButton nextButton;
	private JLabel songTitle;
	private JLabel artistName;
	
	public MusicPlayerGUI() {
		setTitle("Music Player");
		setSize(400,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		// change the frame color
		getContentPane().setBackground(FRAME_COLOR);
		
		jFileChooser = new JFileChooser();
		// set defaule path for file explorer
		jFileChooser.setCurrentDirectory(new File("src/asset"));
		
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
		songTitle = new JLabel("Song Title", JLabel.CENTER);
		//position
		songTitle.setBounds(0,300,getWidth()-10, 30);
		songTitle.setFont(new Font("Dialog", Font.BOLD, 24));
		songTitle.setForeground(TEXT_COLOR);
		add(songTitle);

		// artist name;
		artistName = new JLabel("Artist Name", JLabel.CENTER);
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
		loadSong = new JMenuItem("Load Song");
		loadSong.setActionCommand(LOAD_SONG_COMMAND);
		songMenu.add(loadSong);
		
		JMenu playlistMenu = new JMenu("Play list");
		menuBar.add(playlistMenu);
		
		createPlaylist = new JMenuItem("Create Playlist");
		createPlaylist.setActionCommand(CREATE_PLAYLIST_COMMAND);
		playlistMenu.add(createPlaylist);
		
		loadPlaylist = new JMenuItem("Load Playlist");
		loadPlaylist.setActionCommand(LOAD_PLAYLIST_COMMAND);
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
		prevButton = new JButton(loadImage("src/asset/previous.png"));
		prevButton.setBorderPainted(false);
		prevButton.setContentAreaFilled(false);
		prevButton.setFocusPainted(false);
		prevButton.setBackground(null);
		prevButton.setActionCommand(PREV_COMMAND);
		btnsPanel.add(prevButton);
		
		//play button
		playButton = new JButton(loadImage("src/asset/play.png"));
		playButton.setBorderPainted(false);
		playButton.setContentAreaFilled(false);
		playButton.setFocusPainted(false);
		playButton.setBackground(null);
		playButton.setActionCommand(PLAY_COMMAND);
		btnsPanel.add(playButton);
		
		//pause button
		pauseButton = new JButton(loadImage("src/asset/pause.png"));
		pauseButton.setBorderPainted(false);
		pauseButton.setContentAreaFilled(false);
		pauseButton.setFocusPainted(false);
		pauseButton.setVisible(false);
		pauseButton.setBackground(null);
		pauseButton.setActionCommand(PAUSE_COMMAND);
		btnsPanel.add(pauseButton);
		
		
		nextButton = new JButton(loadImage("src/asset/next.png"));
		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setFocusPainted(false);
		nextButton.setBackground(null);
		nextButton.setActionCommand(NEXT_COMMAND);
		btnsPanel.add(nextButton);
		
		add(btnsPanel);
	}
	
	
	public void addActionListener(ActionListener actionListener) {
		loadPlaylist.addActionListener(actionListener);
		loadSong.addActionListener(actionListener);
		createPlaylist.addActionListener(actionListener);
		playButton.addActionListener(actionListener);
		pauseButton.addActionListener(actionListener);
		prevButton.addActionListener(actionListener);
		nextButton.addActionListener(actionListener);
		
	}


	public JFileChooser getjFileChooser() {
		return jFileChooser;
	}

	// get JChooser to alow MusicPlayerControl can use JChooser
	public void setjFileChooser(JFileChooser jFileChooser) {
		this.jFileChooser = jFileChooser;
	}

	// update titleSong and artistSong
	public void updateSongInf(Song song) {
		songTitle.setText(song.getSongTitle());
		artistName.setText(song.getSongArtist());
	}
	
}
