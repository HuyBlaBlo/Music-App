package MusicPlayer;

import java.io.File;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class Song {
	private String filePath;
	private String songTitle;
	private String songArtist;
	private String songLength;
	
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
}















