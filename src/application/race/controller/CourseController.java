package application.race.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class CourseController implements Initializable {
	@FXML
	private ImageView voiture1;
	@FXML
	private ImageView voiture2;
	@FXML
	private ImageView voiture3;
	@FXML
	private ImageView voiture4;
	@FXML
	private ImageView voiture5;
	@FXML
	private Line finishLine;
	@FXML
	private Label decompte;
	private static List<Integer> listeVitesse = LaunchController.getVitesses();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TranslateTransition trans1 = new TranslateTransition();
		trans1.setByX(800);
		trans1.setCycleCount(1);
		trans1.setDuration(Duration.millis(2000 - (10 * listeVitesse.get(0))));
		trans1.setNode(voiture1);
		trans1.play();
		TranslateTransition trans2 = new TranslateTransition();
		trans2.setByX(800);
		trans2.setCycleCount(1);
		trans2.setDuration(Duration.millis(2000 - (10 * listeVitesse.get(1))));
		trans2.setNode(voiture2);
		trans2.play();
		TranslateTransition trans3 = new TranslateTransition();
		trans3.setByX(800);
		trans3.setCycleCount(1);
		trans3.setDuration(Duration.millis(2500 - (10 * listeVitesse.get(2))));
		trans3.setNode(voiture3);
		trans3.play();
		TranslateTransition trans4 = new TranslateTransition();
		trans4.setByX(800);
		trans4.setCycleCount(1);
		trans4.setDuration(Duration.millis(2500 - (10 * listeVitesse.get(3))));
		trans4.setNode(voiture4);
		trans4.play();
		TranslateTransition trans5 = new TranslateTransition();
		trans5.setByX(800);
		trans5.setCycleCount(1);
		trans5.setDuration(Duration.millis(2500 - (10 * listeVitesse.get(4))));
		trans5.setNode(voiture5);
		trans5.play();
	}

}