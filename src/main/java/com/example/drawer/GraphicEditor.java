package com.example.drawer;


import com.example.drawer.paint.Drawer;
import com.example.drawer.paint.forms.Hall;
import com.example.drawer.paint.forms.Table;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Запускатель рисователя столов
 */
//TODO написать для него ТОDО, потому что в момент написания этого - было лень
public class GraphicEditor extends Application {

    public static void main(String [] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Drawing Operations Test");

        Group root = new Group();
        Canvas canvas = new Canvas(900,600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);

        Hall floor = new Hall(900,600, Color.LIGHTGRAY);

        Drawer.drawHall(gc, floor);

        scene.setOnMouseClicked(mouseEvent -> Drawer.drawTable(gc, floor, new Table(mouseEvent.getX(), mouseEvent.getY(), 30, 60)));

        stage.setScene(scene);
        stage.show();
    }










}
