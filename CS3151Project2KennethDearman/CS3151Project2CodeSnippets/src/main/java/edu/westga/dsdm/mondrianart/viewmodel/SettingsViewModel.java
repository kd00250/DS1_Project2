package edu.westga.dsdm.mondrianart.viewmodel;

import edu.westga.dsdm.mondrianart.model.MondrianGenerator;
import edu.westga.dsdm.mondrianart.model.Region;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;

/**
 * the settings view model class.
 */
public class SettingsViewModel {
    private SimpleStringProperty minLength;
    private MondrianGenerator generator;

    /**
     * creates a new settings view model.
     */
    public SettingsViewModel() {
        this.generator = new MondrianGenerator();
        this.minLength = new SimpleStringProperty("");
    }

    /**
     * gets the min length.
     * @return the min length
     */
    public StringProperty getMinLength() {
        return this.minLength;
    }

    /**
     * gets the regions from generating the regions recursively.
     * @return the list of regions that were generated recursively
     */
    public List<Region> getRegions() {
        int min = Integer.parseInt(this.getMinLength().get());
        return this.generator.generateRegions(min);
    }
}
