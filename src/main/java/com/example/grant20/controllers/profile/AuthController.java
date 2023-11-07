package com.example.grant20.controllers.profile;

import com.example.grant20.HelloApplication;
import com.example.grant20.controllers.MainController;
import com.example.grant20.models.dataModel.User;
import com.example.grant20.models.DB.DBConnect;
import com.example.grant20.models.features.PasswordHashing;
import com.example.grant20.models.DB.Query;
import com.example.grant20.models.features.Regex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class AuthController {
    private User profile;

    public User getProfile() {
        return profile;
    }

    public void setProfile(User profile) {
        this.profile = profile;
    }

    @FXML
    private Button enter;

    @FXML
    private TextField log;

    @FXML
    private PasswordField psw;

    @FXML
    private Button register;


    @FXML
    public void initialize() {
        Regex.addListenerFormatter(log, Regex.getCheckLog());
    }


    @FXML
    void enter(ActionEvent event) {
        if (Regex.checkName(log.getText(), Regex.getCheckLog()) & Regex.checkName(psw.getText(), Regex.getCheckPsw())) {
            try {
                ResultSet resultSet = DBConnect.executePreparedSelect(Query.checkAuth, new ArrayList<String>(Arrays.asList(log.getText(), PasswordHashing.hashPassword(psw.getText()))));
                if (resultSet.next()) {//при ненулевом результате
                    if (resultSet.getString(1).equals("1")) {
                        profile = new User(log.getText());
                        HelloApplication.changeMainPage("main.fxml", new MainController(profile));
                        MainController controller = HelloApplication.getLoader().getController();
                        controller.setProfile(profile);
                    }
                } else {
                    System.out.println("Error");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void register(ActionEvent event) {
        HelloApplication.changeMainPage("reg.fxml", new RegisterController());
    }

}
