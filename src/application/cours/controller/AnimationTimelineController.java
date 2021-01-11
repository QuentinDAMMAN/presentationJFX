package application.cours.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class AnimationTimelineController extends Controller {

	@FXML
	private TextArea text1;
	@FXML
	private TextArea text2;
	@FXML
	private Circle circle;
	@FXML
	private Button play;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		text1.setVisible(false);
//		text2.setVisible(false);
//		text3.setVisible(false);
		state = StateSlide.UN;
	}

	@Override
	public void avancementSlide(MouseEvent event) {
		switch (state) {
		case UN:
			state = StateSlide.DEUX;
			break;
		case DEUX:
			state = StateSlide.TROIS;
			break;
		case TROIS:
			break;
		case QUATRE:
			break;
		}
	}

	public void timelineCircle(ActionEvent event) {

		Timeline circleAnimation = new Timeline();
		circleAnimation.setCycleCount(1);
		KeyFrame k = new KeyFrame(Duration.seconds(2),
				new KeyValue(circle.translateYProperty(), circle.getTranslateY() + 300));
		circleAnimation.getKeyFrames().add(k);
		circleAnimation.play();

	}

	public void timelineCircleBounce(ActionEvent event) {

		Timeline circleAnimation = new Timeline();
		circleAnimation.setCycleCount(2);
		KeyFrame k = new KeyFrame(Duration.seconds(2),
				new KeyValue(circle.translateYProperty(), circle.getTranslateY() - 300));
		circleAnimation.getKeyFrames().add(k);
		circleAnimation.setAutoReverse(true);
		circleAnimation.play();

	}

	public void timelineCircleBounceInfinite(ActionEvent event) {

		Timeline circleAnimation = new Timeline();
		circleAnimation.setCycleCount(Animation.INDEFINITE);
		KeyFrame k = new KeyFrame(Duration.seconds(2),
				new KeyValue(circle.translateYProperty(), circle.getTranslateY() - 300));
		circleAnimation.getKeyFrames().add(k);
		circleAnimation.setAutoReverse(true);
		circleAnimation.play();

	}
}
