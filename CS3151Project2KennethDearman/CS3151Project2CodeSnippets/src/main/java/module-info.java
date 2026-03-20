module edu.westga.dsdm.mondrianart {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens edu.westga.dsdm.mondrianart to javafx.fxml;
    exports edu.westga.dsdm.mondrianart;
}