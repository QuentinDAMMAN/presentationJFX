package application.cours.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class BaseDeSlideController extends Controller {

	@FXML
	private Button retour;
	@FXML
	private Button next;
	@FXML
	private Button previous;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@Override
	public void avancementSlide(MouseEvent event) {

	}

}
