package MusicPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class MusicPlayerControl extends PlaybackListener implements ActionListener{
	
	private MusicPlayerGUI gui;
	private MusicPlayer player;
	
	public MusicPlayerControl(MusicPlayerGUI gui,MusicPlayer player) {
		this.player = player;
		this.gui = gui;
		
		this.gui.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getActionCommand();
		
		if(object.equals(MusicPlayerGUI.LOAD_SONG_COMMAND)) {
			gui.getjFileChooser().showOpenDialog(gui);
			File selectedFile = gui.getjFileChooser().getSelectedFile();
			
			if(selectedFile!=null) {
				Song song = new Song(selectedFile.getPath());
				
				//update song title and artist of the song
				gui.updateSongInf(song);
				// load the song anh play that song
				player.loadSong(song,this);
				
				//toggle on pause button and toggle off start button
				gui.enablePauseAndDisablePlay();
			}
		}
		else if(object.equals(MusicPlayerGUI.PAUSE_COMMAND)) {
			//toggle off pause button and toggle on play button
			gui.enablePlayAndDisablePause();
			
			player.pauseSong();
		}
	}
	
	// this method gets called when start the song
	@Override
	public void playbackFinished(PlaybackEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("finished");
	}
	
	//this method gets called when the song finished or the player gets close
	@Override
	public void playbackStarted(PlaybackEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("start");
	}
	
	
}	
