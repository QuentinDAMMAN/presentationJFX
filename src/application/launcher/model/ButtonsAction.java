package application.launcher.model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ButtonsAction {
	public void exec(Button button) {
		String buttonName = button.getText().toLowerCase();
		switch (buttonName) {
		case "animation":
			break;
		case "race":
			Stage stage = (Stage) button.getScene().getWindow();
			Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("/application/race/view/LancementCourse.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			stage.setScene(new Scene(root));
			break;
		case "course":
			break;
		case "draganddrop":
			break;
		case "login":
			break;
		case "setvolume":
			break;
		case "retour":
			Stage stageReturn = (Stage) button.getScene().getWindow();
			Parent rootReturn = null;
			try {
				rootReturn = FXMLLoader.load(getClass().getResource("/application/launcher/Launcher.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			stageReturn.setScene(new Scene(rootReturn));
			break;
		}
		return;
	}
}
