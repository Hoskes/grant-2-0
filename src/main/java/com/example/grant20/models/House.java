package com.example.grant20.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class House {
    int id;
    String number;
    String status;
    String complexName;
    String street;
    int count_sold;
    int count_not_sold;


    public House(int id, String complexName, String street, String number, String status, int count_sold, int count_not_sold) {
        this.id = id;
        this.number = number;
        this.complexName = complexName;
        this.street = street;
        this.status = status;
        this.count_sold = count_sold;
        this.count_not_sold = count_not_sold;
    }
    public House(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt(1);
            this.complexName = resultSet.getString(2);
            this.street = resultSet.getString(3);
            this.number = resultSet.getString(4);
            this.status = resultSet.getString(5);
            this.count_sold = resultSet.getInt(6);
            this.count_not_sold = resultSet.getInt(7);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComplexName() {
        return complexName;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getCount_sold() {
        return count_sold;
    }

    public void setCount_sold(int count_sold) {
        this.count_sold = count_sold;
    }

    public int getCount_not_sold() {
        return count_not_sold;
    }

    public void setCount_not_sold(int count_not_sold) {
        this.count_not_sold = count_not_sold;
    }
}
