package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import audio.AudioPlayer;

public class MainFrame extends JFrame{
	private AudioPlayer audio;
	private JButton btnLoad;
	public MainFrame(AudioPlayer audioPlayer) {
		this.audio = audioPlayer;
		initUI();
	}

	private void initUI() {
		
		// Basic setup
		this.setTitle("Chill Music");
		this.setSize(400, 500);;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		
		// main panel
		JPanel panel = new JPanel(new BorderLayout());
		
		// show the next song
		JPanel pnlNorth = new JPanel(new BorderLayout(5, 5));
		
		// custom component: next song
		
		//component add song file
		btnLoad = new JButton("<html><b>+</b></html>");
		btnLoad.setFont(new Font("Arial", Font.BOLD, 16));
		btnLoad.setPreferredSize(new Dimension(30, 30));
		pnlNorth.add(btnLoad,BorderLayout.EAST);
		
		panel.add(pnlNorth, BorderLayout.NORTH);
		
		// dics and slider
		this.add(panel);
	}
}
