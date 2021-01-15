package application.cours.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class AnimationTimelineController extends Controller {

	@FXML
	private Text text1;
	@FXML
	private Circle circle;
	@FXML
	private Group group1;
	@FXML
	private Group group2;
	@FXML
	private Group group3;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		text1.setVisible(false);
		group1.setVisible(false);
		group2.setVisible(false);
		group3.setVisible(false);
		circle.setVisible(false);
		state = StateSlide.UN;
	}

	@Override
	public void avancementSlide(MouseEvent event) {
		switch (state) {
		case UN:
			state = StateSlide.DEUX;
			text1.setVisible(true);
			break;
		case DEUX:
			group1.setVisible(true);
			circle.setVisible(true);
			state = StateSlide.TROIS;
			break;
		case TROIS:
			group2.setVisible(true);
			state = StateSlide.QUATRE;
			break;
		case QUATRE:
			group3.setVisible(true);
			break;
		}
	}

	public void timelineCircle(ActionEvent event) {

		Timeline circleAnimation = new Timeline(); // création de la timeline
		circleAnimation.setCycleCount(1); // nombre de cycle
		// ajout d'une frame avec sa durée (2s) et sa valeur
		KeyFrame k = new KeyFrame(Duration.seconds(2),
				new KeyValue(circle.translateYProperty(), circle.getTranslateY() + 300)); // on change l'ordonnées du
																							// cercle
		circleAnimation.getKeyFrames().add(k); // on ajoute la frame
		circleAnimation.play();

	}

	public void timelineCircleBounce(ActionEvent event) {

		Timeline circleAnimation = new Timeline();
		circleAnimation.setCycleCount(2);
		KeyFrame k = new KeyFrame(Duration.seconds(2),
				new KeyValue(circle.translateYProperty(), circle.getTranslateY() - 300));
		circleAnimation.getKeyFrames().add(k);
		circleAnimation.setAutoReverse(true); // autoreverse pour refaire le chemin inverse, si plusieurs KeyFrame il
												// les refait dans l'ordre inverse
		circleAnimation.play();

	}

	public void timelineCircleBounceInfinite(ActionEvent event) {

		Timeline circleAnimation = new Timeline();
		circleAnimation.setCycleCount(Animation.INDEFINITE); // Vers l'infini et l'au dela !
		KeyFrame k = new KeyFrame(Duration.seconds(2),
				new KeyValue(circle.translateYProperty(), circle.getTranslateY() - 300));
		circleAnimation.getKeyFrames().add(k);
		circleAnimation.setAutoReverse(true);
		circleAnimation.play();

	}
}
