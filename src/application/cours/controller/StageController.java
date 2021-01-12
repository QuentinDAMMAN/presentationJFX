package application.cours.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class StageController extends Controller {

	@FXML
	private Text text1;
	@FXML
	private Text text2;
	@FXML
	private Text text3;
	@FXML
	private ImageView img1;
	@FXML
	private ImageView img2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		text1.setVisible(false);
		text2.setVisible(false);
		text3.setVisible(false);
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
			img1.setVisible(true);
			text2.setVisible(true);
			state = StateSlide.TROIS;
			break;
		case TROIS:
			img2.setVisible(true);
			text3.setVisible(true);
			break;
		default:
			break;
		}
	}

}
