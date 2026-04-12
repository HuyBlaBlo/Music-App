package MusicPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.advanced.AdvancedPlayer;

public class MusicPlayer {
	// this class to store our's song details
	private Song currentSong;
	
	//constructor
	public MusicPlayer() {
		
	}
	
	// use jLayer libary to create an AdvancePlayer obj which will handle  playing the musisc
	private AdvancedPlayer advancedPlayer;
	
	
	public void loadSong(Song song) {
		currentSong = song;
		if(currentSong!=null) {
			playCurrentSong();
		}
	}
	
	public void playCurrentSong() {
		try {
			
			// read .mp3 audio data
			FileInputStream fileInputStream = new  FileInputStream(currentSong.getFilePath());
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
			
			// create an advancePlayer with JLayer libary
			advancedPlayer = new AdvancedPlayer(bufferedInputStream);
			
			//start music
			startMusicThread();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void startMusicThread() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					///play music
					advancedPlayer.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();;
		
	}
	
}












