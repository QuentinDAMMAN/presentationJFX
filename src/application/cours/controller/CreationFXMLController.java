package application.cours.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CreationFXMLController extends Controller {

	@FXML
	private ImageView image1;
	@FXML
	private ImageView image2;
	@FXML
	private ImageView image3;
	@FXML
	private ImageView image4;
	@FXML
	private Button precedent;
	@FXML
	private Button suivant;
	@FXML
	private Button retour;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		image1.setVisible(false);
		image2.setVisible(false);
		image3.setVisible(false);
		image4.setVisible(false);

		state = StateSlide.UN;
	}

	public void avancementSlide(MouseEvent event) {
		switch (state) {
		case UN:
			image1.setVisible(true);
			state = StateSlide.DEUX;
			break;
		case DEUX:
			image1.setVisible(false);
			image2.setVisible(true);
			state = StateSlide.TROIS;
			break;
		case TROIS:
			image2.setVisible(false);
			image3.setVisible(true);
			state = StateSlide.QUATRE;
			break;
		case QUATRE:
			image3.setVisible(false);
			image4.setVisible(true);
			break;
		}
	}

}
