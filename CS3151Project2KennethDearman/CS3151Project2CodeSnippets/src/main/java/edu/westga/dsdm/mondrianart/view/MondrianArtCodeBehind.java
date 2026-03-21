package edu.westga.dsdm.mondrianart.view;

import edu.westga.dsdm.mondrianart.model.Region;
import edu.westga.dsdm.mondrianart.viewmodel.MondrianArtViewModel;
import edu.westga.dsdm.mondrianart.viewmodel.SettingsViewModel;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * mondrian art view class.
 */
public class MondrianArtCodeBehind {

    @FXML
    private Canvas artCanvas;

    private SettingsViewModel viewModel;

    void drawRegions(List<Region> regions) {
        if (this.artCanvas == null || regions == null) {
            return;
        }

        GraphicsContext gc = this.artCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, this.artCanvas.getWidth(), this.artCanvas.getHeight());

        for (Region region : regions) {
            // Fill region with its color
            gc.setFill(region.color());
            gc.fillRect(region.x(), region.y(), region.width(), region.height());

            // Draw black border for divider lines
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(4);
            gc.strokeRect(region.x(), region.y(), region.width(), region.height());
        }
    }

    public void setViewModel(SettingsViewModel viewModel) {
        this.viewModel = viewModel;
        this.drawRegions(this.viewModel.getRegions());
    }
}
