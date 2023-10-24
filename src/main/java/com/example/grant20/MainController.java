package com.example.grant20;

import com.example.grant20.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
    private User profile;

    public User getProfile() {
        return profile;
    }

    public void setProfile(User profile) {
        this.profile = profile;
    }

    @FXML
    private Button appartmentButton;

    @FXML
    private Button complexButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button housesButton;

    @FXML
    private Button reportButton;

    @FXML
    void toComplex(ActionEvent event) {
        HelloApplication.changeMainPage("complexes.fxml");
    }

    @FXML
    void toFlats(ActionEvent event) {
        HelloApplication.changeMainPage("apartments.fxml");
    }

    @FXML
    void toHouses(ActionEvent event) {
        HelloApplication.changeMainPage("apartments.fxml");
    }

    @FXML
    void toReport(ActionEvent event) {
        HelloApplication.changeMainPage("report.fxml");

    }

    @FXML
    void toWelcome(ActionEvent event) {
        HelloApplication.changeMainPage("hello-view.fxml");
    }


}

