package application.cours.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class NodeController extends Controller {

	@FXML
	private Text text1;
	@FXML
	private Text text2;
	@FXML
	private Text text3;
	@FXML
	private ImageView img1;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		state = StateSlide.UN;
		text1.setVisible(false);
		text2.setVisible(false);
		text3.setVisible(false);
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
			state = StateSlide.TROIS;
			break;
		case TROIS:
			GridPane scene = (GridPane) text1.getParent();
			img1 = new ImageView();
			img1.setImage(new Image(getClass().getResource("/application/assets/nodeAjout.png").toExternalForm()));
			scene.add(img1, 1, 1);
			img1.setLayoutY(100);
			state = StateSlide.QUATRE;
			break;
		case QUATRE:
			text3.setVisible(true);
			break;

		default:
			break;
		}
	}

}
