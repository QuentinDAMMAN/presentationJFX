package application.tool;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Return {
	public void exec(Button button) {
		Stage stageReturn = (Stage) button.getScene().getWindow();
		Parent rootReturn = null;
		try {
			rootReturn = FXMLLoader.load(getClass().getResource("/application/launcher/Launcher.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		stageReturn.setScene(new Scene(rootReturn));
	}
}
