package application.cours.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.cours.model.ButtonsAction;
import application.tool.Return;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MVCSlideController implements Initializable {

	@FXML
	private VBox vbox;
	@FXML
	private ImageView imgHbox;
	@FXML
	private TextArea text;
	@FXML
	private Button show;
	@FXML
	private Button suivant;
	@FXML
	private Button precedent;
	@FXML
	private Button retour;
	@FXML
	private ImageView codeEclipse;

	private enum StateSlide {
		UN, DEUX, TROIS, QUATRE;
	}

	StateSlide state = StateSlide.UN;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		vbox.setVisible(false);
		imgHbox.setVisible(false);
		text.setVisible(false);
		show.setVisible(false);
		codeEclipse.setVisible(false);
		state = StateSlide.UN;
	}

	public void avancementSlide(MouseEvent event) {
		switch (state) {
		case UN:
			vbox.setVisible(true);
			imgHbox.setVisible(true);
			state = StateSlide.DEUX;
			break;
		case DEUX:
			text.setVisible(true);
			state = StateSlide.TROIS;
			break;
		case TROIS:
			show.setVisible(true);
			break;
		case QUATRE:
			break;
		}
	}

	public void showImageEclipse(ActionEvent event) {
		codeEclipse.setVisible(true);
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
