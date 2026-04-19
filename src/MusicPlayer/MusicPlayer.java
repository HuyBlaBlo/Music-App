package MusicPlayer;

import java.io.BufferedInputStream;

import java.io.FileInputStream;

import javax.swing.JOptionPane;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackListener;


public class MusicPlayer {
	
	private MusicPlayerGUI gui;
	// this class to store our's song details
	private Song currentSong;
	
	// use jLayer libary to create an AdvancePlayer obj which will handle  playing the musisc
	private AdvancedPlayer advancedPlayer;
	
	// pause flag use to indicate whether the music player has been pause 
	private boolean isPause;
	
	//store last frame when the PlayBack is finished (use for pausing or resume the song)
	private int currentFrame;
	
	// track how many millisec has passed, its use for to update slider
	private int currnentTimeInMills;
	
	public MusicPlayer(MusicPlayerGUI gui) {
		this.gui = gui;
	}
	
	public void loadSong(Song song, PlaybackListener playbackListener) {
		currentSong = song;
		if(currentSong!=null) {
			currentFrame = 0;
			isPause = false;
			playCurrentSong(playbackListener);
		}
	}
	
	public void playCurrentSong(PlaybackListener playbackListener) {
		if(currentSong == null) {
			return;
		}
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
			
			startPlaybackSliderThread();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} 
	}

	private void startMusicThread() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					if(isPause) {
						// play song at the last frame
						advancedPlayer.play(currentFrame, Integer.MAX_VALUE);
					}
					else {
						// play music from the begining
						advancedPlayer.play();
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	
	private void startPlaybackSliderThread() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while(!isPause) {
						//increment currrent time mili
						currnentTimeInMills++;
						
						//caculate millisec to frame because slider will be relative to frame not millisec
						int caculateFrame = (int) ((double) currnentTimeInMills * currentSong.getFrameRatePerMilliSeconds());
						
						//uopdate GUI
						gui.setPlayBackSliderValue(caculateFrame);
						
						Thread.sleep(1);
						
					}
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

	public int getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	public boolean isPause() {
		return isPause;
	}

	public void setPause(boolean isPause) {
		this.isPause = isPause;
	}

	public Song getCurrentSong() {
		return currentSong;
	}

	public void setCurrentSong(Song currentSong) {
		this.currentSong = currentSong;
	}
	
	
}












