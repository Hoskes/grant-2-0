package com.example.grant20.models.dataModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EstimatedCost {
    String complexName;
    String houseNumber;
    String statusSale;
    int floor;
    int cost;
    int apartmentId;
    int apartmentNumber;
    float area;
    int rooms;
    int apartmentAddedValue;
    int houseId;
    int houseAddedValue;
    int houseBuildingCosts;
    int complexId;
    int complexAddedValue;
    int complexBuildingCosts;

    public EstimatedCost(int apartmentId, int apartmentNumber, float area, int rooms,
                         String statusSale, int apartmentAddedValue, int houseId, String houseNumber,
                         int houseAddedValue, int houseBuildingCosts, int complexId, String complexName,
                         int complexAddedValue, int complexBuildingCosts) {
        this.apartmentId = apartmentId;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.rooms = rooms;
        this.statusSale = statusSale;
        this.apartmentAddedValue = apartmentAddedValue;
        this.houseId = houseId;
        this.houseNumber = houseNumber;
        this.houseAddedValue = houseAddedValue;
        this.houseBuildingCosts = houseBuildingCosts;
        this.complexId = complexId;
        this.complexName = complexName;
        this.complexAddedValue = complexAddedValue;
        this.complexBuildingCosts = complexBuildingCosts;
    }

    public EstimatedCost(ResultSet resultSet) throws SQLException {
        this.apartmentId = resultSet.getInt(1);
        this.apartmentNumber = resultSet.getInt(2);
        this.area = resultSet.getFloat(3);
        this.rooms = resultSet.getInt(4);
        this.statusSale = resultSet.getString(5);
        this.apartmentAddedValue = resultSet.getInt(6);
        this.houseId = resultSet.getInt(7);
        this.houseNumber = resultSet.getString(8);
        this.houseAddedValue = resultSet.getInt(9);
        this.houseBuildingCosts = resultSet.getInt(10);
        this.complexId = resultSet.getInt(11);
        this.complexName = resultSet.getString(12);
        this.complexAddedValue = resultSet.getInt(13);
        this.complexBuildingCosts = resultSet.getInt(14);
        this.floor = resultSet.getInt(15);
        this.cost = resultSet.getInt(16);
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getStatusSale() {
        return statusSale;
    }

    public void setStatusSale(String statusSale) {
        this.statusSale = statusSale;
    }

    public int getApartmentAddedValue() {
        return apartmentAddedValue;
    }

    public void setApartmentAddedValue(int apartmentAddedValue) {
        this.apartmentAddedValue = apartmentAddedValue;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getHouseAddedValue() {
        return houseAddedValue;
    }

    public void setHouseAddedValue(int houseAddedValue) {
        this.houseAddedValue = houseAddedValue;
    }

    public int getHouseBuildingCosts() {
        return houseBuildingCosts;
    }

    public void setHouseBuildingCosts(int houseBuildingCosts) {
        this.houseBuildingCosts = houseBuildingCosts;
    }

    public int getComplexId() {
        return complexId;
    }

    public void setComplexId(int complexId) {
        this.complexId = complexId;
    }

    public String getComplexName() {
        return complexName;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }

    public int getComplexAddedValue() {
        return complexAddedValue;
    }

    public void setComplexAddedValue(int complexAddedValue) {
        this.complexAddedValue = complexAddedValue;
    }

    public int getComplexBuildingCosts() {
        return complexBuildingCosts;
    }

    public void setComplexBuildingCosts(int complexBuildingCosts) {
        this.complexBuildingCosts = complexBuildingCosts;
    }
}
