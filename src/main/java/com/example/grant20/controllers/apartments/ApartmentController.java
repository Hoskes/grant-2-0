package com.example.grant20.controllers.apartments;

import com.example.grant20.HelloApplication;
import com.example.grant20.controllers.MainController;
import com.example.grant20.models.*;
import com.example.grant20.models.dataModel.Apartment;
import com.example.grant20.models.dataModel.House;
import com.example.grant20.models.dataModel.User;
import com.example.grant20.models.DB.DBConnect;
import com.example.grant20.models.DB.Query;
import com.example.grant20.models.features.TableFilterGenerator;
import com.example.grant20.models.features.TableViewGenerator;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ApartmentController {
    User profile;
    @FXML
    TableView<Apartment> table;
    ObservableList<Apartment> list;
    Apartment selected;
    @FXML
    private AnchorPane apart;

    @FXML
    private Button changeApartmentButton;

    @FXML
    private Button createApartmentButton;

    @FXML
    private Button deleteApartmentButton;

    @FXML
    private TextField filterSection;

    @FXML
    private TextField filterStage;

    @FXML
    private TextField filterStatus;

    @FXML
    private TextField filterTo;

    @FXML
    private Button goBackButton;

    @FXML
    private TextField levensteinTextField;

    @FXML
    private Pagination pagination;

    @FXML
    private Button paginationToLast;

    @FXML
    private Button paginationToStart;

    @FXML
    void toLastPage(ActionEvent event) {
        pagination.setCurrentPageIndex(pagination.getPageCount()-1);
    }

    @FXML
    void toStartPage(ActionEvent event) {
        pagination.setCurrentPageIndex(0);
    }
    @FXML
    void changeApartment(ActionEvent event) {
        HelloApplication.changeMainPage("add_change_apartment.fxml",new AddApartmentController(this,selected));
    }

    @FXML
    void createApartment(ActionEvent event) {
        HelloApplication.changeMainPage("add_change_apartment.fxml",new AddApartmentController(this));
    }
    @FXML
    void deleteApartment(ActionEvent event) {
        if (selected!=null) {
            MyAlert alert = new MyAlert("Вы действительно хотите удалить запись №" + selected.getId() + "?");
            if (alert.getAlert() == ButtonType.YES) {
                ArrayList<Apartment> bufList = new ArrayList<>(table.getItems().stream().toList());
                bufList.remove(selected);
                table.setItems(FXCollections.observableArrayList(bufList));
                DBConnect.executePreparedModificationQuery(Query.deleteApartmentById, new ArrayList(Arrays.asList(selected.getId() + "")));
            }
        }
    }
    @FXML
    void goToMainPage(ActionEvent event) {
        HelloApplication.changeMainPage("main.fxml",new MainController(profile));
    }

    @FXML
    public void initialize() {
        ResultSet resultSet = DBConnect.getDBConnect().executeSelect(Query.getApartments);
        ObservableList<Apartment> items = FXCollections.observableArrayList();
        try {
            while (resultSet.next()) {
                items.add(new Apartment(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Apartment list creation error");
            throw new RuntimeException(e);
        }
        FilteredList<Apartment> filteredItems = new FilteredList<>(items,p->true);

        TableView<Apartment> apartmentTable = new TableViewGenerator<Apartment>(Apartment.class,filteredItems,0,10).getTable();
        table = apartmentTable;
        list = table.getItems();
        //фильтрация
        FilteredList<Apartment> mainList = new FilteredList(list);
        TableFilterGenerator<Apartment> filter= new TableFilterGenerator(table,mainList);
        filter.addNewEqualsFilter(filterTo,"houseName");
        filter.addNewEqualsFilter(filterSection,"entrance");
        filter.addNewEqualsFilter(filterStage,"floor");
        filter.addNewEqualsFilter(filterStatus,"statusSale");
        //фильтрация по расстоянию Леввенштейна
        TableFilterGenerator<Apartment> foundFilter = new TableFilterGenerator(table,mainList);
        foundFilter.addNewLevenshteinFilter(levensteinTextField);
        //установка фильтров
        filter.setFiltersToTable();
        foundFilter.setFiltersToTable();
        pagination.setPageFactory(this::createPage);
        pagination.setPageCount(list.size()/20+1);
        table.getItems().addListener(new ListChangeListener<Apartment>() {
            @Override
            public void onChanged(Change<? extends Apartment> change) {
                pagination.setPageFactory(this::createPage);
                pagination.setPageCount(list.size()/20+1);
            }

            private Node createPage(Integer integer) {
                int fromIndex = Math.min(pagination.getCurrentPageIndex() * 20, table.getItems().size());
                int toIndex = Math.min(fromIndex + 20, table.getItems().size());
                FilteredList<Apartment> list2 = new FilteredList<>(FXCollections.observableArrayList(table.getItems().subList(fromIndex,toIndex)));
                TableView<Apartment> table2 = new TableViewGenerator<>(Apartment.class,list2,0,10).getTable();
                table2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selected = newValue);
                return table2;
            }
        });

    }

    private Node createPage(Integer integer) {

        int fromIndex = Math.min(pagination.getCurrentPageIndex() * 20, table.getItems().size());
        int toIndex = Math.min(fromIndex + 20, table.getItems().size());
        FilteredList<Apartment> list2 = new FilteredList<>(FXCollections.observableArrayList(table.getItems().subList(fromIndex, toIndex)));
        TableView<Apartment> table2 = new TableViewGenerator<>(Apartment.class, list2,0,10).getTable();
        table2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selected = newValue);
        return table2;
    }
    public ApartmentController(User user){
        profile = user;
    }
}

