package com.example.grant20.models.features;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class TableViewGenerator<T> {
    TableView<T> table;

    public TableViewGenerator(Class<T> clazz, FilteredList<T> list) {
        table = new TableView<>();
        for (Field f : clazz.getDeclaredFields()) {
            TableColumn<T, String> col = new TableColumn<>(f.getName());
            col.setCellValueFactory(new PropertyValueFactory<T, String>(f.getName()));
            table.getColumns().add(col); //как-то поправить потом названия столбцов

        }
        table.getItems().addAll(list);
        table.setLayoutX(20);
        table.setLayoutY(20);
        table.setPrefHeight(350);
        table.setPrefWidth(700);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public TableViewGenerator(Class<T> clazz, FilteredList<T> list, int start, int end) {
        table = new TableView<>();
        for (int i = start; i < end - 1; i++) {
            Field f = clazz.getDeclaredFields()[i];
            TableColumn<T, String> col = new TableColumn<>(f.getName());
            col.setCellValueFactory(new PropertyValueFactory<T, String>(f.getName()));
            table.getColumns().add(col); //как-то поправить потом названия столбцов

        }
        table.getItems().addAll(list);
        table.setLayoutX(20);
        table.setLayoutY(20);
        table.setPrefHeight(350);
        table.setPrefWidth(700);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public TableView<T> getTable() {
        return table;
    }
}