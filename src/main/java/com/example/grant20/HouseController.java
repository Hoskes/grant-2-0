package com.example.grant20;

import com.example.grant20.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class HouseController {
    User profile;
    @FXML
    private Button changeHouseButton;

    @FXML
    private Button createHouseButton;

    @FXML
    private Button deleteHouseButton;

    @FXML
    private ChoiceBox<?> filterComplex;

    @FXML
    private ChoiceBox<?> filterStreet;

    @FXML
    private Button filterTableButton;

    @FXML
    private Button goBackButton;

    @FXML
    void changeHouse(ActionEvent event) {

    }

    @FXML
    void createHouse(ActionEvent event) {

    }

    @FXML
    void deleteHouse(ActionEvent event) {

    }

    @FXML
    void filterTable(ActionEvent event) {

    }

    @FXML
    void goToMainPage(ActionEvent event) {
        HelloApplication.changeMainPage("main.fxml",new MainController(profile));
    }
    public HouseController(User user){
        profile=user;
    }
}
