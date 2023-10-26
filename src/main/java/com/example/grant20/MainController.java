package com.example.grant20;

import com.example.grant20.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController{
    private User profile;

    public User getProfile() {
        return profile;
    }

    public void setProfile(User profile) {
        this.profile = profile;
    }

    @FXML
    private Button appartmentButton;

    @FXML
    private Button complexButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button housesButton;

    @FXML
    private Label labelFioAuthorizedPerson;
    @FXML
    void setUserName(User user) {
        labelFioAuthorizedPerson.setText(user.getName());
    }
    @FXML
    private Button openProfileButton;

    @FXML
    private Button reportButton;

    @FXML
    void logOut(ActionEvent event) {
        HelloApplication.changeMainPage("hello-view.fxml");
    }

    @FXML
    void openApartmentsView(ActionEvent event) {
        HelloApplication.changeMainPage("apartments.fxml",new ApartmentController(profile));

    }

    @FXML
    void openComplexesView(ActionEvent event) {
        HelloApplication.changeMainPage("complexes.fxml",new ComplexController(profile));
    }

    @FXML
    void openHousesView(ActionEvent event) {
        HelloApplication.changeMainPage("houses.fxml",new HouseController(profile));
    }

    @FXML
    void openProfile(ActionEvent event) {
        ///
    }

    @FXML
    void openReports(ActionEvent event) {
        HelloApplication.changeMainPage("report.fxml",new ReportController(profile));
    }
    @FXML
    public void initialize() {
        setUserName(profile);
    }
    public MainController(User user){
        profile = user;
    }



}

