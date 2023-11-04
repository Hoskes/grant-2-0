package com.example.grant20.controllers.houses;

import com.example.grant20.models.dataModel.House;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddHouseController {


    @FXML
    private Label addedValueLabel;

    @FXML
    private Label buildingCostLabel;

    @FXML
    private ChoiceBox<?> chooseComplex;

    @FXML
    private ChoiceBox<?> chooseStatus;

    @FXML
    private Label complexLabel;

    @FXML
    private TextField enterAddedValue;

    @FXML
    private TextField enterBuildingCost;

    @FXML
    private TextField enterNumber;

    @FXML
    private Button goBackButton;

    @FXML
    private Label numberLabel;

    @FXML
    private Button saveChangesButton;

    @FXML
    private Label statusLabel;

    @FXML
    void enterAddedValue(ActionEvent event) {

    }

    @FXML
    void enterBuildingCost(ActionEvent event) {

    }

    @FXML
    void enterNumber(ActionEvent event) {

    }

    @FXML
    void goToHouses(ActionEvent event) {

    }

    @FXML
    void saveChanges(ActionEvent event) {

    }
    public AddHouseController(){};
    public AddHouseController(House house){
//        enterAddedValue.setText();
        enterNumber.setText(house.getNumber());
//        enterBuildingCost.setText();
    }
}
