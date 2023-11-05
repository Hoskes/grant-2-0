package com.example.grant20.controllers.complexes;

import com.example.grant20.HelloApplication;
import com.example.grant20.models.DB.DBConnect;
import com.example.grant20.models.DB.Query;
import com.example.grant20.models.MyAlert;
import com.example.grant20.models.dataModel.Complex;
import com.example.grant20.models.dataModel.House;
import com.example.grant20.models.features.Regex;
import com.example.grant20.models.features.TableViewGenerator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class AddComplexController {
    Complex currentComplex;
    ComplexController toPage;

    @FXML
    private AnchorPane pane;
    @FXML
    private Label addedValueLabel;

    @FXML
    private Label buildingCostLabel;

    @FXML
    private ChoiceBox<String> chooseStatus;

    @FXML
    private Label cityLabel;

    @FXML
    private TextField enterAddedValue;

    @FXML
    private TextField enterBuildingCost;

    @FXML
    private TextField enterCity;

    @FXML
    private TextField enterName;

    @FXML
    private TextField enterStreet;

    @FXML
    private Button goBackButton;

    @FXML
    private Label housesLabel;

    @FXML
    private Label numberLabel;

    @FXML
    private Button saveChangesButton;

    @FXML
    private Label statusLabel;

    @FXML
    private Label streetLabel;

    @FXML
    private Rectangle tablePlace;


    @FXML
    void goToComplexesPage(ActionEvent event) {
        HelloApplication.changeMainPage("complexes.fxml", toPage);
    }

    @FXML
    void saveChanges(ActionEvent event) {
        boolean check = !enterName.getText().isEmpty() &
                !enterCity.getText().isEmpty() &
                !enterStreet.getText().isEmpty() &
                !chooseStatus.getValue().isEmpty() &
                !enterAddedValue.getText().isEmpty() &
                !enterBuildingCost.getText().isEmpty();
        if (check) {
            if (currentComplex == null) {
                DBConnect.executePreparedInsert(
                        Query.insertComplex,
                        new ArrayList<>(Arrays.asList(
                                enterName.getText(),
                                enterCity.getText(),
                                enterStreet.getText(),
                                chooseStatus.getValue(),
                                enterAddedValue.getText(),
                                enterBuildingCost.getText()
                        )));
            } else {
                DBConnect.executePreparedModificationQuery(Query.updateComplex,
                        new ArrayList<>(Arrays.asList(
                                enterName.getText(),
                                enterCity.getText(),
                                enterStreet.getText(),
                                chooseStatus.getValue(),
                                enterAddedValue.getText(),
                                enterBuildingCost.getText(),
                                currentComplex.getId()+""
                        )));
            }
            MyAlert alert = new MyAlert("Запись успешно изменена");
            HelloApplication.changeMainPage("complexes.fxml", toPage);
        }
        MyAlert alert = new MyAlert("Ошибка в заполнении данных! Пожалуйства проверьте корректность заполненных вами значений");

    }

    @FXML
    public void initialize() {
        //список без учета состояния
        chooseStatus.setItems(FXCollections.observableArrayList(Arrays.asList("built", "plan", "selling")));
        if (currentComplex != null) {
            //автозаполнение
            enterName.setText(currentComplex.getName());
            enterAddedValue.setText(currentComplex.getAddedValue());
            enterBuildingCost.setText(currentComplex.getBuildingCosts());
            enterCity.setText(currentComplex.getCity());
            chooseStatus.setValue(currentComplex.getStatus());
            enterStreet.setText(currentComplex.getStreet());
            //список домов
            ResultSet resultSet = DBConnect.executePreparedSelect(
                    Query.selectHouseList,
                    new ArrayList<>(Arrays.asList(currentComplex.getId() + "")));
            ObservableList<House> items = FXCollections.observableArrayList();
            try {
                while (resultSet.next()) {
                    items.add(new House(resultSet));
                }
            } catch (SQLException e) {
                System.out.println("Complex list creation error");
                throw new RuntimeException(e);
            }
            FilteredList<House> filteredItems = new FilteredList<>(items);
            TableViewGenerator<House> houses = new TableViewGenerator<>(House.class, filteredItems, 2, 6);
            TableView<House> table = houses.getTable();
            table.setLayoutX(tablePlace.getLayoutX());
            table.setLayoutY(tablePlace.getLayoutY());
            table.setMaxHeight(tablePlace.getHeight());
            table.setMaxWidth(tablePlace.getWidth());
            pane.getChildren().add(table);
            //есть ли проданные квартиры
            ResultSet resultCheck = DBConnect.executePreparedSelect(
                    Query.checkSoldApartmentsOnComplex,
                    new ArrayList<>(Arrays.asList(currentComplex.getId() + "")));
            try {
                if (resultCheck.next()) {
                    if (resultCheck.getString(1).equals("1")) {
                        chooseStatus.setItems(FXCollections.observableArrayList(Arrays.asList(
                                "built", "selling"
                        )));
                    }

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        //форматирование строк
        Regex.addListenerFormatter(enterBuildingCost, Regex.checkPositiveNumbers);
        Regex.addListenerFormatter(enterAddedValue, Regex.checkPositiveNumbers);

    }

    public AddComplexController(ComplexController toPage) {
        currentComplex = null;
        this.toPage = toPage;
    }

    public AddComplexController(ComplexController toPage, Complex complex) {
        currentComplex = complex;
        this.toPage = toPage;
    }

}
