package com.example.drawer.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * Обеспечивает взаимодействие окошка логина и логики программы
 * 11.02 Ни черта не умеет
 */
public class SignInController { //TODO Попробовать прикрутить к авторизации дрест апи, шобы ну прям по крутому так

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    private ImageView tableEditorImage;

    @FXML
    void o(ActionEvent event) {

    }

}
