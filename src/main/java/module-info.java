module com.example.drawer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens com.example.drawer to javafx.fxml;
    exports com.example.drawer;
    exports com.example.drawer.forms;
    opens com.example.drawer.forms to javafx.fxml;
}