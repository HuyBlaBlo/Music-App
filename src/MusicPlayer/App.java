package MusicPlayer;

import javax.swing.SwingUtilities;

public class App {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				MusicPlayerGUI gui = new MusicPlayerGUI();	
				
				MusicPlayer player = new MusicPlayer(gui);			
				
				MusicPlayerControl control = new MusicPlayerControl(gui, player);
				
				gui.setVisible(true);
				// this is way how to test Song class
				
//				Song song = new Song("src/asset/Auld Lang Syne (Instrumental) - Jingle Punks.mp3");
//				System.out.println(song.getSongTitle());
//				System.out.println(song.getSongArtist());
				
			}
		});
	}
}
