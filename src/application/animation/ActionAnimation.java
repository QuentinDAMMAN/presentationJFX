package application.animation;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ActionAnimation {
	public void exec(Button button) {
		String buttonName = button.getText().toLowerCase();
		Stage stage = (Stage) button.getScene().getWindow();
		Parent root = null;
		switch (buttonName) {
		case "circular":
			try {
				root = FXMLLoader.load(getClass().getResource("/application/circular/Circular.fxml"));
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

		}
		return;
	}
}
