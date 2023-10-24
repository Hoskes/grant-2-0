package com.example.grant20;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TableViewGenerator<T> {
    TableView<T> table;
    public TableViewGenerator(Class<T> clazz, ObservableList<T> list){
        table = new TableView<>();
        for (Field f:clazz.getDeclaredFields()) {
            TableColumn<T,String> col= new TableColumn<>(f.getName());
            col.setCellValueFactory(new PropertyValueFactory<T, String>(f.getName()));
            table.getColumns().add(col); //как-то поправить потом названия столбцов

        }
        table.getItems().addAll(list);

    }

    public TableView<T> getTable() {
        return table;
    }
}
