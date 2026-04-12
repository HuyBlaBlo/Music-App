package MusicPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackListener;

public class MusicPlayer {
	// this class to store our's song details
	private Song currentSong;
	
	// use jLayer libary to create an AdvancePlayer obj which will handle  playing the musisc
	private AdvancedPlayer advancedPlayer;
	
	// pause flag use to indicate whether the music player has been pause 
	private boolean isPause;
	//constructor
	public MusicPlayer() {
		
	}
	
	public void loadSong(Song song, PlaybackListener playbackListener) {
		currentSong = song;
		if(currentSong!=null) {
			playCurrentSong(playbackListener);
		}
	}
	
	public void playCurrentSong(PlaybackListener playbackListener) {
		try {
			
			// read .mp3 audio data
			FileInputStream fileInputStream = new  FileInputStream(currentSong.getFilePath());
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
			
			// create an advancePlayer with JLayer libary
			advancedPlayer = new AdvancedPlayer(bufferedInputStream);
			
			// add PlayBackListener to advancedPlayer
			advancedPlayer.setPlayBackListener(playbackListener);
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
	
	public void pauseSong(){
		if(advancedPlayer!=null) {
			isPause = true;
			// pausing song
			stopSong();
		}
	}
	public void stopSong() {
		if(advancedPlayer!=null) {
			advancedPlayer.stop();
			advancedPlayer.close();
			advancedPlayer = null;
		}
	}
}












