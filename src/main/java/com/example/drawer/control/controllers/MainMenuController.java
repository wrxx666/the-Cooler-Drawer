package com.example.drawer.control.controllers;

import com.example.drawer.api.HallInfo;
import com.example.drawer.api.JParse;
import com.example.drawer.api.TalkerGet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import org.json.simple.parser.ParseException;

import java.io.IOException;

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

    @FXML
    void onEditButtonClick(ActionEvent event) {

    }

    @FXML
    void onExitBtnClick(ActionEvent event) {

    }

    @FXML
    void onLoadTableBtnClick(ActionEvent event) throws IOException, ParseException {
        String answer = TalkerGet.getRest(JParse.tokenHolder.token);
        JParse.hallParse(answer);
        ObservableList<String>obs = FXCollections.observableArrayList();
        for(HallInfo h : JParse.hallList){
            obs.add(h.name);
        }
        tablesList.setItems(obs);
    }

}
