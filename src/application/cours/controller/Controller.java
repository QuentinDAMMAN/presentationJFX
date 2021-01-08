package application.cours.controller;

import application.cours.model.ButtonsAction;
import application.tool.Return;
import application.tool.returnAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public abstract class Controller implements Initializable, returnAction {

	@FXML
	private Button retour;
	@FXML
	private Button next;
	@FXML
	private Button previous;

	protected enum StateSlide {
		UN, DEUX, TROIS, QUATRE;
	}

	StateSlide state = StateSlide.UN;

	public abstract void avancementSlide(MouseEvent event);

	public void clicRetour(ActionEvent event) {
		System.out.println("test : " + ((Button) event.getSource()).getText());
		Return action = new Return();
		action.exec(((Button) event.getSource()));
	}

	public void changeSlide(ActionEvent event) {
		System.out.println(((Button) event.getSource()).getAccessibleText());
		ButtonsAction action = new ButtonsAction();
		action.exec(((Button) event.getSource()));
	}

}
