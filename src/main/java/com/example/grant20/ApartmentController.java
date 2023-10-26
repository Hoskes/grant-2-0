package com.example.grant20;

import com.example.grant20.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApartmentController {
    User profile;
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
    private ChoiceBox<?> filterEntrance;

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
    void deleteApartment(ActionEvent event) {

    }

    @FXML
    void filterTable(ActionEvent event) {

    }

    @FXML
    void goToMainPage(ActionEvent event) {
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
        ObservableList<Apartment> items = FXCollections.observableArrayList();
        ResultSet resultSet = DBConnect.getDBConnect().executeQuery(Query.getApartments);
        try {
            while (resultSet.next()) {
                items.add(new Apartment(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Apartment list creation error");
            throw new RuntimeException(e);
        }

        TableView<Apartment> housesTable = new TableViewGenerator<Apartment>(Apartment.class,items).getTable();
        housesTable.setLayoutX(20);
        housesTable.setLayoutY(20);
        apart.getChildren().add(housesTable);
        for (Apartment a:items) {
            System.out.println(a.getHouseName());

        }
    }
    public ApartmentController(User user){
        profile = user;
    }
}

