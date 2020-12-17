package application.race.model;

import application.race.controller.CourseController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Countdown {
	private final int startTimer = 5;
	private Timeline timeline;
	private CourseController raceCtrl;

	@FXML
	private Label countdown;

	public Countdown(Label pCountdown, CourseController pRaceCtrl) {
		this.countdown = pCountdown;
		this.countdown.setText(startTimer + "");
		this.raceCtrl = pRaceCtrl;
	}

	public void start() {
		Integer timer = startTimer - 1;
		timeline = new Timeline();
		for (int i = 1; i < 5; i++) {
			KeyFrame k4 = new KeyFrame(Duration.seconds(i), new KeyValue(countdown.textProperty(), timer.toString()));
			timeline.getKeyFrames().add(k4);
			timer--;
		}
		KeyFrame k = new KeyFrame(Duration.seconds(5), new KeyValue(countdown.textProperty(), "GO!"));
		timeline.getKeyFrames().add(k);
		timeline.playFromStart();
		timeline.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				countdown.setText("");
				raceCtrl.startRace();
			}
		});
	}
}
