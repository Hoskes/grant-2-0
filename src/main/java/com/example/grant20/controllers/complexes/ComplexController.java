package com.example.grant20.controllers.complexes;

import com.example.grant20.HelloApplication;
import com.example.grant20.controllers.MainController;
import com.example.grant20.models.MyAlert;
import com.example.grant20.models.dataModel.Complex;
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
import java.util.ArrayList;
import java.util.Arrays;

public class ComplexController {
    User profile;

    TableView<Complex> table;


    @FXML
    private Button changeComplex;

    @FXML
    private Button createComplex;

    @FXML
    private Button deleteComplex;

    @FXML
    private TextField enterCity;

    @FXML
    private TextField enterStatus;

    @FXML
    private Button goBackButton;

    @FXML
    private AnchorPane pane;

    @FXML
    void change(ActionEvent event) {
        HelloApplication.changeMainPage("add_change_complex.fxml",new AddComplexController(this,table.getSelectionModel().getSelectedItem()));
    }

    @FXML
    void create(ActionEvent event) {
        HelloApplication.changeMainPage("add_change_complex.fxml",new AddComplexController(this));
    }

    @FXML
    void delete(ActionEvent event) {
        MyAlert alert = new MyAlert("Вы действительно хотите удалить запись №" + table.getSelectionModel().getSelectedItem().getId() + "?");
        if (alert.getAlert() == ButtonType.YES) {
            Complex deletedItem = table.getSelectionModel().getSelectedItem();
            ArrayList<Complex> bufList = new ArrayList<>(table.getItems().stream().toList());
            bufList.remove(deletedItem);
            table.setItems(FXCollections.observableArrayList(bufList));
            DBConnect.executePreparedModificationQuery(Query.deleteComplexById, new ArrayList(Arrays.asList(deletedItem.getId() + "")));
        }
    }
    @FXML
    public void initialize() {
        ResultSet resultSet = DBConnect.getDBConnect().executeSelect(Query.getComplexes);
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
        TableView<Complex> complexTable = new TableViewGenerator<Complex>(Complex.class, filteredItems,0,7).getTable();
        table = complexTable;
        //фильтрация
        TableFilterGenerator<Complex> filter = new TableFilterGenerator<>(table,filteredItems);
        filter.addNewEqualsFilter(enterCity,"city");
        filter.addNewEqualsFilter(enterStatus,"status");
        filter.setFiltersToTable();

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
