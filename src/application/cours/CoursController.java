package application.cours;

import java.net.URL;
import java.util.ResourceBundle;

import application.tool.Return;
import application.tool.returnAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class CoursController implements Initializable, returnAction {

	@FXML
	private Button retour;

	@Override
	public void clicRetour(ActionEvent event) {
		System.out.println("test : " + ((Button) event.getSource()).getText());
		Return action = new Return();
		action.exec(((Button) event.getSource()));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
