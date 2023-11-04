package com.example.grant20.models.dataModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Report {

    String apartmentNumber;
    int floor;
    String statusSale;
    int cost;
    String complexName;
    String houseNumber;

    public Report(String apartmentNumber, int floor, String statusSale, int cost, String complexName, String houseNumber) {
        this.apartmentNumber = apartmentNumber;
        this.floor = floor;
        this.statusSale = statusSale;
        this.cost = cost;
        this.complexName = complexName;
        this.houseNumber = houseNumber;
    }
    public Report(ResultSet resultSet) throws SQLException {
        this.apartmentNumber = resultSet.getString(1);
        this.floor = resultSet.getInt(2);
        this.statusSale = resultSet.getString(3);
        this.cost = resultSet.getInt(4);
        this.complexName = resultSet.getString(5);
        this.houseNumber = resultSet.getString(6);
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getStatusSale() {
        return statusSale;
    }

    public void setStatusSale(String statusSale) {
        this.statusSale = statusSale;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getComplexName() {
        return complexName;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
