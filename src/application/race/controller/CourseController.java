package application.race.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.race.model.CarAnimation;
import application.race.model.Countdown;
import application.tool.Return;
import application.tool.returnAction;
import application.tool.sound.MusicLauncher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

// Interface Initializable permet de faire une

public class CourseController implements Initializable, returnAction {
	// liaison des Nodes avec les variables grace au fx:id

	@FXML
	private ImageView voiture1;
	@FXML
	private ImageView voiture2;
	@FXML
	private ImageView voiture3;
	@FXML
	private ImageView voiture4;
	@FXML
	private ImageView voiture5;
	@FXML
	private Line finishLine;
	@FXML
	private Label decompte;
	@FXML
	private Button retour;
	private List<Integer> listeVitesse = LaunchController.getVitesses();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Countdown cd = new Countdown(decompte, this); // décompte de l'animation avec les parametre
		cd.start(); // lancement du décompte dès le chargement de la scene
	}

	// lancement des voitures a la fin du décompte
	public void startRace() {
		CarAnimation carAnim = new CarAnimation();
		ImageView[] cars = { voiture1, voiture2, voiture3, voiture4, voiture5 }; // Array d'ImageView (node contenant
																					// les images en JFX)
		carAnim.play(this, cars, listeVitesse); // on passe en paramètre les voitures et leurs vitesses pour les animer
												// en simultanés
	}

	@Override
	public void clicRetour(ActionEvent e) {
		System.out.println("test : " + ((Button) e.getSource()).getText());
		Return action = new Return();
		MusicLauncher.stop();
		action.exec(((Button) e.getSource()));
	}

	public void afficheRetour() {
		retour.setOpacity(1);
	}

}