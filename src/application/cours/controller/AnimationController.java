package application.cours.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.cours.model.ButtonsAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class AnimationController extends Controller {

	@FXML
	private Text text1;
	@FXML
	private Text text2;
	@FXML
	private Text text3;
	@FXML
	private Text text4;
	@FXML
	private ImageView img1;
	@FXML
	private ImageView img2;
	@FXML
	private ImageView img3;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		text1.setVisible(false);
		text2.setVisible(false);
		text3.setVisible(false);
		text4.setVisible(false);
		img1.setVisible(false);
		img2.setVisible(false);
		img3.setVisible(false);
	}

	@Override
	public void avancementSlide(MouseEvent event) {
		switch (state) {
		case UN:
			text1.setVisible(true);
			state = StateSlide.DEUX;
			break;
		case DEUX:
			text2.setVisible(true);
			img1.setVisible(true);
			state = StateSlide.TROIS;
			break;
		case TROIS:
			text3.setVisible(true);
			img2.setVisible(true);
			state = StateSlide.QUATRE;
			break;
		case QUATRE:
			text4.setVisible(true);
			img3.setVisible(true);
			break;
		default:
			break;
		}
	}

	@Override
	public void changeSlide(ActionEvent event) {
		System.out.println(((Button) event.getSource()).getAccessibleText());
		ButtonsAction action = new ButtonsAction();
		action.exec(((Button) event.getSource()));
	}
}
