package com.example.grant20.controllers.admin;

import com.example.grant20.HelloApplication;
import com.example.grant20.controllers.MainController;
import com.example.grant20.models.DB.DBConnect;
import com.example.grant20.models.DB.Query;
import com.example.grant20.models.MyAlert;
import com.example.grant20.models.dataModel.Admin;
import com.example.grant20.models.dataModel.User;
import com.example.grant20.models.features.TableViewGenerator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminController {

    private User profile;
    TableView<Admin> table;

    public AdminController(User user) {
        profile = user;
    }

    @FXML
    private Button confirmPersonButton;

    @FXML
    private Button goBackButton;

    @FXML
    private AnchorPane pane;

    @FXML
    void confirmPerson(ActionEvent event) {
        Admin admin = table.getSelectionModel().getSelectedItem();
        DBConnect.executePreparedModificationQuery(Query.updatePersonConfirm, admin.getMail());
        MyAlert alert = new MyAlert("Запись успешно изменена");
    }

    @FXML
    public void initialize() {
        ObservableList<Admin> items = FXCollections.observableArrayList();
        ResultSet resultSet = DBConnect.getDBConnect().executeSelect(Query.getPeople);
        try {
            while (resultSet.next()) {
                items.add(new Admin(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Apartment list creation error");
            throw new RuntimeException(e);
        }
        FilteredList<Admin> filteredItems = new FilteredList<>(items, p -> true);
        TableView<Admin> adminTable = new TableViewGenerator<Admin>(Admin.class,filteredItems).getTable();
        table = adminTable;
        table.setLayoutY(20);
        pane.getChildren().add(adminTable);
    }

    @FXML
    void goToMainPage(ActionEvent event) {
        HelloApplication.changeMainPage("main.fxml", new MainController(profile));
    }
}
