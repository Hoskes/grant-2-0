package com.example.grant20.models;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MyAlert {
    private Alert alert;
    public MyAlert(String alertText){
        alert = new Alert(Alert.AlertType.CONFIRMATION, alertText+"?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

    }
    public ButtonType getAlert(){
        return alert.getResult();
    }
}
