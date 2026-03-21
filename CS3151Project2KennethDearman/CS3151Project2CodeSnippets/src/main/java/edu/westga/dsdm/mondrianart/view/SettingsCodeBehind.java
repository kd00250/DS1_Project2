package edu.westga.dsdm.mondrianart.view;

import edu.westga.dsdm.mondrianart.viewmodel.SettingsViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * the settings view class.
 */
public class SettingsCodeBehind {

    @FXML
    private Button generateArtButton;

    @FXML
    private TextField lengthTextField;

    private SettingsViewModel vm;
    private MondrianArtView artView;

    @FXML
    void generateArt(ActionEvent event) {
        try {
            this.vm.getRegions();
            this.showArtView();
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please reenter the desired minimum length and try again");
            ex.printStackTrace();
            alert.showAndWait();
        }
    }

    private void showArtView() {
        try {
            // Load the art view FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MondrianArt.fxml"));
            Parent root = loader.load();

            // Get the controller for art view
            this.artView = loader.getController();

            // Pass the regions to draw
            this.artView.drawRegions(this.vm.getRegions());

            // Create and show new window
            Stage artStage = new Stage();
            //artStage.setTitle("Mondrian Art");
            artStage.setScene(new Scene(root));
            artStage.show();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Could not load art view: " + e.getMessage());
            e.printStackTrace();
            alert.showAndWait();
        }
    }

    private void setUpControls() {
        this.generateArtButton.disableProperty().bind(this.lengthTextField.textProperty().isEmpty());
        this.vm.getMinLength().bind(this.lengthTextField.textProperty());
    }

    private void setUpListeners() {
        this.lengthTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,3}")) {
                this.lengthTextField.setText(oldValue);
            }
        });
    }

    @FXML
    void initialize() {
        this.vm = new SettingsViewModel();
        this.artView = new MondrianArtView();
        this.setUpControls();
        this.setUpListeners();

    }
}
