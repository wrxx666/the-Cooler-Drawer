package com.example.drawer.control.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

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
    private ListView<?> tablesList;

    @FXML
    void onEditButtonClick(ActionEvent event) {

    }

    @FXML
    void onExitBtnClick(ActionEvent event) {

    }

    @FXML
    void onLoadTableBtnClick(ActionEvent event) {

    }

}
