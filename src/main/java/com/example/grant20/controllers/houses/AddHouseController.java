package com.example.grant20.controllers.houses;

import com.example.grant20.HelloApplication;
import com.example.grant20.models.DB.DBConnect;
import com.example.grant20.models.DB.Query;
import com.example.grant20.models.MyAlert;
import com.example.grant20.models.dataModel.House;
import com.example.grant20.models.features.Regex;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class AddHouseController {
    HouseController toPage;
    House currentHouse;
    @FXML
    private Label addedValueLabel;

    @FXML
    private Label buildingCostLabel;

    @FXML
    private ChoiceBox<String> chooseComplex;

    @FXML
    private Label complexLabel;

    @FXML
    private TextField enterAddedValue;

    @FXML
    private TextField enterBuildingCost;

    @FXML
    private TextField enterNumber;

    @FXML
    private ChoiceBox<String> enterStreet;
    @FXML
    private Button goBackButton;

    @FXML
    private Label numberLabel;

    @FXML
    private Button saveChangesButton;

    @FXML
    private Label streetLabel;


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
        HelloApplication.changeMainPage("houses.fxml", toPage);
    }

    @FXML
    void saveChanges(ActionEvent event) {
        //отправить запрос с данными
        if (!enterAddedValue.getText().matches(Regex.checkPositiveNumbers)) {
            addedValueLabel.setStyle("-fx-text-fill: red; ");
        } else {
            addedValueLabel.setStyle("-fx-text-fill: black; ");
        }
        if (!enterBuildingCost.getText().matches(Regex.checkPositiveNumbers)) {
            buildingCostLabel.setStyle("-fx-text-fill: red; ");
        } else {
            buildingCostLabel.setStyle("-fx-text-fill: black; ");
        }
        if (enterAddedValue.getText().matches(Regex.checkPositiveNumbers)
                & enterBuildingCost.getText().matches(Regex.checkPositiveNumbers)) {
            if (currentHouse == null) {
                DBConnect.executePreparedInsert(Query.insertHouse, new ArrayList<String>(
                        Arrays.asList(
                                enterNumber.getText(),
                                enterAddedValue.getText(),
                                enterBuildingCost.getText(),
                                enterStreet.getSelectionModel().getSelectedItem(),
                                chooseComplex.getValue())));
            } else {
                DBConnect.executePreparedModificationQuery(Query.updateHouseById, new ArrayList<String>(
                        Arrays.asList(
                                enterNumber.getText(),
                                enterAddedValue.getText(),
                                enterBuildingCost.getText(),
                                enterStreet.getSelectionModel().getSelectedItem(),
                                chooseComplex.getValue(),
                                currentHouse.getId()+""
                        )));
                currentHouse.setNumber(enterNumber.getText());
                currentHouse.setAddedValue(enterAddedValue.getText());
                currentHouse.setBuildingCost(enterBuildingCost.getText());
                currentHouse.setStreet(enterStreet.getSelectionModel().getSelectedItem());
                currentHouse.setComplexName(chooseComplex.getValue());
            }
            MyAlert alert = new MyAlert("Запись успешно изменена");
            HelloApplication.changeMainPage("houses.fxml", toPage);
        }

    }

    @FXML
    public void initialize() {
        ResultSet complexes = DBConnect.getDBConnect().executeSelect(Query.getComplexNames);
        ObservableList<String> complexChoice = FXCollections.observableArrayList();
        ObservableList<String> streetChoice = FXCollections.observableArrayList();
        try {
            while (complexes.next()) {
                complexChoice.add(complexes.getString(1));
                streetChoice.add(complexes.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        chooseComplex.setItems(complexChoice);
        enterStreet.setItems(streetChoice);
        chooseComplex.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                ObservableList<String> streetChoice = FXCollections.observableArrayList();
                ResultSet complexes = DBConnect.executePreparedSelect(
                        Query.getStreetNamesWhereComplex, new ArrayList<>(Arrays.asList(chooseComplex.getSelectionModel().getSelectedItem())));
                try {
                    while (complexes.next()) {
                        streetChoice.add(complexes.getString(2));
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                enterStreet.setItems(streetChoice);
            }
        });
        if (currentHouse != null) {
            chooseComplex.setValue(currentHouse.getComplexName());
            enterNumber.setText(currentHouse.getNumber());
            enterBuildingCost.setText(currentHouse.getBuildingCost());
            enterAddedValue.setText(currentHouse.getAddedValue());
            enterStreet.setValue(currentHouse.getStreet());
        }
    }

    public AddHouseController(HouseController toPage) {
        this.toPage = toPage;
    }

    public AddHouseController(HouseController toPage, House house) {
        this.toPage = toPage;
        currentHouse = house;
    }
}
