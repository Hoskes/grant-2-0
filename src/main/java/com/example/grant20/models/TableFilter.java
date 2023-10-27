package com.example.grant20.models;

import javafx.collections.transformation.FilteredList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.lang.reflect.Field;

public class TableFilter<T> {
    private TextField filterValue;
    private ChoiceBox<T> filterCategory;
    private FilteredList<T> filteredData;
    public TableFilter(TextField filterValue, TableFilter<T> filterData){
        filterValue.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate( person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if ((person.toString().toLowerCase().contains(lowerCaseFilter))) {
                    return true;
                } else if (person.toString().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }

                return false;
            });
        });
    }
    public void addFilter(){

    }
}
