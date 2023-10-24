package com.example.grant20;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ReportController {

    @FXML
    private TextField addedSum;

    @FXML
    private TableColumn<?, ?> address;

    @FXML
    private TableColumn<?, ?> area;

    @FXML
    private Label coefLabel;

    @FXML
    private Label coefLabel1;

    @FXML
    private Label coefLabel2;

    @FXML
    private Label coefLabel3;

    @FXML
    private TableColumn<?, ?> complex;

    @FXML
    private TableColumn<?, ?> complex1;

    @FXML
    private TableColumn<?, ?> entrance;

    @FXML
    private ChoiceBox<?> filter1;

    @FXML
    private ChoiceBox<?> filter2;

    @FXML
    private ChoiceBox<?> filter3;

    @FXML
    private Button filterButton;

    @FXML
    private Label finalLabel1;

    @FXML
    private Label finalLabel2;

    @FXML
    private Label finalLabel3;

    @FXML
    private Label finalLabel4;

    @FXML
    private Label finalLabel5;

    @FXML
    private TextField finalResult1;

    @FXML
    private TextField finalResult2;

    @FXML
    private TextField finalResult3;

    @FXML
    private TextField finalResult4;

    @FXML
    private TextField finalResult5;

    @FXML
    private TextField flatSum;

    @FXML
    private TableColumn<?, ?> floor;

    @FXML
    private Button goBack;

    @FXML
    private TableView<?> housesTable;

    @FXML
    private TableColumn<?, ?> idApartment;

    @FXML
    private TextField perMeter;

    @FXML
    private TableColumn<?, ?> rooms;

    @FXML
    private TableColumn<?, ?> status;

    @FXML
    void insertAddedSum(ActionEvent event) {

    }

    @FXML
    void insertFlatSum(ActionEvent event) {

    }
    @FXML
    void insertPerMeterParameter(ActionEvent event) {

    }
    @FXML
    public void initialize(){
    }

}
