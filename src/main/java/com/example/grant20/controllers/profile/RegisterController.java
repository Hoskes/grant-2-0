package com.example.grant20.controllers.profile;

import com.example.grant20.HelloApplication;
import com.example.grant20.models.DB.DBConnect;
import com.example.grant20.models.DB.Query;
import com.example.grant20.models.MyAlert;
import com.example.grant20.models.features.PasswordHashing;
import com.example.grant20.models.features.Regex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Arrays;

public class RegisterController {

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
    private Button submitRegistration;

    @FXML
    void confirmRegistrationSuccess(ActionEvent event) {
        boolean isName = enterF.getText().matches(Regex.getCheckName())
                & enterI.getText().matches(Regex.getCheckName())
                & enterO.getText().matches(Regex.getCheckName());
        boolean isPassword = enterPassword.getText().matches(Regex.getCheckPsw())
                & repeatPassword.getText().equals(enterPassword.getText());
        boolean isEmail = enterEmail.getText().matches(Regex.getCheckLog());
        boolean isPhone = enterPhoneNumber.getText().matches(Regex.checkPhone);
        if (isName & isPassword & isEmail & isPhone) {
            //запрос к БД
            DBConnect.executePreparedInsert(Query.registerAuthorizationData, new ArrayList<String>(
                    Arrays.asList(enterEmail.getText(),PasswordHashing.hashPassword(enterPassword.getText()))));
            DBConnect.executePreparedInsert(Query.registerUser, new ArrayList<String>(
                    Arrays.asList(enterEmail.getText(), enterF.getText() + " " + enterI.getText() + " " + enterO.getText())));
            MyAlert alert = new MyAlert("Регистрация прошла успешно!");
            HelloApplication.changeMainPage("auth.fxml", new AuthController());
        } else {
            String s = "Следующие данные неверны: ";
            if (!isName) {
                s += "-ФИО ";
            }
            if (!isPassword) {
                s += "-Пароль ";
            }
            if (!isPhone) {
                s += "-Номер телефона ";
            }
            if (!isEmail) {
                s += "-email ";
            }
            MyAlert alert = new MyAlert(s);
        }
    }

    @FXML
    void goToAuthorizationPage(ActionEvent event) {
        HelloApplication.changeMainPage("auth.fxml", new AuthController());
    }

    @FXML
    public void initialize() {
        Regex.addListenerFormatter(enterEmail, Regex.getCheckLog());
        Regex.addListenerFormatter(enterF, Regex.getCheckName());
        Regex.addListenerFormatter(enterI, Regex.getCheckName());
        Regex.addListenerFormatter(enterO, Regex.getCheckName());
        Regex.addListenerFormatter(enterPassword, Regex.getCheckPsw());
        Regex.addListenerFormatter(enterPhoneNumber, Regex.checkPhone);
    }
}

