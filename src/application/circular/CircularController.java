package application.circular;

import java.net.URL;
import java.util.ResourceBundle;

import application.tool.Return;
import application.tool.returnAction;
import application.tool.sound.MusicLauncher;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class CircularController implements Initializable, returnAction {

	@FXML
	private Circle c1;
	@FXML
	private Circle c2;
	@FXML
	private Circle c3;
	@FXML
	private Button play;
	@FXML
	private Button retour;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	private void play(ActionEvent event) {
		setRotate(c1, true, 360, 10);
		setRotate(c2, true, 180, 18);
		setRotate(c3, true, 145, 24);

	}

	private void setRotate(Circle c, Boolean reverse, int angle, int duration) {

		RotateTransition rt = new RotateTransition(Duration.seconds(duration), c);

		rt.setAutoReverse(reverse);

		rt.setByAngle(angle);
		rt.setDelay(Duration.seconds(0));
		rt.setRate(3);
		rt.setCycleCount(18);
		rt.play();
	}

	@Override
	public void clicRetour(ActionEvent event) {
		System.out.println("test : " + ((Button) event.getSource()).getText());
		Return action = new Return();
		MusicLauncher.stop();
		action.exec(((Button) event.getSource()));
	}

}
