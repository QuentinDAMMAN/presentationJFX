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
			btn1.setVisible(false);
			img1.setVisible(false);
			state = StateSlide.TROIS;
			break;
		case TROIS:
			btn2.setVisible(false);
			img2.setVisible(false);
			break;
		case QUATRE:
			break;
		}
	}

	public void rotate(ActionEvent event) {
		RotateTransition rotationImage = new RotateTransition();
		rotationImage.setCycleCount(1);
		rotationImage.setNode(img1);
		rotationImage.setByAngle(360);
		rotationImage.setDuration(Duration.seconds(4));
		rotationImage.play();
	}

	public void dual(ActionEvent event) {
		TranslateTransition boutonTranslation = new TranslateTransition();
		boutonTranslation.setNode(btn2);
		boutonTranslation.setToX(-500);
		TranslateTransition imageTranslation = new TranslateTransition();
		imageTranslation.setNode(img2);
		imageTranslation.setToX(500);
		ParallelTransition dualTransition = new ParallelTransition(boutonTranslation, imageTranslation);
		dualTransition.play();
	}
}
