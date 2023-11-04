package com.example.grant20.models.dataModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Apartment {
    int id;
    String houseName;
    int apartmentNumber;
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
        this.apartmentNumber = resultSet.getInt(3);
        this.address = resultSet.getString(4);
        this.area = resultSet.getInt(5);
        this.rooms = resultSet.getInt(6);
        this.entrance = resultSet.getInt(7);
        this.floor = resultSet.getInt(8);
        this.statusSale = resultSet.getString(9);
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

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
}
