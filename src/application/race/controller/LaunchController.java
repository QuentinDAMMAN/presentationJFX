package application.race.controller;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

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
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class LaunchController implements Initializable {

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

	private static List<Integer> listeVitesse = new LinkedList<>();

	private static MediaPlayer backgroundPlayer;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void startCourse(ActionEvent event) {
		try {
			listeVitesse.add(Integer.parseInt(vitesseV1.getText()));
			listeVitesse.add(Integer.parseInt(vitesseV2.getText()));
			listeVitesse.add(Integer.parseInt(vitesseV3.getText()));
			listeVitesse.add(Integer.parseInt(vitesseV4.getText()));
			listeVitesse.add(Integer.parseInt(vitesseV5.getText()));
		} catch (NumberFormatException e) {
			erreur.setText("Les vitesses doivent être des entiers non nulles");
			return;
		}
		if (listeVitesse.stream().anyMatch(e -> e > 100)) {
			erreur.setText("Les vitesses doivent être inférieure à 100");
		} else {
			Stage stage = (Stage) start.getScene().getWindow();
			Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("/application/CourseScene.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			stage.setScene(new Scene(root));
		}
	}

	public static List<Integer> getVitesses() {
		return listeVitesse;
	}
	
	
	public void retour(ActionEvent event) {
		Stage stageReturn = (Stage) start.getScene().getWindow();
		Parent rootReturn = null;
		try {
			rootReturn = FXMLLoader.load(getClass().getResource("/application/launcher/Launcher.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		stageReturn.setScene(new Scene(rootReturn));
		
		
	}
	

	
}