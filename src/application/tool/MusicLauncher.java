package application.tool;

import java.nio.file.Paths;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * 
 * @author Guillaume
 *
 *         Gestion de la musique sur les diff�rents controller.
 *
 */

public class MusicLauncher {

	private static MediaPlayer backgroundPlayer;

//	private static double volume;
//	private static MediaPlayer backgroundPlayer;

	public static void music(String titre) {
		Media hit = new Media(
				Paths.get("src\\application\\assets\\" + titre + ".mp3").toAbsolutePath().toUri().toString());
		backgroundPlayer = new MediaPlayer(hit);
		backgroundPlayer.setVolume(0.3);
		backgroundPlayer.play();
	}

	public static void stop() {
		backgroundPlayer.stop();
	}

//	public static void setVolume(double volume) {
//		MusicLauncher.volume = volume;
//		backgroundPlayer.setVolume(volume);	
//	}
//	

}
