package application.race.controller;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import application.tool.Return;
import application.tool.returnAction;
import application.tool.sound.MusicLauncher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LaunchController implements Initializable, returnAction {

	// liaison des Nodes avec les variables grace au fx:id

	@FXML
	private Pane configStart;
	@FXML
	private TextField vitesseV1;
	@FXML
	private TextField vitesseV2;
	@FXML
	private TextField vitesseV3;
	@FXML
	private TextField vitesseV4;
	@FXML
	private TextField vitesseV5;
	@FXML
	private Button start;
	@FXML
	private Group groupStart;
	@FXML
	private Label erreur;
	@FXML
	private Button retour;

	// récupération des vitesses rentrer en entrée pour les utiliser plus tard

	private static List<Integer> listeVitesse = new LinkedList<>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		MusicLauncher.music("course");
	}

	// quand on appuie pour lancer la course, on vide la liste puis on y ajoute
	// toutes les nouvelles vitesses pour chaque future voiture

	public void startCourse(ActionEvent event) {
		listeVitesse.removeAll(listeVitesse);
		try {
			listeVitesse.add(Integer.parseInt(vitesseV1.getText()));
			listeVitesse.add(Integer.parseInt(vitesseV2.getText()));
			listeVitesse.add(Integer.parseInt(vitesseV3.getText()));
			listeVitesse.add(Integer.parseInt(vitesseV4.getText()));
			listeVitesse.add(Integer.parseInt(vitesseV5.getText()));
		} catch (NumberFormatException e) {
			erreur.setText("Les vitesses doivent être des entiers non nulles"); // gestion des erreurs
			return;
		}

		if (listeVitesse.stream().anyMatch(e -> e > 100)) {
			erreur.setText("Les vitesses doivent être inférieure à 100");
		} else {
			Stage stage = (Stage) start.getScene().getWindow();
			Parent root = null;
			try { // si tout est bon on prépare la scene suivante et on la lance
				root = FXMLLoader.load(getClass().getResource("/application/race/view/CourseScene.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			stage.setScene(new Scene(root));
		}
	}

	public static List<Integer> getVitesses() {
		return listeVitesse;
	}

	public void clicRetour(ActionEvent event) {
		System.out.println("test : " + ((Button) event.getSource()).getText());
		Return action = new Return();
		MusicLauncher.stop();
		action.exec(((Button) event.getSource()));
	}

}