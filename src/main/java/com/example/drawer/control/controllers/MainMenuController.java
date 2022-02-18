package com.example.drawer.control.controllers;

import com.example.drawer.Menu;
import com.example.drawer.api.HallInfo;
import com.example.drawer.api.JParse;
import com.example.drawer.api.TalkerGet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;



/**
 * Обеспечивает взаимодействие кнопачек и вьюшечек в главном меню с логикой программы
 * 11.02 - ничерта не обеспечивает и ничего не умеет
 */
public class MainMenuController {

    @FXML
    private Button deleteTableBtn;

    @FXML
    private Button editTableBtn;

    @FXML
    private Button exitBtn;


    @FXML
    private Button loadTableBtn;

    @FXML
    private ImageView tableMapView;

    @FXML
    private ListView<String> tablesList;

    public MainMenuController() throws IOException {

     //   mouseClicked(new MouseEvent());
    }

    @FXML
    void onEditButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("editor.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 250);
        Stage pr = (Stage) exitBtn.getScene().getWindow();
        pr.setScene(scene);
        new EditorController().initialize(pr);
    }
    boolean isAlreadyOneClick;
    public void mouseClicked(MouseEvent mouseEvent) {

        if (isAlreadyOneClick) {
            System.out.println("double click");
            isAlreadyOneClick = false;
        } else {
            isAlreadyOneClick = true;
            Timer t = new Timer("doubleclickTimer", false);
            t.schedule(new TimerTask() {

                @Override
                public void run() {
                    isAlreadyOneClick = false;
                }
            }, 500);
        }
    }
    @FXML
    void onExitBtnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("signin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 250);
        Stage pr = (Stage) exitBtn.getScene().getWindow();
        pr.setScene(scene);
    }

    @FXML
    void onLoadTableBtnClick(ActionEvent event) throws IOException{
        String answer = TalkerGet.getRest(JParse.tokenHolder.token);
        JParse.hallParse(answer);
        ObservableList<String>obs = FXCollections.observableArrayList();
        for(HallInfo h : JParse.hallList){
            obs.add(h.name);
        }
        tablesList.setItems(obs);
    }
    void getHallId(){

    }

}
