package application.launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	// Class de départ du programme

	@Override
	public void start(Stage primaryStage) { // set up du primary stage
		try {
			// appel de la première vue
			Parent root = FXMLLoader.load(getClass().getResource("/application/launcher/Launcher.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene); // implementation de la vue
			primaryStage.show(); // affichage de l'application
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
