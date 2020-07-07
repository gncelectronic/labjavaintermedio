package org.utnfrm.ejemplo.ejemplo2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 * Esta es una version con javafx y funciones lambda
 * @author Gaston
 *
 */
public class NumerosConHilos extends Application {

	private boolean go;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button botonStart = new Button("Start");
		Button botonStop = new Button("Stop");

		botonStart.setOnAction(e -> {
			go = true;
			// Creo un hilo separado
			Thread thread1 = new Thread(() -> {
				int count = 0;
				while (go) {
					System.out.print(count);

					count++;
					if (count > 9) {
						count = 0;
						System.out.println();
					}
				}

			});
			thread1.start();

		});

		botonStop.setOnAction(e -> go = false);

		HBox root = new HBox(10);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(botonStart, botonStop);
		Scene scene = new Scene(root, 250, 100);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Numeros con hilos");
		primaryStage.show();

	}

}
