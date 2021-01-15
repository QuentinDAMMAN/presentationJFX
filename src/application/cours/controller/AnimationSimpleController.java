package application.cours.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class AnimationSimpleController extends Controller {

	@FXML
	private Text text1;
	@FXML
	private ImageView img1;
	@FXML
	private Button btn1;
	@FXML
	private ImageView img2;
	@FXML
	private Button btn2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		text1.setVisible(false);
		btn1.setVisible(false);
		btn2.setVisible(false);
		img1.setVisible(false);
		img2.setVisible(false);
		state = StateSlide.UN;
	}

	@Override
	public void avancementSlide(MouseEvent event) {
		switch (state) {
		case UN:
			text1.setVisible(true);
			state = StateSlide.DEUX;
			break;
		case DEUX:
			btn1.setVisible(true);
			img1.setVisible(true);
			state = StateSlide.TROIS;
			break;
		case TROIS:
			btn2.setVisible(true);
			img2.setVisible(true);
			break;
		case QUATRE:
			break;
		}
	}

	public void rotate(ActionEvent event) {
		RotateTransition rotationImage = new RotateTransition(); // création de l'animation sans parametre
		rotationImage.setCycleCount(1); // nombre de fois qu'elle se répète
		rotationImage.setNode(img1); // node sur laquelle l'animation s'applique
		rotationImage.setByAngle(360); // degrés de la rotation
		rotationImage.setDuration(Duration.seconds(4)); // durée de la rotation
		rotationImage.play(); // et on lance !
	}

	public void dual(ActionEvent event) {
		TranslateTransition boutonTranslation = new TranslateTransition(); // première transition
		boutonTranslation.setNode(btn2); // node sur laquelle l'animation s'applique
		boutonTranslation.setToX(-500); // destination de la translation
		TranslateTransition imageTranslation = new TranslateTransition(); // deuxième transition
		imageTranslation.setNode(img2);// node sur laquelle l'animation s'applique
		imageTranslation.setToX(500); // destination de la translation
		ParallelTransition dualTransition = new ParallelTransition(boutonTranslation, imageTranslation); // on ajoute
																											// les deux
																											// dans une
																											// transition
																											// parallele
		dualTransition.play(); // on lance tout en meme temps
	}
}
