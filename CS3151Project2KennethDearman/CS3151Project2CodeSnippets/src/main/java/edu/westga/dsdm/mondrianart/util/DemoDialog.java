package edu.westga.dsdm.mondrianart.util;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

/**
 * A simple dialog to demonstrate how to get user input.
 *
 * @author CS3151
 */
public class DemoDialog {
    Dialog<Pair<String, String>> dialog;
    TextField firstname;
    TextField lastname;
    TextField greeting;

    /**
     * Initializes the dialog with three text fields for first name, last name, and greeting.
     */
    public DemoDialog() {
        this.dialog = new Dialog<>();
        this.dialog.setTitle("Mondrian Art");
        this.dialog.setHeaderText("Enter some settings");

        // set grid with three text fields
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        this.firstname = new TextField();
        grid.add(new Label("First name:"), 0, 0);
        grid.add(this.firstname, 1, 0);

        this.lastname = new TextField();
        grid.add(new Label("Last name:"), 0, 1);
        grid.add(this.lastname, 1, 1);

        this.greeting = new TextField();
        grid.add(new Label("Greeting:"), 0, 2);
        grid.add(this.greeting, 1, 2);

        this.dialog.getDialogPane().setContent(grid);

        // Set the button types
        this.dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
    }

    /**
     * Displays the dialog and prints a greeting to the console.
     */
    public void display() {
        this.dialog.showAndWait();
        System.out.println(this.greeting.getText() + ", " + this.firstname.getText() + " " + this.lastname.getText() + "!");
    }
}
