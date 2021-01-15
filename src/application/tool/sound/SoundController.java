package application.tool.sound;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import application.tool.Return;
import application.tool.returnAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class SoundController implements returnAction, Initializable {

	// liaison des Nodes avec les variables grace au fx:id

	@FXML
	private Button retour;
	@FXML
	private Slider vSliderVolume = new Slider(0, 100, MusicLauncher.getVolume());
	@FXML
	private Label vValeurVolume = new Label();

	@Override
	public void clicRetour(ActionEvent event) {
		System.out.println("test : " + ((Button) event.getSource()).getText());
		Return action = new Return();
		MusicLauncher.stop();
		action.exec(((Button) event.getSource()));
	}

	@FXML
	public void onSliderChanged() {

		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);

		double valueSound = vSliderVolume.getValue() * 0.01;
		String valueSoundString = f.format(valueSound);

		System.out.println("Test : " + valueSoundString);
		vValeurVolume.setText((int) vSliderVolume.getValue() + " %");
		MusicLauncher.setVolume(valueSound);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		MusicLauncher.music("dix");
	}
}
