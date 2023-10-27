package com.example.grant20.controllers;

import com.example.grant20.HelloApplication;
import com.example.grant20.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ReportController {
    User profile;
    @FXML
    private Label ThisISCommentDeleteLater;

    @FXML
    private TextField areaCost;

    @FXML
    private TextField baseCost;

    @FXML
    private Label coefLabel;

    @FXML
    private Label coefLabel1;

    @FXML
    private Label coefLabel2;

    @FXML
    private Label coefLabel3;

    @FXML
    private Button createReportButton;

    @FXML
    private ChoiceBox<?> filterComplexes;

    @FXML
    private ChoiceBox<?> filterHouses;

    @FXML
    private Label finalLabel1;

    @FXML
    private Label finalLabel2;

    @FXML
    private Label finalLabel3;

    @FXML
    private Label finalLabel4;

    @FXML
    private Label finalLabel41;

    @FXML
    private Button goBackButton;

    @FXML
    private Label labelComplexesFilter;

    @FXML
    private Label labelHousesFilter;

    @FXML
    private TextField roomsCost;

    @FXML
    private Label summCompanyIncome;

    @FXML
    private Label summConstructionCost;

    @FXML
    private Label summEstimatedCost;

    @FXML
    private Label summEstimatedCostNotSold;

    @FXML
    private Label summEstimatedCostSold;

    @FXML
    void createReport(ActionEvent event) {

    }

    @FXML
    void enterAreaCost(ActionEvent event) {

    }

    @FXML
    void enterBaseCost(ActionEvent event) {

    }

    @FXML
    void enterRoomsCost(ActionEvent event) {

    }

    @FXML
    void goToMainPage(ActionEvent event) {
        HelloApplication.changeMainPage("main.fxml",new MainController(profile));
    }
    public ReportController(User user){
        profile=user;
    }
}
