package MusicPlayer;

import java.io.File;

import com.mpatric.mp3agic.*;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class Song {
	private String filePath;
	private String songTitle;
	private String songArtist;
	private String songLength;
	private Mp3File mp3File;
	private double frameRatePerMilliSeconds;
	// constructor
	public Song(String filePath) {	
		this.filePath = filePath;
		// use jaudiotagger libary to create an audio object to read information of mp3 file
		try {
			
			// get specific info about mp3 file
			mp3File = new Mp3File(filePath);
			frameRatePerMilliSeconds = (double) mp3File.getFrameCount()/mp3File.getLengthInMilliseconds();
			AudioFile audioFile = AudioFileIO.read(new File(filePath));
			
			Tag tag = audioFile.getTag();
			
			if( tag!=null) {
				songTitle = tag.getFirst(FieldKey.TITLE);
				songArtist = tag.getFirst(FieldKey.ARTIST);
			}
			else {
				songTitle = "N/A";
				songArtist = "N/A";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Mp3File getMp3File() {
		return mp3File;
	}

	public void setMp3File(Mp3File mp3File) {
		this.mp3File = mp3File;
	}

	public double getFrameRatePerMilliSeconds() {
		return frameRatePerMilliSeconds;
	}

	public void setFrameRatePerMilliSeconds(double frameRatePerMilliSeconds) {
		this.frameRatePerMilliSeconds = frameRatePerMilliSeconds;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getSongArtist() {
		return songArtist;
	}

	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}

	public String getSongLength() {
		return songLength;
	}

	public void setSongLength(String songLength) {
		this.songLength = songLength;
	}
}















