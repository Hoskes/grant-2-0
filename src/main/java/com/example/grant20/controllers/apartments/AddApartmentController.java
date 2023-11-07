package com.example.grant20.controllers.apartments;

import com.example.grant20.HelloApplication;
import com.example.grant20.models.DB.DBConnect;
import com.example.grant20.models.DB.Query;
import com.example.grant20.models.MyAlert;
import com.example.grant20.models.dataModel.Apartment;
import com.example.grant20.models.features.Regex;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class AddApartmentController {
    Apartment currentObject;
    ApartmentController toPage;

    @FXML
    private Label addedValueLabel;

    @FXML
    private Label areaLabel;

    @FXML
    private Label buildingCostLabel;

    @FXML
    private ChoiceBox<String> chooseHouse;

    @FXML
    private ChoiceBox<String> chooseStatus;
    @FXML
    private ChoiceBox<String> chooseComplex;

    @FXML
    private TextField enterAddedValue;

    @FXML
    private TextField enterArea;

    @FXML
    private TextField enterBuildingCost;

    @FXML
    private TextField enterEntrance;

    @FXML
    private TextField enterFloor;

    @FXML
    private TextField enterNumber;

    @FXML
    private TextField enterRooms;

    @FXML
    private Label entranceLabel;

    @FXML
    private Label floorLabel;

    @FXML
    private Button goBackButton;

    @FXML
    private Label houseLabel;

    @FXML
    private Label numberLabel;

    @FXML
    private Label roomsLabel;

    @FXML
    private Button saveChangesButton;

    @FXML
    private Label statusLabel;

    @FXML
    void enterAddedValue(ActionEvent event) {

    }

    @FXML
    void enterArea(ActionEvent event) {

    }

    @FXML
    void enterBuildingCost(ActionEvent event) {

    }

    @FXML
    void enterEntrance(ActionEvent event) {

    }

    @FXML
    void enterFloor(ActionEvent event) {

    }

    @FXML
    void enterNumber(ActionEvent event) {

    }

    @FXML
    void enterRooms(ActionEvent event) {

    }

    @FXML
    void goToApartmentsPage(ActionEvent event) {
        HelloApplication.changeMainPage("apartments.fxml", toPage);
    }

    @FXML
    void saveChanges(ActionEvent event) {
        boolean check = !enterArea.getText().isEmpty() &
                !enterFloor.getText().isEmpty() & enterFloor.getText().matches(Regex.checkPositiveNumbers) &
                !enterEntrance.getText().isEmpty() & enterEntrance.getText().matches(Regex.checkPositiveNumbers) &
                !enterRooms.getText().isEmpty() & enterRooms.getText().matches(Regex.checkPositiveNumbers) &
                !enterNumber.getText().isEmpty() &
                !enterAddedValue.getText().isEmpty() & enterAddedValue.getText().matches(Regex.checkPositiveNumbers) &
                !enterBuildingCost.getText().isEmpty() & enterBuildingCost.getText().matches(Regex.checkPositiveNumbers) &
                !chooseComplex.getSelectionModel().isEmpty() &
                !chooseHouse.getSelectionModel().isEmpty() &
                !chooseStatus.getSelectionModel().isEmpty();
        if(check){
            if (currentObject == null) {
                DBConnect.executePreparedInsert(Query.insertApartment,new ArrayList<>(Arrays.asList(

                        chooseHouse.getValue().substring(chooseHouse.getValue().indexOf("д.") + 2, chooseHouse.getValue().length()).trim(),
                        chooseComplex.getValue(),
                        chooseHouse.getValue().substring(chooseHouse.getValue().indexOf("г.") + 3, chooseHouse.getValue().indexOf("ул.")).trim(),
                        chooseHouse.getValue().substring(chooseHouse.getValue().indexOf("ул.") + 4, chooseHouse.getValue().indexOf("д.")).trim(),

                        enterNumber.getText(),
                        enterArea.getText(),
                        enterRooms.getText(),
                        enterEntrance.getText(),
                        enterFloor.getText(),
                        chooseStatus.getSelectionModel().getSelectedItem(),
                        enterAddedValue.getText(),
                        enterBuildingCost.getText()
                        )));
            }else {
                DBConnect.executePreparedModificationQuery(
                        Query.updateApartmentById,
                        new ArrayList<>(Arrays.asList(

                                chooseHouse.getValue().substring(chooseHouse.getValue().indexOf("д.") + 2, chooseHouse.getValue().length()).trim(),
                                chooseComplex.getValue(),
                                chooseHouse.getValue().substring(chooseHouse.getValue().indexOf("г.") + 3, chooseHouse.getValue().indexOf("ул.")).trim(),
                                chooseHouse.getValue().substring(chooseHouse.getValue().indexOf("ул.") + 4, chooseHouse.getValue().indexOf("д.")).trim(),

                                enterNumber.getText(),
                                enterArea.getText(),
                                enterRooms.getText(),
                                enterEntrance.getText(),
                                enterFloor.getText(),
                                chooseStatus.getSelectionModel().getSelectedItem(),
                                enterAddedValue.getText(),
                                enterBuildingCost.getText(),
                                currentObject.getId()+""
                        )
                        ));
            }
            MyAlert alert = new MyAlert("Запись успешно изменена");
            HelloApplication.changeMainPage("apartments.fxml", toPage);
        }
        else {
            MyAlert alert = new MyAlert("Ошибка в заполнении данных! Пожалуйства проверьте корректность заполненных вами значений");
        }


    }


    public AddApartmentController(ApartmentController toPage) {
        this.toPage = toPage;
    }

    public AddApartmentController(ApartmentController toPage, Apartment currentObject) {
        this.toPage = toPage;
        this.currentObject = currentObject;
    }

    @FXML
    public void initialize() {
        ObservableList statusList = FXCollections.observableArrayList(Arrays.asList("ready", "sold"));

        if (currentObject != null) {
            enterArea.setText("" + currentObject.getArea());

            enterFloor.setText("" + currentObject.getFloor());
            Regex.addListenerFormatter(enterFloor, Regex.checkPositiveNumbers);

            enterEntrance.setText("" + currentObject.getEntrance());
            Regex.addListenerFormatter(enterEntrance, Regex.checkPositiveNumbers);

            enterRooms.setText("" + currentObject.getRooms());
            Regex.addListenerFormatter(enterRooms, Regex.checkPositiveNumbers);

            enterNumber.setText("" + currentObject.getApartmentNumber());

            chooseComplex.setValue("");
            chooseStatus.setValue(currentObject.getStatusSale());
            chooseHouse.setValue("");

            enterAddedValue.setText(currentObject.getAddedValue());
            Regex.addListenerFormatter(enterAddedValue, Regex.checkPositiveNumbers);

            enterBuildingCost.setText(currentObject.getCost());
            Regex.addListenerFormatter(enterBuildingCost, Regex.checkPositiveNumbers);
            if (currentObject.getStatusSale().equals("sold")) {
                statusList = FXCollections.observableArrayList(Arrays.asList("sold"));
            }
        }
        chooseStatus.setItems(statusList);

        ObservableList<String> complexesName = FXCollections.observableArrayList();
        ResultSet resultSet = DBConnect.getDBConnect().executeSelect(Query.getComplexNames);
        try {
            while (resultSet.next()) {
                complexesName.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("AddHouseController list creation error");
            throw new RuntimeException(e);
        }
        chooseComplex.setItems(complexesName);
        chooseComplex.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                ObservableList<String> items = FXCollections.observableArrayList();
                ResultSet result = DBConnect.executePreparedSelect(
                        Query.getConcatedApartmentAddressByHouse,
                        new ArrayList<>(Arrays.asList(t1)));

                try {
                    while (result.next()) {
                        items.add(result.getString(1));
                    }
                } catch (SQLException e) {
                    System.out.println("AddHouseController list creation error");
                    throw new RuntimeException(e);
                }
                chooseHouse.setValue("");
                chooseHouse.setItems(items);
            }
        });
        if (currentObject != null) {
            chooseComplex.setValue(currentObject.getHouseName());
            chooseHouse.setValue("г. " + currentObject.splitAddressData(3) + " ул. " + currentObject.splitAddressData(0) + " д. " + currentObject.splitAddressData(1));
        }
    }
}

