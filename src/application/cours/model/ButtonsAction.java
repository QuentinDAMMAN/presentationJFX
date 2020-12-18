package application.cours.model;

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
		if (buttonName == "suivant") {
			try {
				root = FXMLLoader.load(
						getClass().getResource("/application/cours/view/" + button.getAccessibleText() + ".fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			stage.setScene(new Scene(root));
		} else {
			try {
				root = FXMLLoader.load(
						getClass().getResource("/application/cours/view/" + button.getAccessibleText() + ".fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			stage.setScene(new Scene(root));
		}
	}
}
