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
		Stage stage = (Stage) button.getScene().getWindow();
		Parent root = null;
		switch (buttonName) {
		case "animation":
			try {
				root = FXMLLoader.load(getClass().getResource("/application/animation/AnimationIntro.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			stage.setScene(new Scene(root));
			break;
		case "race":
			try {
				root = FXMLLoader.load(getClass().getResource("/application/race/view/LancementCourse.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			stage.setScene(new Scene(root));
			break;
		case "cours":
			try {
				root = FXMLLoader.load(getClass().getResource("/application/cours/view/Intro.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			stage.setScene(new Scene(root));
			break;
		case "draganddrop":
			break;
		case "login":
			break;

		}
		return;
	}
}
