package application.animation;

import java.net.URL;
import java.util.ResourceBundle;

import application.tool.Return;
import application.tool.returnAction;
import application.tool.sound.MusicLauncher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AnimationController implements Initializable, returnAction {
	@FXML
	private Button race;
	@FXML
	private Button circular;
	@FXML
	private Button retour;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void clic(ActionEvent event) {
		System.out.println("test : " + ((Button) event.getSource()).getText());
		ActionAnimation action = new ActionAnimation();
		MusicLauncher.stop();
		action.exec(((Button) event.getSource()));
	}

	@Override
	public void clicRetour(ActionEvent event) {
		System.out.println("test : " + ((Button) event.getSource()).getText());
		Return action = new Return();
		MusicLauncher.stop();
		action.exec(((Button) event.getSource()));
	}

}
