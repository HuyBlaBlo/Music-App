package MusicPlayer;

import javax.swing.SwingUtilities;

public class App {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
//				new MusicPlayerGUI().setVisible(true);				
				
				// this is way how to test Song class
				
				Song song  = new Song("src/asset/Auld Lang Syne (Instrumental) - Jingle Punks.mp3");
				System.out.println(song);
			}
		});
	}
}
