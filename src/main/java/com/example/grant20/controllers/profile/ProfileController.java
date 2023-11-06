package com.example.grant20.controllers.profile;

import com.example.grant20.HelloApplication;
import com.example.grant20.controllers.MainController;
import com.example.grant20.models.DB.DBConnect;
import com.example.grant20.models.DB.Query;
import com.example.grant20.models.dataModel.Admin;
import com.example.grant20.models.dataModel.User;
import com.example.grant20.models.features.TableViewGenerator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileController {

    private User profile;

    public ProfileController(User user) {
        profile = user;
    }

    @FXML
    private TextField enterEmail;

    @FXML
    private TextField enterF;

    @FXML
    private TextField enterI;

    @FXML
    private TextField enterO;

    @FXML
    private PasswordField enterPassword;

    @FXML
    private TextField enterPhoneNumber;

    @FXML
    private Button goBackButton;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelF;

    @FXML
    private Label labelI;

    @FXML
    private Label labelO;

    @FXML
    private Label labelPassword1;

    @FXML
    private Label labelPassword2;

    @FXML
    private Label labelPhoneNumber;

    @FXML
    private PasswordField repeatPassword;

    @FXML
    private Button saveChangesButton;

    @FXML
    public void initialize() {
//        ObservableList<Admin> items = FXCollections.observableArrayList();
//        ResultSet resultSet = DBConnect.getDBConnect().executeSelect(Query.getPeople);
//        try {
//            while (resultSet.next()) {
//                items.add(new Profile(resultSet));
//            }
//        } catch (SQLException e) {
//            System.out.println("Apartment list creation error");
//            throw new RuntimeException(e);
//        }
//        FilteredList<Admin> filteredItems = new FilteredList<>(items, p -> true);
//        TableView<Admin> adminTable = new TableViewGenerator<Admin>(Admin.class,filteredItems).getTable();
//        table = adminTable;
//        pane.getChildren().add(adminTable);
    }

    @FXML
    void goBackButton(ActionEvent event) {
        HelloApplication.changeMainPage("main.fxml", new MainController(profile));
    }

    @FXML
    void saveChanges(ActionEvent event) {

    }
}
