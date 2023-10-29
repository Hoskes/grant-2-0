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
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;

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
    TableView<Complex> table;

    @FXML
    private AnchorPane complexAnchor;

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
    public void initialize() {
        ResultSet resultSet = DBConnect.getDBConnect().executeQuery(Query.getComplexes);
        ObservableList<Complex> items = FXCollections.observableArrayList();
        try {
            while (resultSet.next()) {
                items.add(new Complex(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Complex list creation error");
            throw new RuntimeException(e);
        }
        FilteredList<Complex> filteredItems = new FilteredList<>(items, p->true);
        TableView<Complex> complexTable = new TableViewGenerator<Complex>(Complex.class,filteredItems).getTable();
        table = complexTable;
        complexAnchor.getChildren().add(complexTable);
    }

    @FXML
    void goToMainPage(ActionEvent event) {
        HelloApplication.changeMainPage("main.fxml",new MainController(profile));
    }
    public ComplexController(User user){
        profile=user;
    }
}
