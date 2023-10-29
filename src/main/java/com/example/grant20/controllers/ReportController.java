package com.example.grant20.controllers;

import com.example.grant20.HelloApplication;
import com.example.grant20.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;

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
    private AnchorPane reportAnchor;

    @FXML
    TableView<Report> table;

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
    public void initialize() {
        ResultSet resultSet = DBConnect.getDBConnect().executeQuery(Query.getReport);
        ObservableList<Report> items = FXCollections.observableArrayList();
        try {
            while (resultSet.next()) {
                items.add(new Report(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Report list creation error");
            throw new RuntimeException(e);
        }
        FilteredList<Report> filteredItems = new FilteredList<>(items, p->true);
        TableView<Report> reportTable = new TableViewGenerator<Report>(Report.class,filteredItems).getTable();
        table = reportTable;
        reportAnchor.getChildren().add(reportTable);
    }

    @FXML
    void goToMainPage(ActionEvent event) {
        HelloApplication.changeMainPage("main.fxml",new MainController(profile));
    }
    public ReportController(User user){
        profile=user;
    }
}
