package com.example.grant20;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        try {
          HelloApplication.changeMainPage("auth.fxml");
            DBConnect.getDBConnect().execute("SELECT * FROM `authentication` WHERE 1");
        }catch (Exception e){
            System.out.println("AuthCreationPageTrouble");
            throw new RuntimeException(e);
        }
    }
}