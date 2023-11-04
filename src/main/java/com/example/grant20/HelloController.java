package com.example.grant20;

import com.example.grant20.controllers.profile.AuthController;
import com.example.grant20.models.DB.DBConnect;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        try {
            HelloApplication.changeMainPage("auth.fxml",new AuthController());
            DBConnect.getDBConnect().executeQuery("SELECT * FROM `authentication` WHERE 1");
        } catch (Exception e) {
            System.out.println("AuthCreationPageTrouble");
            throw new RuntimeException(e);
        }
    }
}