package MusicPlayer;

import java.io.File;

import com.mpatric.mp3agic.*;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class Song {
	private String filePath;
	private String songTitle;
	private String songArtist;
	private String songLength;

	// constructor
	public Song(String filePath) {	
		this.filePath = filePath;
		// use jaudiotagger libary to create an audio object to read information of mp3 file
		try {
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















