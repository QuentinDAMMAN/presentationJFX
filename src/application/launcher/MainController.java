package application.launcher;

import java.net.URL;
import java.util.ResourceBundle;

import application.launcher.model.ButtonsAction;
import application.tool.sound.ClicSound;
import application.tool.sound.ImageClicSound;
import application.tool.sound.MusicLauncher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

// controller de la scene du launcher du programme

public class MainController implements Initializable, ImageClicSound {

	// récupération des FX id depuis la vue

	@FXML
	private Button animation;
	@FXML
	private Button cours;
	@FXML
	private ImageView imageView;

	// initialize dépend de l'interface Initializable et force tout ce qui est dans
	// la fonction a s'executer avant l'affichage de la fenêtre

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		MusicLauncher.music("elevatorMusic"); // Lancement de la musique
	}

	@FXML // fonction d'appel sur un bouton pour changer de page
	public void clic(ActionEvent event) {
		System.out.println("test : " + ((Button) event.getSource()).getText()); // récupération du nom du bouton
		ButtonsAction action = new ButtonsAction();
		MusicLauncher.stop();
		action.exec(((Button) event.getSource())); // on envoie une instance du bouton dans la fonction pour utiliser
													// ces différentes propriétés
	}

// action de lachement du clic souris sur l'image du son pour ouvrir la scene de gestion du volume	
	@Override
	public void mouseOnImageReleased() {
		System.out.println("Test : appuie sur l'image du son");
		ClicSound action = new ClicSound();
		MusicLauncher.stop();
		action.exec(imageView);
	}
}
