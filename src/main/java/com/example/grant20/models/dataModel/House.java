package com.example.grant20.models.dataModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class House {
    int id;
    String complexName;
    String street;
    String number;
    String status;
    int countSold;
    int countNotSold;
    String addedValue;
    String buildingCost;


    public House(int id, String complexName, String street, String number, String status, int countSold, int countNotSold) {
        this.id = id;
        this.number = number;
        this.complexName = complexName;
        this.street = street;
        this.status = status;
        this.countSold = countSold;
        this.countNotSold = countNotSold;
    }
    public House(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt(1);
            this.complexName = resultSet.getString(2);
            this.street = resultSet.getString(3);
            this.number = resultSet.getString(4);
            this.status = resultSet.getString(5);
            this.countSold = resultSet.getInt(6);
            this.countNotSold = resultSet.getInt(7);
            this.addedValue = resultSet.getString(8);
            this.buildingCost = resultSet.getString(9);
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

    public int getCountSold() {
        return countSold;
    }

    public void setCountSold(int countSold) {
        this.countSold = countSold;
    }

    public int getCountNotSold() {
        return countNotSold;
    }

    public void setCountNotSold(int countNotSold) {
        this.countNotSold = countNotSold;
    }

    public String getAddedValue() {
        return addedValue;
    }

    public void setAddedValue(String addedValue) {
        this.addedValue = addedValue;
    }

    public String getBuildingCost() {
        return buildingCost;
    }

    public void setBuildingCost(String buildingCost) {
        this.buildingCost = buildingCost;
    }
}
