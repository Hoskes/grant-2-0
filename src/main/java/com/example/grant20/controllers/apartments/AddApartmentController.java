package com.example.grant20.controllers.apartments;

import com.example.grant20.HelloApplication;
import com.example.grant20.models.dataModel.Apartment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.ResultSet;

public class AddApartmentController {
    Apartment currentObject;
    ApartmentController toPage;

    @FXML
    private Label addedValueLabel;

    @FXML
    private Label areaLabel;

    @FXML
    private Label buildingCostLabel;

    @FXML
    private ChoiceBox<?> chooseHouse;

    @FXML
    private ChoiceBox<?> chooseStatus;

    @FXML
    private TextField enterAddedValue;

    @FXML
    private TextField enterArea;

    @FXML
    private TextField enterBuildingCost;

    @FXML
    private TextField enterEntrance;

    @FXML
    private TextField enterFloor;

    @FXML
    private TextField enterNumber;

    @FXML
    private TextField enterRooms;

    @FXML
    private Label entranceLabel;

    @FXML
    private Label floorLabel;

    @FXML
    private Button goBackButton;

    @FXML
    private Label houseLabel;

    @FXML
    private Label numberLabel;

    @FXML
    private Label roomsLabel;

    @FXML
    private Button saveChangesButton;

    @FXML
    private Label statusLabel;

    @FXML
    void enterAddedValue(ActionEvent event) {

    }

    @FXML
    void enterArea(ActionEvent event) {

    }

    @FXML
    void enterBuildingCost(ActionEvent event) {

    }

    @FXML
    void enterEntrance(ActionEvent event) {

    }

    @FXML
    void enterFloor(ActionEvent event) {

    }

    @FXML
    void enterNumber(ActionEvent event) {

    }

    @FXML
    void enterRooms(ActionEvent event) {

    }

    @FXML
    void goToApartmentsPage(ActionEvent event) {
        HelloApplication.changeMainPage("apartments.fxml",toPage);
    }

    @FXML
    void saveChanges(ActionEvent event) {

    }
    public AddApartmentController(ApartmentController toPage){
        this.toPage = toPage;
    }
    public AddApartmentController(ApartmentController toPage, Apartment currentObject){
        this.toPage = toPage;
        this.currentObject = currentObject;
    }
    @FXML
    public void initialize() {
        System.out.println(currentObject);
        if(currentObject != null){
            enterArea.setText(""+currentObject.getArea());
            enterFloor.setText(""+currentObject.getFloor());
            enterEntrance.setText(""+currentObject.getEntrance());
            enterRooms.setText(""+currentObject.getRooms());
            enterNumber.setText(""+currentObject.getApartmentNumber());

//            addedValueLabel;
//            areaLabel;
//            buildingCostLabel;
//            entranceLabel;
//            floorLabel;
//            goBackButton;
//            houseLabel;
//            numberLabel;
//            roomsLabel;
//            houseLabel;
//            numberLabel;
//            roomsLabel;
        }
    }
}

