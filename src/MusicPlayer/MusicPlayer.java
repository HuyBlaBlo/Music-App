package MusicPlayer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

public class MusicPlayer extends JFrame{
	public MusicPlayer() {
		setTitle("Music Player");
		setSize(400,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		addGUIComponents();
	}

	
	private void addGUIComponents() {
		addToolBar();
	}

	private void addToolBar() {
		JToolBar toolBar = new JToolBar();
		
		toolBar.setBounds(0, 0, getWidth(), 20);
		toolBar.setFloatable(false);
		
		JMenuBar menuBar = new JMenuBar();
		toolBar.add(menuBar);
		
		// menu song: add a song where we will place a 
		JMenu songMenu = new JMenu("Song");
		
		menuBar.add(songMenu);
		
		
		
		
		add(toolBar);
	}
	
	
}
