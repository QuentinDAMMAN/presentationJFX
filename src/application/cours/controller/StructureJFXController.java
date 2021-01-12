package application.cours.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class StructureJFXController extends Controller {

	@FXML
	private Text text1;
	@FXML
	private Group text2;
	@FXML
	private ImageView graph;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		text1.setVisible(false);
		text2.setVisible(false);
		graph.setVisible(false);
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
			graph.setVisible(true);
			state = StateSlide.TROIS;
			break;
		case TROIS:
			text2.setVisible(true);
			break;
		case QUATRE:
			break;
		}
	}

}
