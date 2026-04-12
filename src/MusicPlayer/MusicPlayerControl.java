package MusicPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

public class MusicPlayerControl implements ActionListener{
	
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
				gui.updateSongInf(song);
				player.loadSong(song);
			}
		}	
	}
 
}	
