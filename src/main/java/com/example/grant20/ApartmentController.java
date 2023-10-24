package com.example.grant20;

import com.example.grant20.models.Apartment;
import com.example.grant20.models.DBConnect;
import com.example.grant20.models.Query;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    @FXML
    private AnchorPane apart;

    @FXML
    private Button changeApartment;

    @FXML
    private Button createApartment;

    @FXML
    private Button deleteApartment;

    @FXML
    private ChoiceBox<?> filter1;

    @FXML
    private ChoiceBox<?> filter2;

    @FXML
    private ChoiceBox<?> filter3;

    @FXML
    private ChoiceBox<?> filter4;

    @FXML
    private ChoiceBox<?> filter5;

    @FXML
    private Button filterButton;

    @FXML
    private Button filterButton2;

    @FXML
    private TextField filterField;

    @FXML
    private TableColumn<?, ?> floor;

    @FXML
    private Button goBack;

    @FXML
    private TableView<?> housesTable;

    @FXML
    private TableColumn<?, ?> idApartment;

    @FXML
    private TableColumn<?, ?> rooms;

    @FXML
    private TableColumn<?, ?> status;
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

        housesTable = new TableViewGenerator<Apartment>(Apartment.class,items).getTable();
        housesTable.setLayoutX(20);
        housesTable.setLayoutY(20);
        apart.getChildren().add(housesTable);
        for (Apartment a:items) {
            System.out.println(a.getHouseName());

        }
    }
}

