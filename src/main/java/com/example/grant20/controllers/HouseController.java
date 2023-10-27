package com.example.grant20.controllers;

import com.example.grant20.HelloApplication;
import com.example.grant20.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseController {
    private User profile;

    @FXML
    private AnchorPane pane;
    @FXML
    private Button changeHouseButton;

    @FXML
    private Button createHouseButton;

    @FXML
    private Button deleteHouseButton;

    @FXML
    private ChoiceBox<?> filterComplex;

    @FXML
    private ChoiceBox<?> filterStreet;

    @FXML
    private Button filterTableButton;

    @FXML
    private Button goBackButton;

    @FXML
    void changeHouse(ActionEvent event) {

    }

    @FXML
    void createHouse(ActionEvent event) {

    }

    @FXML
    void deleteHouse(ActionEvent event) {

    }

    @FXML
    void filterTable(ActionEvent event) {

    }
    @FXML
    public void initialize() {
        ObservableList<House> items = FXCollections.observableArrayList();
        FilteredList<House> filteredItems = new FilteredList<>(items,p->true);
        ResultSet resultSet = DBConnect.getDBConnect().executeQuery(Query.getHouses);
        try {
            while (resultSet.next()) {
                items.add(new House(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Apartment list creation error");
            throw new RuntimeException(e);
        }

        TableView<House> housesTable = new TableViewGenerator(House.class, filteredItems).getTable();
        pane.getChildren().add(housesTable);
        for (House a:items) {
            System.out.println(a.getId());

        }
    }

    @FXML
    void goToMainPage(ActionEvent event) {
        HelloApplication.changeMainPage("main.fxml",new MainController(profile));
    }
    public HouseController(User user){
        profile=user;
    }
}
