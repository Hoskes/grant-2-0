package com.example.grant20.controllers.complexes;

import com.example.grant20.HelloApplication;
import com.example.grant20.controllers.MainController;
import com.example.grant20.models.dataModel.Complex;
import com.example.grant20.models.dataModel.User;
import com.example.grant20.models.DB.DBConnect;
import com.example.grant20.models.DB.Query;
import com.example.grant20.models.features.TableViewGenerator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComplexController {
    User profile;
    @FXML
    TableView<Complex> table;

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
    private AnchorPane pane;

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
        FilteredList<Complex> filteredItems = new FilteredList<>(items, p -> true);
        TableView<Complex> complexTable = new TableViewGenerator<Complex>(Complex.class, filteredItems).getTable();
        table = complexTable;
        pane.getChildren().add(complexTable);
    }

    @FXML
    void goToMainPage(ActionEvent event) {
        HelloApplication.changeMainPage("main.fxml", new MainController(profile));
    }

    public ComplexController(User user) {
        profile = user;
    }
}
