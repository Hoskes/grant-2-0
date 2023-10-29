package com.example.grant20.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Apartment {
    int id;
    String houseName;
    String address;
    double area;
    int rooms;
    int entrance;
    int floor;
    String statusSale;

    public Apartment(int id, String houseName, String address, double area, int rooms, int entrance, int floor, String statusSale) {
        this.id = id;
        this.houseName = houseName;
        this.address = address;
        this.area = area;
        this.rooms = rooms;
        this.entrance = entrance;
        this.floor = floor;
        this.statusSale = statusSale;
    }
    public Apartment(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt(1);
        this.houseName = resultSet.getString(2);
        this.address = resultSet.getString(3);
        this.area = resultSet.getInt(4);
        this.rooms = resultSet.getInt(5);
        this.entrance = resultSet.getInt(6);
        this.floor = resultSet.getInt(7);
        this.statusSale = resultSet.getString(8);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getEntrance() {
        return entrance;
    }

    public void setEntrance(int entrance) {
        this.entrance = entrance;
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



    public int getAddedValue() {
        return addedValue;
    }

    public void setAddedValue(int addedValue) {
        this.addedValue = addedValue;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }



}
