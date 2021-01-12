package application.cours.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.cours.model.ButtonsAction;
import application.tool.Return;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FxIDtFXMLController extends Controller{

	@FXML
	private ImageView image1;
	@FXML
	private ImageView image2;
	@FXML
	private ImageView image3;
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
			image1.setVisible(false);
			image2.setVisible(false);
			image3.setVisible(true);
			break;
		case QUATRE:
			break;
		}
	}

	public void changeSlide(ActionEvent event) {
		System.out.println(((Button) event.getSource()).getAccessibleText());
		ButtonsAction action = new ButtonsAction();
		action.exec(((Button) event.getSource()));
	}

	public void clicRetour(ActionEvent event) {
		System.out.println("test : " + ((Button) event.getSource()).getText());
		Return action = new Return();
		action.exec(((Button) event.getSource()));
	}

}
