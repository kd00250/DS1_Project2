package edu.westga.dsdm.mondrianart.model;

import javafx.scene.paint.Color;

/**
 * stores the region on the canvas.
 * @param x the x-coordinate of the top left corner
 * @param y the y-coordinate of the top left corner
 * @param width the width
 * @param height the height
 * @param color the color
 */
public record Region(double x, double y, int width, int height, Color color) {
    /**
     * the max width of the canvas.
     */
    public static final int MAX_WIDTH = 600;

    /**
     * the max length of the canvas.
     */
    public static final int MAX_LENGTH = 600;
}

