package com.example.grant20.controllers.houses;

import com.example.grant20.HelloApplication;
import com.example.grant20.controllers.MainController;
import com.example.grant20.models.*;
import com.example.grant20.models.dataModel.House;
import com.example.grant20.models.dataModel.User;
import com.example.grant20.models.DB.DBConnect;
import com.example.grant20.models.DB.Query;
import com.example.grant20.models.features.TableFilterGenerator;
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

public class HouseController {
    private User profile;
    TableView<House> table;

    @FXML
    private AnchorPane pane;
    @FXML
    private Button changeHouseButton;

    @FXML
    private Button createHouseButton;

    @FXML
    private Button deleteHouseButton;

    @FXML
    private Button goBackButton;

    @FXML
    private TextField insertAddress;

    @FXML
    private TextField insertAddressNum;

    @FXML
    private TextField insertHouseComplex;

    @FXML
    void changeHouse(ActionEvent event) {
        System.out.println(table.getSelectionModel().getSelectedItem().getComplexName());
    }

    @FXML
    void createHouse(ActionEvent event) {
        System.out.println(table.getSelectionModel().getSelectedItem());
        HelloApplication.changeMainPage("add_change_house.fxml",new AddHouseController());
    }

    @FXML
    void deleteHouse(ActionEvent event) {
        MyAlert alert = new MyAlert("Вы действительно хотите удалить эту запись");
        if (alert.getAlert() == ButtonType.YES) {
            House deletedItem = table.getSelectionModel().getSelectedItem();
            table.getItems().remove(deletedItem);
            //удалить строчку из таблицы
        }
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
        table = housesTable;
        TableFilterGenerator<House> filter = new TableFilterGenerator<>(table,filteredItems);
        filter.addNewEqualsFilter(insertAddress,"street");
        filter.setFiltersToTable();
        TableFilterGenerator<House> filter2 = new TableFilterGenerator<>(table,filteredItems);
        filter2.addNewEqualsFilter(insertHouseComplex,"complexName");
        filter2.addNewEqualsFilter(insertAddressNum,"number");
        filter2.setFiltersToTable();
    }

    @FXML
    void goToMainPage(ActionEvent event) {
        HelloApplication.changeMainPage("main.fxml",new MainController(profile));
    }
    public HouseController(User user){
        profile=user;
    }
}
