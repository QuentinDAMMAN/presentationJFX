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
		Media hit = new Media( // Chargement de l'url en string pour la musique avec le titre passé en
								// parametre
				Paths.get("src\\application\\assets\\music\\" + titre + ".mp3").toAbsolutePath().toUri().toString());
		backgroundPlayer = new MediaPlayer(hit); // chargement de la musique dans le lecteur
		backgroundPlayer.setVolume(volume); // volume de base (a 1 c'est vraiment fort)
		backgroundPlayer.play(); // Et c'est parti pour la musique
	}

	// stop la piste en cours pour éviter une superposition des sons

	public static void stop() {
		backgroundPlayer.stop();
	}

	// changer le volume

	public static void setVolume(double volume) {
		MusicLauncher.volume = volume;
		backgroundPlayer.setVolume(volume);
	}

	public static double getVolume() {
		return volume;
	}

}
