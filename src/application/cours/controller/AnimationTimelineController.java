package application.cours.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.input.MouseEvent;

public class AnimationTimelineController extends Controller {

//	@FXML
//	private Text text1;
//	@FXML
//	private Text text2;
//	@FXML
//	private Text text3;

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

}
