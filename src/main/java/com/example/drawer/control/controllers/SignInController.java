package com.example.drawer.control.controllers;

import com.example.drawer.api.TalkerPost;
import com.example.drawer.control.logic.SignIn;
import com.example.drawer.paint.Drawer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

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

    public void onSignInButtonClick() throws IOException, ParseException {
        String isAccepted = SignIn.jsonSign(loginField.getText(),passwordField.getText());

        if(isAccepted.equals("true")){
            //FXMLLoader fxmlLoader = new FXMLLoader(SignInController.class.getResource("mainMenu.fxml"));
            //Scene scene = new Scene(fxmlLoader.load(), 876, 451);
            //Stage pr = (Stage) signInButton.getScene().getWindow();
            //pr.setScene(scene);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Congratulations! Теперь ты XBOX");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle(isAccepted);
            alert.setHeaderText(null);
            alert.setContentText("");

            alert.showAndWait();
        }
    }
}
