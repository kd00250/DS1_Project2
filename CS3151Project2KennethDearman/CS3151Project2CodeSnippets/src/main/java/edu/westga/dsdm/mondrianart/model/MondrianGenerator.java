package edu.westga.dsdm.mondrianart.model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * the mondrian generator class.
 */
public class MondrianGenerator {
    private static final int LINE_SIZE = 4;
    private static final int NUMBER_OF_REGIONS_SPLIT = 2;
    private Random random;

    /**
     * creates a new instance of mondrian generator.
     */
    public MondrianGenerator() {
        this.random = new Random();
    }

    /**
     * generates the regions for the mondrian art.
     *
     * @param minLength the length
     * @return the list of regions to be painted on the convas
     */
    public List<Region> generateRegions(int minLength) {
        List<Region> regions = new ArrayList<>();

        Region startRegion = new Region(0, 0, 600, 600, null);
        this.splitRegion(startRegion, minLength, regions);
        return regions;
    }

    public void splitRegion(Region region, int minLength, List<Region> regions) {
        boolean canSplitHorizontally = region.height() > (2 * minLength + 4);
        boolean canSplitVertically = region.width() > (2 * minLength + 4);

        if (!canSplitHorizontally && !canSplitVertically) {
            Color color = this.generateColor();
            Region baseRegion = new Region(region.x(), region.y(), region.width(), region.height(), color);
            regions.add(baseRegion);
        }

        int split = this.random.nextInt(3);
        if ((split == 0 || split == 2) && canSplitHorizontally) {
            int splitY = minLength + this.random.nextInt(region.height() - (NUMBER_OF_REGIONS_SPLIT * minLength + LINE_SIZE));
            Region topRegion = new Region(region.x(), region.y(), region.width(), splitY, null);
            Region bottomRegion = new Region(region.x(), region.y() + splitY + LINE_SIZE, region.width(), region.height() - splitY - LINE_SIZE, null);
            this.splitRegion(topRegion, minLength, regions);
            this.splitRegion(bottomRegion, minLength, regions);
        }

        if ((split == 1 || split == 2) && canSplitVertically) {
            int splitX = minLength + this.random.nextInt(region.width() - (NUMBER_OF_REGIONS_SPLIT * minLength + LINE_SIZE));
            Region leftRegion = new Region(region.x(), region.y(), splitX, region.height(), null);
            Region rightRegion = new Region(region.x() + splitX + LINE_SIZE, region.y(), region.width() - splitX - LINE_SIZE, region.height(), null);
            this.splitRegion(leftRegion, minLength, regions);
            this.splitRegion(rightRegion, minLength, regions);
        }
    }

    private Color generateColor() {
        int color = this.random.nextInt(3);
        if (color == 0) {
            return Color.RED;
        } else if (color == 1) {
            return Color.BLUE;
        } else {
            return Color.YELLOW;
        }
    }

}
