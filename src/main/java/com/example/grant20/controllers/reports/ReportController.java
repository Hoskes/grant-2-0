package com.example.grant20.controllers.reports;

import com.example.grant20.HelloApplication;
import com.example.grant20.controllers.MainController;
import com.example.grant20.models.dataModel.EstimatedCost;
import com.example.grant20.models.dataModel.EvaluationModel;
import com.example.grant20.models.dataModel.Report;
import com.example.grant20.models.dataModel.User;
import com.example.grant20.models.DB.DBConnect;
import com.example.grant20.models.DB.Query;
import com.example.grant20.models.features.TableFilterGenerator;
import com.example.grant20.models.features.TableViewGenerator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

public class ReportController {
    User profile;
    @FXML
    AnchorPane pane;
    @FXML
    TableView<EstimatedCost> table;
    @FXML
    private Label ThisISCommentDeleteLater;

    @FXML
    private TextField areaCost;

    @FXML
    private TextField baseCost;

    @FXML
    private Label coefLabel;

    @FXML
    private Label coefLabel1;

    @FXML
    private Label coefLabel2;

    @FXML
    private Label coefLabel3;

    @FXML
    private Button createReportButton;

    @FXML
    private Label finalLabel1;

    @FXML
    private Label finalLabel2;

    @FXML
    private Label finalLabel3;

    @FXML
    private Label finalLabel4;

    @FXML
    private Label finalLabel41;

    @FXML
    private Button goBackButton;

    @FXML
    private Label labelComplexesFilter;

    @FXML
    private Label labelHousesFilter;

    @FXML
    private TextField roomsCost;

    @FXML
    private Label summCompanyIncome;

    @FXML
    private Label summConstructionCost;

    @FXML
    private Label summEstimatedCost;

    @FXML
    private Label summEstimatedCostNotSold;

    @FXML
    private Label summEstimatedCostSold;
    @FXML
    private ChoiceBox<String> filterComplex;

    @FXML
    private ChoiceBox<String> filterHouse;

    @FXML
    public void initialize() {
        areaCost.setText("1");
        baseCost.setText("1");
        roomsCost.setText("1");
        ResultSet resultSet = DBConnect.getDBConnect().executeSelect(Query.getReport);
        ObservableList<EstimatedCost> items = FXCollections.observableArrayList();
        try {
            while (resultSet.next()) {
                items.add(new EstimatedCost(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Report list creation error");
            throw new RuntimeException(e);
        }
        FilteredList<EstimatedCost> filteredItems = new FilteredList<>(items, p -> true);
        TableView<EstimatedCost> reportTable = new TableViewGenerator<EstimatedCost>(EstimatedCost.class, filteredItems, 0, 6).getTable();
        table = reportTable;
        TableFilterGenerator filter = new TableFilterGenerator<>(table, filteredItems);

        filterComplex.setItems(getValuesFromList("complexName"));
        filterHouse.setItems(getValuesFromList("houseNumber"));
        filterComplex.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(t1.isEmpty() || t1.equals("")){
                    filterHouse.setItems(getValuesFromList("houseNumber"));
                    System.out.println("free");
                }else {
                    System.out.println("A");
                    filterHouse.setItems(getHouses(t1));
                }
            }
        });
        filterComplex.setValue("");
        filterHouse.setValue("");
        filter.addNewEqualsFilter(filterComplex, "complexName");
        filter.addNewEqualsFilter(filterHouse, "HouseNumber");
        filter.setFiltersToTable();


        table.getItems().addListener(new ListChangeListener<EstimatedCost>() {
            @Override
            public void onChanged(Change<? extends EstimatedCost> change) {
                EvaluationModel calc = new EvaluationModel(table.getItems());

                double[] result = calc.calculateFlatCost(
                        Double.parseDouble(areaCost.getText()),
                        Double.parseDouble(baseCost.getText()),
                        Double.parseDouble(roomsCost.getText()));
                summEstimatedCost.setText(result[2]+"");
                summEstimatedCostNotSold.setText(result[0]+"");
                summEstimatedCostSold.setText(result[1]+"");
                double loss = calc.calculateLoss();
                summConstructionCost.setText("" + loss);
                summCompanyIncome.setText((result[2] - loss) + "");
            }
        });

        addTextFieldCalculateListener(areaCost);
        addTextFieldCalculateListener(baseCost);
        addTextFieldCalculateListener(roomsCost);
        pane.getChildren().add(table);
    }

    @FXML
    void goToMainPage(ActionEvent event) {
        HelloApplication.changeMainPage("main.fxml", new MainController(profile));
    }

    public ReportController(User user) {
        profile = user;
    }

    private void addDoubleListener(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                try {
                    if (!textField.getText().isEmpty()) {
                        Double.parseDouble(textField.getText());
                        textField.setText(t1);
                    } else {
                        textField.setText("1");
                    }
                } catch (Exception e) {
                    textField.setText(s);
                }
            }
        });
    }

    private ObservableList<String> getValuesFromList(String columnName) {
        HashSet<String> a = new HashSet<>();
        a.add("");
        int t = 0;
        if (columnName.equals("complexName"))
            t = 1;
        else if (columnName.equals("houseNumber")) {
            t = 2;
        }
        for (EstimatedCost e : table.getItems()) {
            if (t == 1) {
                a.add(e.getComplexName());
            } else if (t == 2) {
                a.add(e.getHouseNumber());
            }
        }
        return FXCollections.observableArrayList(a.stream().toList());
    }

    private void addTextFieldCalculateListener(TextField areaCost) {
        areaCost.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                EvaluationModel calc = new EvaluationModel(table.getItems());

                double[] result = calc.calculateFlatCost(
                        Double.parseDouble(areaCost.getText()),
                        Double.parseDouble(baseCost.getText()),
                        Double.parseDouble(roomsCost.getText()));
                summEstimatedCost.setText(result[2]+"");
                summEstimatedCostNotSold.setText(result[0]+"");
                summEstimatedCostSold.setText(result[1]+"");
                double loss = calc.calculateLoss();
                summConstructionCost.setText("" + loss);
                summCompanyIncome.setText((result[2] - loss) + "");
            }
        });
    }
    private ObservableList<String> getHouses(String complex) {
        HashSet<String> a = new HashSet<>();
        for (EstimatedCost e : table.getItems()) {
            if (e.getComplexName().equals(complex))
                a.add(e.getHouseNumber());
        }
        return FXCollections.observableArrayList(a.stream().toList());
    }
}
