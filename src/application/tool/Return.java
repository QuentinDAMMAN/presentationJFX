package application.tool;

import java.io.IOException;

import application.tool.sound.MusicLauncher;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Return {
	public void exec(Button button) {
		Stage stageReturn = (Stage) button.getScene().getWindow(); // récupération du Stage principal
		Parent rootReturn = null;
		try { // préparationde la scene a charger dans le stage
			rootReturn = FXMLLoader.load(getClass().getResource("/application/launcher/Launcher.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		MusicLauncher.stop();
		stageReturn.setScene(new Scene(rootReturn)); // affichage de la nouvelle scene
	}
}
