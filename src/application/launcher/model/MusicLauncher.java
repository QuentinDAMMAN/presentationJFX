package application.launcher.model;

import java.nio.file.Paths;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicLauncher {

//	private static double volume;
//	private static MediaPlayer backgroundPlayer;

	public static MediaPlayer music(String titre) {
		Media hit = new Media(
				Paths.get("src\\application\\assets\\" + titre + ".mp3").toAbsolutePath().toUri().toString());
		MediaPlayer backgroundPlayer = new MediaPlayer(hit);
		backgroundPlayer.setVolume(0.3);
		backgroundPlayer.setAutoPlay(true);
		return backgroundPlayer;
	}

//	public static void setVolume(double volume) {
//		MusicLauncher.volume = volume;
//		backgroundPlayer.setVolume(volume);	
//	}
//	

}
