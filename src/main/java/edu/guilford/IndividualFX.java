package edu.guilford;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class IndividualFX extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Instantiate a VBox root node
        VBox root = new VBox();
        // Add a label to the root node
        // root.getChildren().add(new Label("Hello World!"));

       

        // Instantiate an ArrayList of Individual objects
        ArrayList<Individual> individuals = new ArrayList<Individual>();

        // Add 10 random Individual objects to the ArrayList
        for (int i = 0; i < 10; i++) {
            individuals.add(new Individual());
        }
        

        // Instantiate an IndividualPane object and add it to the root node
        root.getChildren().add(new IndividualPane(individuals));
        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}