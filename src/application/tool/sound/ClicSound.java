package application.tool.sound;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ClicSound {
	public void exec(ImageView image) {
		Stage stageReturn = (Stage) image.getScene().getWindow();
		Parent rootReturn = null;
		try {
			rootReturn = FXMLLoader.load(getClass().getResource("/application/tool/sound/SoundScene.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		stageReturn.setScene(new Scene(rootReturn));
	}
}
