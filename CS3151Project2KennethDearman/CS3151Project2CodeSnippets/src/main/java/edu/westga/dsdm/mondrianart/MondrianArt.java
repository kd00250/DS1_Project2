package edu.westga.dsdm.mondrianart;

import edu.westga.dsdm.mondrianart.util.DemoDialog;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This class demonstrates the use of a dialog to get user input and
 * a method to create graphics on a canvas.
 *
 * @author CS3151
 */
public class MondrianArt extends Application {
    /**
     * The width of the application window.
     */
    public static final int WIDTH = 600;

    /**
     * The height of the application window.
     */
    public static final int HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) {
        try {
            DemoDialog dialog = new DemoDialog();
            dialog.display();

            Canvas canvas = new Canvas(600, 600);
            GraphicsContext context = canvas.getGraphicsContext2D();
            this.createGraphics(context);

            Group group = new Group();
            group.getChildren().add(canvas);
            Scene scene = new Scene(new BorderPane(group), WIDTH, HEIGHT);
            primaryStage.setTitle("Mondrian Art by Kenneth Dearman");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception exc) {
            System.err.print("An error occurred while starting the application.");
        }
    }

    /**
     * Example code creating a collection of rectangles.
     *
     * @param context the graphics context
     */
    private void createGraphics(GraphicsContext context) {
        context.setFill(Color.BLUE);
        context.fillRect(0, 0, 300, 600);

        context.setFill(Color.color(0.9, 0.3, 0));
        context.fillRect(300, 0, 300, 300);

        context.setFill(Color.YELLOW);
        context.fillRect(300, 300, 300, 300);

        context.setStroke(Color.BLACK);
        context.setLineWidth(4);
        context.strokeLine(298, 0, 298, 600);

        context.setStroke(Color.GREEN);
        context.setLineWidth(4);
        context.strokeLine(302, 300, 600, 300);
    }
}
