package com.example.drawer;



import com.example.drawer.paint.Drawer;
import com.example.drawer.paint.forms.Hall;
import com.example.drawer.paint.forms.Table;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.UUID;

/**
 * Запускатель рисователя столов
 */
//TODO написать для него ТОDО, потому что в момент написания этого - было лень
    //это ты зря кнш сразу не сделал теперь хер поймёшь че тут вообще происходит
public class GraphicEditor extends Application {

    public static void main(String [] args){
        launch(args);
    }

    @FXML
    private Canvas drawerCan;


    @Override
    public void start(Stage stage) throws IOException {



        stage.setTitle("Drawing Operations Test");

        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("editor.fxml"));



        drawerCan = new Canvas();
        //Canvas canvas = new Canvas();

        GraphicsContext gc = drawerCan.getGraphicsContext2D();
        //root.getChildren().add(drawerCan);
        //Scene scene = new Scene(root);

        Scene scene = new Scene(fxmlLoader.load(), 800, 500);

        Hall floor = new Hall(900,600, Color.LIGHTGRAY);

        Drawer.drawHall(gc, floor);

        scene.setOnMouseClicked(mouseEvent -> Drawer.drawTable(gc, floor, new Table(mouseEvent.getX(), mouseEvent.getY(), 30, 60)));

        stage.setScene(scene);
        stage.show();
    }



}
