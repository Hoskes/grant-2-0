package com.example.grant20;

import com.example.grant20.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
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
        Regex.addListenerFormatter(log, Regex.getCheck_log());
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        log.setText(Query.auth_log);
        psw.setText(Query.auth_psw);
        psw.setText(Query.auth_psw);
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
    }



    @FXML
    void enter(ActionEvent event) {
        if (Regex.checkName(log.getText(), Regex.getCheck_log()) & Regex.checkName(psw.getText(), Regex.getCheck_psw())) {
            try {
                ResultSet resultSet = DBConnect.executePreparedQuery(Query.checkAuth,new ArrayList<String>(Arrays.asList(log.getText(),PasswordHashing.hashPassword(psw.getText()))));
                if (resultSet.next()) {//при ненулевом результате
                    if (resultSet.getString(1).equals("1")) {
                        profile = new User(log.getText());
                        HelloApplication.changeMainPage("main.fxml", new MainController(profile));
                        MainController controller = HelloApplication.getLoader().getController();
                        System.out.println(controller);
                        System.out.println(controller.getClass());
                        controller.setProfile(profile);
                    }
                } else {
                    System.out.println("e");
                    //добавить подсветку кнопки на 3 секунды
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void register(ActionEvent event) {
        HelloApplication.changeMainPage("reg.fxml");
    }

}
