package com.example.drawer.control.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.drawer.Menu;
import com.example.drawer.paint.Drawer;
import com.example.drawer.paint.forms.Hall;
import com.example.drawer.paint.forms.Table;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class EditorController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitBtn;

    @FXML
    private void onExitBtnClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(Menu.class.getResource("mainMenu.fxml"));
        Scene scene = new Scene(loader.load(), 876, 451);
        Stage pr = (Stage) exitBtn.getScene().getWindow();
        pr.setScene(scene);
    }
    @FXML
    private Canvas drawerCan;

    @FXML
    private Group root;

    @FXML
    void draw(MouseEvent mouseEvent){
        ContextMenu cm = new ContextMenu();
        MenuItem mi1 = new MenuItem("Menu 1");
        cm.getItems().add(mi1);
        MenuItem mi2 = new MenuItem("Menu 2");
        cm.getItems().add(mi2);
      //  Node node =

        if(mouseEvent.getButton() == MouseButton.SECONDARY){
          //  cm.show
        } else {
            Drawer.drawTable(drawerCan.getGraphicsContext2D(), floor, new Table(mouseEvent.getX(), mouseEvent.getY(), 30, 60));
        }
       // Drawer.drawTable(drawerCan.getGraphicsContext2D(), floor, new Table(mouseEvent.getX(), mouseEvent.getY(), 30, 60));


    }
    private Hall floor = new Hall(900,600, Color.LIGHTGRAY);
    @FXML
    void initialize(Stage stage) throws IOException {    // Вот здесь проблема, должно работать примерно как у тебя, но работает примерно никак,






        /*stage.setTitle("Drawing Operations Test");       // Последний рабочий вариант лежит в GraphicEditor.java
        System.out.println(drawerCan == null);
        drawerCan  = new Canvas(900,900);
        //drawerCan.autosize();   // Каким-то образом добавление вызова этого метода убирает исключение вызванное значением null у canvas
        System.out.println(drawerCan == null);
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("editor.fxml"));

        //Group root = new Group();

        //Canvas canvas = drawerCan;
        //drawerCan = new Canvas();
        GraphicsContext gc = drawerCan.getGraphicsContext2D();
        //root.getChildren().add(canvas);
        //Scene scene = new Scene(root);

        Scene scene = new Scene(fxmlLoader.load(), 500, 250);

        Hall floor = new Hall(900,600, Color.LIGHTGRAY);

        Drawer.drawHall(gc, floor);


scene.setOnMouseClicked(mouseEvent -> Drawer.drawTable(gc, floor, new Table(mouseEvent.getX(), mouseEvent.getY(), 30, 60)));
        stage.setScene(scene);
        stage.show();*/
    }
}
