package edu.guilford;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


// IndivdiualPane is a class that extends one of the Pane classes
public class IndividualPane extends GridPane {
    // Could have GridPane, TilePane, StackPane, Pane, BorderPane, and others
    // These organize the components we want to display in different ways

    // Three String attributes for the individual's name, email, and phone
    // private String name;
    // private String email;
    // private String phone;

    // Individual attribute
    private Individual individual;

    // add a textfield attribute for the name
    // add a textfield attribute for the email
    // add a textfield attribute for the phone

    private TextField nameField;
    private TextField emailField;
    private TextField phoneField;

    // add a submit button attribute
    private Button submitButton;

    // three Label attributes for the name, email, and phone
    private Label nameLabel;
    private Label emailLabel;
    private Label phoneLabel;

    // Step 1: Declare an ImageView attribute
    private ImageView avatarView;

    // Declare a Slider attribute to manipulate the background color
    private Slider colorSlider;


    // Constructor
    public IndividualPane(Individual individual) {
        // Set the individual attribute to the individual parameter
        this.individual = individual;

        // instantiate the submit button
        submitButton = new Button("Submit");

        // Step 2: Instantiate the ImageView attribute with the image we want to display
        // Get the path of the file that contains the image
        File avatar = new File(this.getClass().getResource("Whitnell_PP_avatar_small.png")
        .getPath());
        System.out.println("file:" + avatar.getPath());

        // URI stands for Uniform Resource Identifier and it's similar to a URL
        avatarView = new ImageView("file:" + avatar.getPath());

        // instantiate textfield attributes
        nameField = new TextField();
        emailField = new TextField();
        phoneField = new TextField();

        // instantiate label attributes
        nameLabel = new Label("Name: " + individual.getName());
        emailLabel = new Label("Email: " + individual.getEmail());
        phoneLabel = new Label("Phone: " + individual.getPhone());

        // Add a label to the pane
        this.add(nameLabel, 0, 0);
        // Add a label to the pane
        this.add(emailLabel, 0, 1);
        // Add a label to the pane
        this.add(phoneLabel, 0, 2);
        // Add nameField to the pane next to the name label
        this.add(nameField, 1, 0);
        // Add emailField to the pane next to the email label
        this.add(emailField, 1, 1);
        // Add phoneField to the pane next to the phone label
        this.add(phoneField, 1, 2);
        // Add the submit button to the pane
        this.add(submitButton, 0, 3);

        // Step 3: Add the ImageView to the pane to the right of the textfields
        this.add(avatarView, 2, 0, 1, 4);

        // We can change the image to be of a different size
        avatarView.setFitHeight(100);
        // And preserve the aspect ratio (the ratio of width to height)
        avatarView.setPreserveRatio(true);
        // Rotate it by 45 degrees
        avatarView.setRotate(45);


        // Give the pane a border
        this.setStyle("-fx-border-color: black");
        // make the border thicker
        this.setStyle("-fx-border-width: 10px");
        // and a background color
        this.setStyle("-fx-background-color: pink");

        // Add a listener for the button that changes the labels
        submitButton.setOnAction(e -> {
            // Set the name label to the name field's text
            nameLabel.setText("Name: " + nameField.getText());
            // Set the email label to the email field's text
            emailLabel.setText("Email: " + emailField.getText());
            // Set the phone label to the phone field's text
            phoneLabel.setText("Phone: " + phoneField.getText());
            // update the individual attribute with the new data
            individual.setName(nameField.getText());
            individual.setEmail(emailField.getText());
            individual.setPhone(phoneField.getText());
            System.out.println(e.toString());
        });

        // Steps 4 and 5: Write an event listener and connect it to the component
        // that triggers the event
        // rotate the image by 180 degrees when the mouse is clicked on it
        avatarView.setOnMouseClicked(e -> {
            avatarView.setRotate(180);
        });





    }

}
