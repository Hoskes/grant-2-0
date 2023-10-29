package com.example.grant20.controllers;

import com.example.grant20.HelloApplication;
import com.example.grant20.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class ApartmentController {
    User profile;
    @FXML
    TableView<Apartment> table;
    @FXML
    private AnchorPane apart;
    @FXML
    private Button changeApartmentButton;

    @FXML
    private Button createApartmentButton;

    @FXML
    private Button deleteApartmentButton;

    @FXML
    private ChoiceBox<?> filterComplex;
    @FXML
    private TextField filterTo;
    @FXML
    private ChoiceBox<String> filterEntrance;

    @FXML
    private ChoiceBox<?> filterFloor;

    @FXML
    private ChoiceBox<?> filterHouse;

    @FXML
    private ChoiceBox<?> filterStatus;

    @FXML
    private Button filterTableButton;

    @FXML
    private Button goBackButton;

    @FXML
    private Button notClearSearchButton;

    @FXML
    private TextField notClearSearchField;


    @FXML
    void changeApartment(ActionEvent event) {

    }

    @FXML
    void createApartment(ActionEvent event) {

    }
    @FXML
    void filter(ActionEvent event){

    }
    @FXML
    void deleteApartment(ActionEvent event) {

    }

    @FXML
    void filterTable(ActionEvent event) {

    }

    @FXML
    void goToMainPage(ActionEvent event) {
        goBackButton.setStyle("-fx-text-fill: red; ");
        HelloApplication.changeMainPage("main.fxml",new MainController(profile));
    }

    @FXML
    void notClearSearch(ActionEvent event) {

    }

    @FXML
    void notClearSearchField(ActionEvent event) {

    }
    @FXML
    public void initialize() {
        ResultSet resultSet = DBConnect.getDBConnect().executeQuery(Query.getApartments);
        ObservableList<Apartment> items = FXCollections.observableArrayList();
        try {
            while (resultSet.next()) {
                items.add(new Apartment(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Apartment list creation error");
            throw new RuntimeException(e);
        }
        FilteredList<Apartment> filteredItems = new FilteredList<>(items,p->true);

        TableView<Apartment> apartmentTable = new TableViewGenerator<Apartment>(Apartment.class,filteredItems).getTable();
        table = apartmentTable;
        apart.getChildren().add(apartmentTable);

        TableFilterGenerator<Apartment> filter= new TableFilterGenerator(apartmentTable,filteredItems);
        filter.addNewEqualsFilter(notClearSearchField,"rooms");
        filter.addNewEqualsFilter(filterTo,"statusSale");
        filter.setFiltersToTable();
    }

    public ApartmentController(User user){
        profile = user;
    }
}

