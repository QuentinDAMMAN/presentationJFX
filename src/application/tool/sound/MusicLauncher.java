package application.tool.sound;

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
	private static double volume = 0.3;

	public static void music(String titre) {
		Media hit = new Media(
				Paths.get("src\\application\\assets\\music\\" + titre + ".mp3").toAbsolutePath().toUri().toString());
		backgroundPlayer = new MediaPlayer(hit);
		backgroundPlayer.setVolume(volume);
		backgroundPlayer.play();
	}

	public static void stop() {
		backgroundPlayer.stop();
	}

	public static void setVolume(double volume) {
		MusicLauncher.volume = volume;
		backgroundPlayer.setVolume(volume);
	}

	public static double getVolume() {
		return volume;
	}
	
	
}
