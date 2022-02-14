module com.example.drawer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires json.simple;
    requires com.google.gson;


    opens com.example.drawer to javafx.fxml;
    exports com.example.drawer;
    exports com.example.drawer.api to com.google.gson;
    exports com.example.drawer.control.logic;
    opens com.example.drawer.control.logic to javafx.fxml;
    exports com.example.drawer.paint.forms;
    opens com.example.drawer.paint.forms to javafx.fxml;
    exports com.example.drawer.paint;
    opens com.example.drawer.paint to javafx.fxml;
    exports com.example.drawer.control.controllers;
    opens com.example.drawer.control.controllers to javafx.fxml;
}