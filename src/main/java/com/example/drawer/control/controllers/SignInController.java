package com.example.drawer.control.controllers;

import com.example.drawer.GraphicEditor;
import com.example.drawer.Menu;
import com.example.drawer.api.JParse;
import com.example.drawer.api.TalkerGet;
import com.example.drawer.api.TalkerPost;
import com.example.drawer.control.logic.UserParserToJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
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
        JSONObject userJson = UserParserToJSON.jsonSign(loginField.getText(),passwordField.getText());

        if(TalkerPost.post(userJson)){

            FXMLLoader loader = new FXMLLoader(Menu.class.getResource("mainMenu.fxml"));
            Scene scene = new Scene(loader.load(), 876, 451);
            Stage pr = (Stage) signInButton.getScene().getWindow();
            pr.setScene(scene);

        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setHeaderText(null);
            alert.setContentText("Wrong password or login." + JParse.tokenHolder.statusCode);
            alert.showAndWait();
        }
    }
}
