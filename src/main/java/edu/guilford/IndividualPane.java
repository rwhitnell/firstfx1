package edu.guilford;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    // Individual attribute to represent the displayed individual
    private ArrayList<Individual> individuals;

    // Keep track of the current individual
    private int currentIndividual = 0;

    // add a textfield attribute for the name
    // add a textfield attribute for the email
    // add a textfield attribute for the phone

    private TextField nameField;
    private TextField emailField;
    private TextField phoneField;

    // add a submit button attribute
    private Button submitButton;

    // add a button to create a new Individual
    private Button addButton;

    // add a button to go to the next Individual and the previous Individual
    private Button nextButton;
    private Button previousButton;

    // add a sort button
    private Button sortButton;

    // three Label attributes for the name, email, and phone
    private Label nameLabel;
    private Label emailLabel;
    private Label phoneLabel;

    // Step 1: Declare an ImageView attribute
    private ImageView avatarView;

    // Declare a Slider attribute to manipulate the background color
    private Slider colorSlider;

    // Constructor
    public IndividualPane(ArrayList<Individual> individuals) {
        // Set the individual attribute to the individual parameter
        this.individuals = individuals;

        // instantiate the submit button
        submitButton = new Button("Change");

        // instantiate the add button
        addButton = new Button("Add");

        // Add two buttons that go forward and backward through the list
        nextButton = new Button("Next");
        previousButton = new Button("Previous");

        // Add a button to sort the list
        sortButton = new Button("Sort");

        // instantiate the color slider and add it to the pane with tickmarks
        colorSlider = new Slider(0, 255, 50);
        colorSlider.setShowTickMarks(true);
        colorSlider.setShowTickLabels(true);
        colorSlider.setMajorTickUnit(50);
        colorSlider.setMinorTickCount(5);
        colorSlider.setBlockIncrement(10);

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
        Individual individual = this.individuals.get(currentIndividual);
        nameLabel = new Label("Name: " + individual.getName());
        emailLabel = new Label("Email: " + individual.getEmail());
        phoneLabel = new Label("Phone: " + individual.getPhone());

        // Instantiate the previous and next buttons
        previousButton = new Button("Previous");
        nextButton = new Button("Next");

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
        // Add the add button to the pane
        this.add(addButton, 1, 3);

        // Add the color slider to the pane in a new row that spans the entire grid
        this.add(colorSlider, 0, 6, 2, 1);

        // Add the previous and next buttons to row 4 of the pane
        this.add(previousButton, 0, 4);
        this.add(nextButton, 1, 4);

        // Add the sort button to row 5 of the pane, spanning the row
        this.add(sortButton, 0, 5, 2, 1);

        // Step 3: Add the ImageView to the pane to the right of the textfields
        this.add(avatarView, 2, 0, 1, 4);

        // We can change the image to be of a different size
        avatarView.setFitHeight(100);
        // And preserve the aspect ratio (the ratio of width to height)
        avatarView.setPreserveRatio(true);

        // Give the pane a border
        this.setStyle("-fx-border-color: black");
        // make the border thicker
        this.setStyle("-fx-border-width: 10px");
        // and a background color
        this.setStyle("-fx-background-color: hsb(50, 100%, 100%)");

        // Add a listener for the button that changes the labels
        submitButton.setOnAction(e -> {
            Individual current = this.individuals.get(currentIndividual);
            // Set the name label to the name field's text
            nameLabel.setText("Name: " + nameField.getText());
            // Set the email label to the email field's text
            emailLabel.setText("Email: " + emailField.getText());
            // Set the phone label to the phone field's text
            phoneLabel.setText("Phone: " + phoneField.getText());
            // update the individual attribute with the new data
            FullName newName = splitNameField();
            current.setName(newName);
            current.setEmail(emailField.getText());
            current.setPhone(phoneField.getText());

        });

        // Add a listener for the color slider
        colorSlider.valueProperty().addListener(e -> {
            // Get the value of the slider
            double value = colorSlider.getValue();
            // Set the background color of the pane to the value of the slider using the hsb
            // color model
            this.setStyle("-fx-background-color: hsb(" + value + ", 100%, 100%)");
            // change the color of the label text so it's visible when the background is
            // dark
            nameLabel.setStyle("-fx-text-fill: hsb(" + (value + 180) % 360 + ", 100%, 100%)");
            emailLabel.setStyle("-fx-text-fill: hsb(" + (value + 180) % 360 + ", 100%, 100%)");
            phoneLabel.setStyle("-fx-text-fill: hsb(" + (value + 180) % 360 + ", 100%, 100%)");
            // do the same for the slider text
            colorSlider.setStyle("-fx-text-fill: hsb(" + (value + 180) % 360 + ", 100%, 100%)");

        });

        // Add a listener that works for both the previous and next buttons to call the
        // method
        // adjustCurrentIndividual
        EventHandler<ActionEvent> adjustIndividual = e -> {
            // Get the source of the event
            Button source = (Button) e.getSource();
            // If the source is the next button
            if (source == nextButton) {
                // increment the current individual
                currentIndividual++;
                // if the current individual is greater than the size of the list
                if (currentIndividual >= this.individuals.size()) {
                    // disable nextButton
                    nextButton.setDisable(true);
                    currentIndividual = this.individuals.size() - 1;
                }
            } else {
                // decrement the current individual
                currentIndividual--;
                // if the current individual is less than 0
                if (currentIndividual < 0) {
                    // disable previousButton
                    previousButton.setDisable(true);
                    currentIndividual = 0;
                }
            }
            // enable the next and previous buttons based on the value of currentIndividual
            nextButton.setDisable(currentIndividual >= this.individuals.size() - 1);
            previousButton.setDisable(currentIndividual < 1);
            // update the labels with the new individual's data
            Individual current = this.individuals.get(currentIndividual);
            nameLabel.setText("Name: " + current.getName());
            emailLabel.setText("Email: " + current.getEmail());
            phoneLabel.setText("Phone: " + current.getPhone());

            // and do the same for the textfields
            nameField.setText(current.getName().toString());
            emailField.setText(current.getEmail());
            phoneField.setText(current.getPhone());
        };

        // Add a listener for the sort button
        sortButton.setOnAction(e -> {
            // Sort the list of individuals
            Collections.sort(this.individuals);
            // Set the current individual to the first individual in the list
            currentIndividual = 0;
            // Update the labels with the new individual's data
            Individual current = this.individuals.get(currentIndividual);
            nameLabel.setText("Name: " + current.getName());
            emailLabel.setText("Email: " + current.getEmail());
            phoneLabel.setText("Phone: " + current.getPhone());

            // and do the same for the textfields
            nameField.setText(current.getName().toString());
            emailField.setText(current.getEmail());
            phoneField.setText(current.getPhone());
        });

        // Attach the listener to both the next and previous buttons
        nextButton.setOnAction(adjustIndividual);
        previousButton.setOnAction(adjustIndividual);

        // Add a listener for the add button
        addButton.setOnAction(e -> {
            // Create a new individual with the data from the textfields
            Individual newIndividual = new Individual(splitNameField(), 
            emailField.getText(), phoneField.getText());
            // Add the individual to the list
            this.individuals.add(newIndividual);
            // Set the current individual to the new individual
            currentIndividual = this.individuals.size() - 1;
            // Update the labels with the new individual's data
            nameLabel.setText("Name: " + newIndividual.getName());
            emailLabel.setText("Email: " + newIndividual.getEmail());
            phoneLabel.setText("Phone: " + newIndividual.getPhone());
        });

        // Steps 4 and 5: Write an event listener and connect it to the component
        // that triggers the event
        // rotate the image by 180 degrees when the mouse is clicked on it
        avatarView.setOnMouseClicked(e -> {
            avatarView.setRotate(avatarView.getRotate() + 45);
        });
    }

    private FullName splitNameField() {
        String[] nameParts = nameField.getText().split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1];
        return new FullName(firstName, lastName);
    }

}
