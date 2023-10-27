package com.example.grant20.controllers;

import com.example.grant20.HelloApplication;
import com.example.grant20.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ComplexController {
    User profile;

    @FXML
    private Button changeComplexButton;

    @FXML
    private Button createComplexButton;

    @FXML
    private Button deleteComplexButton;

    @FXML
    private ChoiceBox<?> filterCity;

    @FXML
    private Label filterCityLabel;

    @FXML
    private ChoiceBox<?> filterStatus;

    @FXML
    private Label filterStatusLabel;

    @FXML
    private Button filterTableButton;

    @FXML
    private Button goBackButton;

    @FXML
    void changeComplex(ActionEvent event) {

    }

    @FXML
    void createComplex(ActionEvent event) {

    }

    @FXML
    void deleteComplex(ActionEvent event) {

    }

    @FXML
    void filterTable(ActionEvent event) {

    }
    @FXML
    void goToMainPage(ActionEvent event) {
        HelloApplication.changeMainPage("main.fxml",new MainController(profile));
    }
    public ComplexController(User user){
        profile=user;
    }
}
