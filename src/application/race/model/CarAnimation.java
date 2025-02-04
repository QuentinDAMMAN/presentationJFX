package application.race.model;

import java.util.List;

import application.race.controller.CourseController;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class CarAnimation {

	private CourseController courseController;

	public void play(CourseController pCourseController, ImageView[] cars, List<Integer> listeVitesse) {
		this.courseController = pCourseController;
		TranslateTransition[] carTranslations = new TranslateTransition[5]; // création d'un array de transition

		// chaque itération de boucle on ajoute une animation a la première puis
		// deuxième voiture etc..

		for (int i = 0; i < 5; i++) {
			TranslateTransition translation = new TranslateTransition();
			translation.setByX(800);
			translation.setCycleCount(1);
			translation.setDuration(Duration.millis(2000 - (10 * listeVitesse.get(i))));
			translation.setNode(cars[i]);
			carTranslations[i] = translation;
		}

		// on ajoute toutes les animations dans la transition simultanée

		ParallelTransition course = new ParallelTransition(carTranslations[0], carTranslations[1], carTranslations[2],
				carTranslations[3], carTranslations[4]);
		course.setOnFinished(new EventHandler<ActionEvent>() {

			// quand la fonction se fini on affiche un bouton retour

			@Override
			public void handle(ActionEvent arg0) {
				courseController.afficheRetour();
			}
		});

		// on lance toutes les voitures :D
		course.play();
	}
}
